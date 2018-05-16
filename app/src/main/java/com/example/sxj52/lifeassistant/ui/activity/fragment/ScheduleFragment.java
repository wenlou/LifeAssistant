package com.example.sxj52.lifeassistant.ui.activity.fragment;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.chat.activity.ADDDouteActivity;
import com.example.sxj52.lifeassistant.chat.activity.LoginActivity;
import com.example.sxj52.lifeassistant.chat.activity.MusicActivity;
import com.example.sxj52.lifeassistant.chat.activity.SuggestActivity;
import com.example.sxj52.lifeassistant.event.LoginSuccessdEvent;
import com.example.sxj52.lifeassistant.utils.AllInfo;
import com.example.sxj52.lifeassistant.utils.DataCleanManager;
import com.example.sxj52.lifeassistant.utils.DayInfo;
import com.example.sxj52.lifeassistant.utils.FileTool;
import com.example.sxj52.lifeassistant.utils.Info;
import com.example.sxj52.lifeassistant.view.ScheduleView;
import com.example.sxj52.lifeassistant.view.ShowDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;




public class ScheduleFragment extends BaseFragment{
    private static String yearKey  = "year";
    private static String monthKey = "month";
    private static String daykey   = "day";
    private static String hourkey  = "hour";
    private static String minuteKey = "minute";
    private static String dataKey  = "data";

    private ScheduleView scheduleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         setContentView(R.layout.fragment_su);
         initView();
         return getContentView();
    }

    private void initView() {
        scheduleView = (ScheduleView)findViewById(R.id.schedule_view);
        scheduleView.setAddRouteListener(new ScheduleView.AddRouteListener() {
            @Override
            public void addRoute(View view){
                if(view == null){
                    Toast.makeText(getActivity().getApplicationContext(),"请选择日期",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getActivity().getApplicationContext(), ADDDouteActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(yearKey,scheduleView.getCurrentYear());
                bundle.putInt(monthKey,scheduleView.getCurrentMonth());
                bundle.putInt(daykey,scheduleView.getSelectDay());
                intent.putExtras(bundle);
                startActivityForResult(intent,100);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("--->"+requestCode+" "+resultCode);
        if(requestCode == 100 && resultCode == 0){
            System.out.println("--->+"+requestCode+" "+resultCode+data);
            Bundle bundle = data.getExtras();
            int year = bundle.getInt(yearKey);
            int month = bundle.getInt(monthKey);
            int day = bundle.getInt(daykey);
            int hour = bundle.getInt(hourkey);
            int minute = bundle.getInt(minuteKey);
            String mydata = bundle.getString(dataKey);
            System.out.println("--->my"+year+" "+month+" "+day+" "+hour+" "+minute+" "+mydata);
            try {
                saveRouteData(year,month,day,hour,minute,mydata);
                scheduleView.mySelect(year,month,day);
                System.out.println("--->++"+requestCode+" "+resultCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //保存文件
    private void saveRouteData(int year,int month,int day
            ,int hour,int minute,String data) throws Exception {

        String infoKey = FileTool.getInfoKey(hour,minute);
        String dayinfoKey = FileTool.getDayInfoKey(year,month,day);

        AllInfo infos = FileTool.getAllInfo(getActivity().getApplicationContext());
        if(infos == null){infos = new AllInfo();}

        DayInfo dayInfo = infos.getDayRouteList(dayinfoKey);
        if(dayInfo == null){
            dayInfo = new DayInfo();
        }
        Info info = dayInfo.getInfo(infoKey);
        if(info == null){
            info = new Info();   //创建一个Info存储行程
        }
        info.setYear(year); info.setMonth(month); info.setDay(day);
        info.setHour(hour);info.setMinute(minute);
        info.setData(data);

        System.out.println("--->info.setData(data);"+info.getData());

        dayInfo.addInfo(infoKey,info);
        infos.addDayRouteList(dayinfoKey,dayInfo);

        FileTool.writeAllInfo(getActivity().getApplicationContext(),infos);

    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
