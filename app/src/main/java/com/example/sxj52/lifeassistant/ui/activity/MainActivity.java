package com.example.sxj52.lifeassistant.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.adapter.WeatherAdapter;
import com.example.sxj52.lifeassistant.chat.activity.ChooseareaActivity;
import com.example.sxj52.lifeassistant.service.AutoUpdateService;
import com.example.sxj52.lifeassistant.ui.activity.fragment.NewsFragment;
import com.example.sxj52.lifeassistant.ui.activity.fragment.PersonFragment;
import com.example.sxj52.lifeassistant.ui.activity.fragment.ScheduleFragment;
import com.example.sxj52.lifeassistant.ui.activity.fragment.WeatherFragment;
import com.example.sxj52.lifeassistant.utils.HttpUtil;
import com.example.sxj52.lifeassistant.view.tab.BarEntity;
import com.example.sxj52.lifeassistant.view.tab.BottomTabBar;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends BaseActivity implements BottomTabBar.OnSelectListener{
    private BottomTabBar tb ;
    private List<BarEntity> bars ;
    private PersonFragment personFragment ;
    private NewsFragment newsFragment ;
    private WeatherFragment weatherFragment;
    private ScheduleFragment scheduleFragment;
    private FragmentManager manager ;
    public LocationClient mLocationClient;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        checkUser();
        initView();
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String [] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        } else {
            requestLocation();
        }
        startService(new Intent(this, AutoUpdateService.class));
    }

    private void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        tb.setManager(manager);
        tb.setOnSelectListener(this);
        bars = new ArrayList<>();

        bars.add(new BarEntity("新闻",R.drawable.news_1,R.drawable.news));
        bars.add(new BarEntity("天气",R.drawable.tianqi_1,R.drawable.tianqi));
        bars.add(new BarEntity("日程提醒",R.drawable.rl1,R.drawable.rl));
        bars.add(new BarEntity("个人",R.drawable.ic_my_select,R.drawable.ic_my_unselect));

        tb.setBars(bars);
    }

    @Override
    public void onSelect(int position) {
        switch (position){
            case 0:
                if (newsFragment==null){
                    newsFragment = new NewsFragment();
                }
                tb.switchContent(newsFragment);
                break;
            case 1:
                if (weatherFragment==null){
                    weatherFragment = new WeatherFragment();
                }
                tb.switchContent(weatherFragment);
                break;
            case 2:
                if (scheduleFragment==null){
                    scheduleFragment = new ScheduleFragment();
                }
                tb.switchContent(scheduleFragment);
                break;
            case 3:
                if (personFragment==null){
                    personFragment = new PersonFragment();
                }
                tb.switchContent(personFragment);
                break;
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

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                } else {
                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            String cityName = prefs.getString("city_name", "");
            Log.d("9999999",cityName);
            if(cityName.equals("")){
                String city=location.getCity();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MainActivity.this).edit();
                editor.putString("city_name", city);
                editor.apply();
            }

        }

    }

}
