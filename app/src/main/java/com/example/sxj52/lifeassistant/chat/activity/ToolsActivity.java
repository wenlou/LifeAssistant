package com.example.sxj52.lifeassistant.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;
import com.baidu.mapapi.map.Marker;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.event.LoginSuccessdEvent;
import com.example.sxj52.lifeassistant.ui.activity.BaseActivity;
import com.example.sxj52.lifeassistant.utils.DataCleanManager;
import com.example.sxj52.lifeassistant.view.ShowDialog;

import org.greenrobot.eventbus.EventBus;


/**
 * author：Administrator on 2016/12/21 14:06
 * description:文件说明
 * version:版本
 */
public class ToolsActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        setTitle("工具");
        initview();
        setBackView();

    }

    private void initview() {
        findViewById(R.id.music).setOnClickListener(this);
        findViewById(R.id.ct).setOnClickListener(this);
        findViewById(R.id.color).setOnClickListener(this);
        findViewById(R.id.stopwatch).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.music){
           startActivity(new Intent(this,MusicActivity.class));
       }
       else if (v.getId()==R.id.ct){
            startActivity(new Intent(this, MapActivity.class));
        }
        else if (v.getId()==R.id.color){
            startActivity(new Intent(this, ColorActivity.class));
        }
       else if (v.getId()==R.id.stopwatch){
           startActivity(new Intent(this, StopWatchActivity.class));
       }

    }
}
