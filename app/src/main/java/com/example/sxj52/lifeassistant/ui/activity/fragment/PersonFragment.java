package com.example.sxj52.lifeassistant.ui.activity.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.chat.activity.ColorActivity;
import com.example.sxj52.lifeassistant.chat.activity.LoginActivity;
import com.example.sxj52.lifeassistant.chat.activity.MapActivity;
import com.example.sxj52.lifeassistant.chat.activity.MusicActivity;
import com.example.sxj52.lifeassistant.chat.activity.StopWatchActivity;
import com.example.sxj52.lifeassistant.chat.activity.SuggestActivity;
import com.example.sxj52.lifeassistant.chat.activity.ToolsActivity;
import com.example.sxj52.lifeassistant.event.LoginSuccessdEvent;
import com.example.sxj52.lifeassistant.utils.DataCleanManager;
import com.example.sxj52.lifeassistant.view.ShowDialog;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;



public class PersonFragment extends BaseFragment implements BaseFragment.OnReloadDataListener, View.OnClickListener {
//    private Subscription sb ;
//    private Observer<ApiResponseWraperNoList<WeatherEntity>> obXW ;
    private ShowDialog dialog ;
    private View loginOut ;
    private TextView nameView;
    private ImageView avatar ;
    private TextView cacheSizeTv ;
    private String cacheSize ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         setContentView(R.layout.fragment_person);
         EventBus.getDefault().register(this);
         initView();
//         initData();
         return getContentView();
    }

    private void initView() {
        dialog = new ShowDialog();
        loginOut =  findViewById(R.id.login_out) ;
        loginOut.setOnClickListener(this);
        cacheSizeTv = (TextView) findViewById(R.id.cacheSize);
        refreshCache();
        findViewById(R.id.clear_cache).setOnClickListener(this);
        findViewById(R.id.suggest).setOnClickListener(this);
        findViewById(R.id.tools).setOnClickListener(this);
        nameView = (TextView) findViewById(R.id.nameView);
        avatar = (ImageView) findViewById(R.id.avatar);
        avatar.setOnClickListener(this);
        checkUser();
    }


    @Override
    public void request(boolean isRefresh) {
        if (isRefresh){
            showLoadingPage("正在加载中...",R.drawable.ic_loading);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.login_out){
            dialog.show(getActivity(), "", "是否确认注销？", new ShowDialog.OnBottomClickListener() {
                @Override
                public void positive() {
                    AVUser.getCurrentUser().logOut();
                    EventBus.getDefault().post(new LoginSuccessdEvent());
                }
                @Override
                public void negtive() {

                }
            });
        }else if (v.getId()==avatar.getId()) {
            if (AVUser.getCurrentUser() == null) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        }
        else if (v.getId()==R.id.clear_cache){
            dialog.show(getActivity(), "", "是否清除缓存？", new ShowDialog.OnBottomClickListener() {
                @Override
                public void positive() {
                    DataCleanManager.cleanApplicationData(getActivity());
                    refreshCache();
                }
                @Override
                public void negtive() {

                }
            });

        }else if (v.getId()==R.id.suggest){
            startActivity(new Intent(getActivity(), SuggestActivity.class));
        }
        else if (v.getId()==R.id.tools){
            startActivity(new Intent(getActivity(), ToolsActivity.class));
        }

    }
    @Subscribe
    public  void onEventMainThread(LoginSuccessdEvent event){
        checkUser();
    }
    public void checkUser(){
        AVUser user = AVUser.getCurrentUser() ;
        if(user==null){
            loginOut.setVisibility(View.GONE);
            nameView.setText("请登录");
            avatar.setImageResource(R.drawable.default_head);
            return;
        }
        user.fetchInBackground(new GetCallback<AVObject>() {
            @Override
            public void done(AVObject avObject, AVException e) {
                AVUser u = (AVUser) avObject;
                if (u==null){
                    loginOut.setVisibility(View.GONE);
                    nameView.setText("请登录");
                    avatar.setImageResource(R.drawable.default_head);
                }else {
                    nameView.setText(u.getUsername());
                    loginOut.setVisibility(View.VISIBLE);
                    if (u.getAVFile("avatar")==null){
                        avatar.setImageResource(R.drawable.default_head);
                    }else {
                        AVFile file = user.getAVFile("avatar");
                        if (file != null) {
                            Glide.with(getActivity()).load(file.getUrl()).placeholder(R.drawable.default_head).into(avatar);
                        }else {
                            Glide.with(getActivity()).load(R.drawable.default_head).into(avatar);
                        }
                    }

                }

            }
        });

    }

    public void refreshCache(){
        try {
            cacheSize=  DataCleanManager.getTotalCacheSize(getActivity());
            cacheSizeTv.setText(cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            refreshCache();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
