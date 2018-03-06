package com.example.sxj52.lifeassistant.chat.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.event.LoginSuccessdEvent;
import com.example.sxj52.lifeassistant.ui.activity.BaseActivity;
import com.example.sxj52.lifeassistant.utils.GlideCircleTransform;
import com.example.sxj52.lifeassistant.utils.PermissionUtils;
import com.example.sxj52.lifeassistant.view.LoadingDialog;


import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.utils.PhotoPickerIntent;


/**
 * Created by sxj on 2018/2/19.
 */

public class RegestActivity extends BaseActivity implements View.OnClickListener,ActivityCompat.OnRequestPermissionsResultCallback {
    private EditText username;
    private EditText password;
    private EditText passwordConfirm;
    private EditText email;
    private String path = null;
    private int REQUEST_CODE = 100;
    private ImageView imageView;
    private LoadingDialog dialog ;
    private View viewPart ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setBackView();
        setTitle("新用户注册");
        initView();
    }
    private PermissionUtils.PermissionGrant mPermissionGrant = new PermissionUtils.PermissionGrant() {
        @Override
        public void onPermissionGranted(int requestCode) {
            switch (requestCode) {
                case PermissionUtils.CODE_CAMERA:
                    Toast.makeText(RegestActivity.this, "Result Permission Grant CODE_CAMERA", Toast.LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_READ_EXTERNAL_STORAGE:
                    Toast.makeText(RegestActivity.this, "Result Permission Grant CODE_READ_EXTERNAL_STORAGE", Toast.LENGTH_SHORT).show();
                    break;
                case PermissionUtils.CODE_WRITE_EXTERNAL_STORAGE:
                    Toast.makeText(RegestActivity.this, "Result Permission Grant CODE_WRITE_EXTERNAL_STORAGE", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
    private void upload() {
        PermissionUtils.requestPermission(this, PermissionUtils.CODE_CAMERA, mPermissionGrant);
        PhotoPickerIntent intent = new PhotoPickerIntent(RegestActivity.this);
        intent.setPhotoCount(9);
        intent.setShowCamera(true);
        startActivityForResult(intent, REQUEST_CODE);
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        PermissionUtils.requestPermissionsResult(this, requestCode, permissions, grantResults, mPermissionGrant);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                ArrayList<String> photos =
                        data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                if (photos == null) {
                    return;
                }
                path = photos.get(0);
                if (!TextUtils.isEmpty(path)) {
                    Glide.with(RegestActivity.this).load(new File(path)).placeholder(R.drawable.default_head).transform(new GlideCircleTransform(RegestActivity.this)).into(imageView);
                }
            }
        }
    }

    private void register() {
        String name = username.getText().toString();
        String pass = password.getText().toString();
        String passConfirm = passwordConfirm.getText().toString();
        String em=email.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(RegestActivity.this, "用户名不能为空！", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(RegestActivity.this, "密码不能为空！", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passConfirm)) {
            Toast.makeText(RegestActivity.this, "请再次确认密码！", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(em)) {
            Toast.makeText(RegestActivity.this, "邮箱不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        if (!em.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            Toast.makeText(RegestActivity.this, "邮箱格式错误", Toast.LENGTH_LONG).show();
            return;
        }
        if (!pass.equals(passConfirm)) {
            Toast.makeText(RegestActivity.this, "两次输入的密码不一致！", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(path)){
            Toast.makeText(RegestActivity.this, "请上传头像！", Toast.LENGTH_LONG).show();
            return;
        }
        dialog.show();
        dialog.setMessage("正在注册");
        AVUser user = new AVUser();
        user.setUsername(name);// 设置用户名
        user.setPassword(pass);// 设置密码
        user.setEmail(em);

        if (!TextUtils.isEmpty(path)) {
            try {
                AVFile file = AVFile.withAbsoluteLocalPath("avtar.jpg", path);
                user.put("avatar", file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                dialog.dismiss();
                if (e == null) {
                    // 注册成功
                    startActivity(new Intent(RegestActivity.this,LoginActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegestActivity.this, e.getMessage()+"注册失败，请稍后重试！", Toast.LENGTH_LONG).show();
                    // 失败的原因可能有多种，常见的是用户名已经存在。
                }
            }
        });
    }

    private void initView() {
        username =  findViewById(R.id.username);
        password =  findViewById(R.id.password);
        passwordConfirm =  findViewById(R.id.passwordConfirm);
        email=findViewById(R.id.email);
        imageView = findViewById(R.id.image);
        imageView.setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
        dialog = new LoadingDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        setRightImage(R.drawable.icon_select, (view)-> {
                register();
        });
        viewPart = findViewById(R.id.view_part);
        password.getViewTreeObserver().addOnGlobalLayoutListener(()->{
            //当键盘弹出隐藏的时候会 调用此方法。

                Rect r = new Rect();
                //获取当前界面可视部分
                RegestActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //获取屏幕的高度
                int screenHeight =  RegestActivity.this.getWindow().getDecorView().getRootView().getHeight();
                //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
                int heightDifference = screenHeight - r.bottom;
                if (heightDifference>0){
                    viewPart.setTranslationY(-60);
                }else {
                    viewPart.setTranslationY(60);
                }

        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == imageView.getId()) {
            upload();
        }
    }
}
