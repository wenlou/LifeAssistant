package com.example.sxj52.lifeassistant.ui.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.adapter.ImageJokeAdapter;
import com.example.sxj52.lifeassistant.adapter.WeatherAdapter;
import com.example.sxj52.lifeassistant.chat.activity.NewsLookActivity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.entity.WeatherEntity;
import com.example.sxj52.lifeassistant.http.NetWorkUtil;
import com.example.sxj52.lifeassistant.http.RequestParam;
import com.example.sxj52.lifeassistant.utils.Constant;
import com.example.sxj52.lifeassistant.view.listview.CustomPtrFrameLayout;
import com.example.sxj52.lifeassistant.view.listview.LoadMoreListView;
import com.example.sxj52.lifeassistant.view.listview.PtrDefaultHandler;
import com.example.sxj52.lifeassistant.view.listview.PtrFrameLayout;

import java.util.ArrayList;
import java.util.Collection;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setContentView(R.layout.fragment_weather);
        initData();
        initView();
       // initData();
        return getContentView();
    }

    private void initData() {
        obXW = new Observer<WeatherEntity>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d("tttt",e.getMessage());
                showErrorView("数据加载失败,点击重试", R.drawable.ic_error);
            }

            @Override
            public void onNext(WeatherEntity weatherEntity) {
                 weatherEntities.add(weatherEntity);
                adapter.notifyDataSetChanged();
                customPtrFrameLayout.refreshComplete();
                listView.getMoreComplete();
                showContentView();
                Log.e("main", "===" + weatherEntity.getHeWeather5().get(0).toString());
            }
        };
        request(true);
    }

    private void initView() {
        listView = (LoadMoreListView) findViewById(R.id.list);
        customPtrFrameLayout = (CustomPtrFrameLayout) findViewById(R.id.contentView);
        customPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
//                currentPage=1 ;
                request(false);
            }
        });
        weatherEntities=new ArrayList<>();
        //weatherEntity1= new WeatherEntity();
//        listView.setOnGetMoreListener(new LoadMoreListView.OnGetMoreListener() {
//            @Override
//            public void onGetMore() {
//                currentPage++;
//                request(false);
//            }
//        });

        adapter = new WeatherAdapter(getActivity(), weatherEntities);
        listView.setAdapter(adapter);
        setOnReloadDataListener(this);
    }

    @Override
    public void request(boolean isRefresh) {
        if (isRefresh) {
            showLoadingPage("正在加载中...", R.drawable.ic_loading);
        }


        RequestParam param1 = new RequestParam();
        param1.put("city", "beijing");
        param1.put("key", Constant.WKEY);
        sb = NetWorkUtil.getWeatherApi()
                .mWeatherAPI(param1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obXW);

    }
}
