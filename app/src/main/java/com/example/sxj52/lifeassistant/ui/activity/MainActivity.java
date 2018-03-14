package com.example.sxj52.lifeassistant.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.adapter.WeatherAdapter;
import com.example.sxj52.lifeassistant.service.AutoUpdateService;
import com.example.sxj52.lifeassistant.ui.activity.fragment.NewsFragment;
import com.example.sxj52.lifeassistant.ui.activity.fragment.PersonFragment;
import com.example.sxj52.lifeassistant.ui.activity.fragment.WeatherFragment;
import com.example.sxj52.lifeassistant.utils.HttpUtil;
import com.example.sxj52.lifeassistant.view.tab.BarEntity;
import com.example.sxj52.lifeassistant.view.tab.BottomTabBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements BottomTabBar.OnSelectListener{
    private BottomTabBar tb ;
    private List<BarEntity> bars ;
    private PersonFragment personFragment ;
    private NewsFragment newsFragment ;
    private WeatherFragment weatherFragment;
    private FragmentManager manager ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        checkUser();
        initView();
        startService(new Intent(this, AutoUpdateService.class));
    }

    private void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        tb.setManager(manager);
        tb.setOnSelectListener(this);
        bars = new ArrayList<>();

//        bars.add(new BarEntity("段子",R.drawable.ic_textjoke_select,R.drawable.ic_textjoke_unselect));
//        bars.add(new BarEntity("趣图",R.drawable.ic_imagejoke_select,R.drawable.ic_imagejoke_unselect));
//        bars.add(new BarEntity("圈子",R.drawable.ic_dt_select,R.drawable.ic_dt_unselect));
        bars.add(new BarEntity("个人",R.drawable.ic_my_select,R.drawable.ic_my_unselect));
        bars.add(new BarEntity("主页",R.drawable.ic_home_select,R.drawable.ic_home_unselect));
        bars.add(new BarEntity("天气",R.drawable.ic_home_select,R.drawable.ic_home_unselect));
        tb.setBars(bars);
    }

    @Override
    public void onSelect(int position) {
        switch (position){
            case 0:
                if (personFragment==null){
                    personFragment = new PersonFragment();
                }
                tb.switchContent(personFragment);
                break;
            case 1:
                if (newsFragment==null){
                    newsFragment = new NewsFragment();
                }
                tb.switchContent(newsFragment);
                break;
            case 2:
                if (weatherFragment==null){
                    weatherFragment = new WeatherFragment();
                }
                tb.switchContent(weatherFragment);
                break;
//            case 3:
//                if (circleFragment==null){
//                    circleFragment = new CircleFragment();
//                }
//                tb.switchContent(circleFragment);
//                break;
//            case 4:
//                if (personFragment==null){
//                    personFragment = new PersonFragment();
//                }
//                tb.switchContent(personFragment);
//                break;
            default:
                break;
        }
    }

}
