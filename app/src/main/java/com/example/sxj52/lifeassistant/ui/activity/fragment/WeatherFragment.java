package com.example.sxj52.lifeassistant.ui.activity.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.adapter.ImageJokeAdapter;
import com.example.sxj52.lifeassistant.adapter.WeatherAdapter;
import com.example.sxj52.lifeassistant.chat.activity.NewsLookActivity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.entity.WeatherEntity;
import com.example.sxj52.lifeassistant.http.NetWorkUtil;
import com.example.sxj52.lifeassistant.http.RequestParam;
import com.example.sxj52.lifeassistant.service.AutoUpdateService;
import com.example.sxj52.lifeassistant.ui.activity.MainActivity;
import com.example.sxj52.lifeassistant.utils.ACache;
import com.example.sxj52.lifeassistant.utils.Constant;
import com.example.sxj52.lifeassistant.utils.HttpUtil;
import com.example.sxj52.lifeassistant.view.listview.CustomPtrFrameLayout;
import com.example.sxj52.lifeassistant.view.listview.LoadMoreListView;
import com.example.sxj52.lifeassistant.view.listview.PtrDefaultHandler;
import com.example.sxj52.lifeassistant.view.listview.PtrFrameLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhihao.wen on 2016/11/3.
 */

public class WeatherFragment extends BaseFragment implements BaseFragment.OnReloadDataListener {
    private CustomPtrFrameLayout customPtrFrameLayout;
    private LoadMoreListView listView;
    private Subscription sb;
    private WeatherAdapter adapter;
    private WeatherEntity weatherEntity1;
    private ArrayList<WeatherEntity> weatherEntities;
    private Observer<WeatherEntity> obXW;
    private ACache aCache;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_weather);
        initData();
        initView();
        return getContentView();
    }

    private void initData() {
        obXW = new Observer<WeatherEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                showErrorView("数据加载失败,点击重试", R.drawable.ic_error);
            }

            @Override
            public void onNext(WeatherEntity weatherEntity) {
                weatherEntities.clear();
                 weatherEntities.add(weatherEntity);
                 adapter.notifyDataSetChanged();
                 customPtrFrameLayout.refreshComplete();
                 listView.getMoreComplete();
                 showContentView();
            }
        };
        WeatherEntity weatherEntity1 = null;
        try {
            weatherEntity1=(WeatherEntity) aCache.getAsObject("WeatherData");
        } catch (Exception e) {

        }
        if(weatherEntity1!=null) {
            request(false);
           sb= Observable.just(weatherEntity1).subscribe(obXW);
        }

        else{
            request(true);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        request(true);
    }

    private void initView() {
        listView = (LoadMoreListView) findViewById(R.id.list);
        customPtrFrameLayout = (CustomPtrFrameLayout) findViewById(R.id.contentView);
        customPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                request(false);
            }
        });
        weatherEntities=new ArrayList<>();

        adapter = new WeatherAdapter(getActivity(), weatherEntities);
        listView.setAdapter(adapter);
        setOnReloadDataListener(this);
    }

    @Override
    public void request(boolean isRefresh) {
        if (isRefresh) {
            showLoadingPage("正在加载中...", R.drawable.ic_loading);
        }

        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String cityName = prefs.getString("city_name", "");
        if(cityName.equals("")){
            Toast.makeText(getContext(),"定位失败，加载默认城市",Toast.LENGTH_SHORT).show();
            cityName="济南";
        }
        RequestParam param1 = new RequestParam();
        param1.put("city", cityName);
        param1.put("key", Constant.WKEY);
        NetWorkUtil.getWeatherApi()
                .mWeatherAPI(param1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obXW);

    }
}
