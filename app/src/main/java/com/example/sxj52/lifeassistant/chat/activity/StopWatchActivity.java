package com.example.sxj52.lifeassistant.chat.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.ui.activity.BaseActivity;
import com.example.sxj52.lifeassistant.view.SelectRemindCyclePopup;
import com.example.sxj52.lifeassistant.view.SelectRemindWayPopup;
import com.loonggg.lib.alarmmanager.clock.AlarmManagerUtil;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * author：Administrator on 2016/12/21 14:06
 * description:文件说明
 * version:版本
 */
public class StopWatchActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        setTitle("秒表");
        setBackView();
//        setRightImage(R.drawable.icon_select, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
    }
}
