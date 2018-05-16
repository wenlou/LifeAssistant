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
import com.example.sxj52.lifeassistant.chat.activity.LoginActivity;
import com.example.sxj52.lifeassistant.chat.activity.NewsLookActivity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.entity.WeatherEntity;
import com.example.sxj52.lifeassistant.http.ApiResponseWraperNoData;
import com.example.sxj52.lifeassistant.http.NetWorkUtil;
import com.example.sxj52.lifeassistant.http.RequestParam;
import com.example.sxj52.lifeassistant.utils.Constant;
import com.example.sxj52.lifeassistant.view.listview.CustomPtrFrameLayout;
import com.example.sxj52.lifeassistant.view.listview.LoadMoreListView;
import com.example.sxj52.lifeassistant.view.listview.PtrDefaultHandler;
import com.example.sxj52.lifeassistant.view.listview.PtrFrameLayout;

import java.util.ArrayList;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class NewsFragment extends BaseFragment implements BaseFragment.OnReloadDataListener{
    private CustomPtrFrameLayout customPtrFrameLayout ;
    private LoadMoreListView listView ;
    private Subscription sb;
    private ImageJokeAdapter adapter ;
    private ArrayList<NewsEntity> imageJokeEntities ;
    private Observer<NewsEntity> obXW ;
    private int currentPage = 1 ;
    private int pagetSize =10 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         setContentView(R.layout.fragment_new_image_joke);
         initView();
         initData();
         return getContentView() ;
    }

    private void initData() {

        obXW = new Observer<NewsEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                showErrorView("数据加载失败,点击重试",R.drawable.ic_error);
            }

            @Override
            public void onNext(NewsEntity newsEntity) {
                if (currentPage==1){
                    imageJokeEntities.clear();
                }
                imageJokeEntities.addAll(newsEntity.getResult().getData());
                adapter.notifyDataSetChanged();
                customPtrFrameLayout.refreshComplete();
                listView.getMoreComplete();
                showContentView();
                if (newsEntity.getResult().getData().size()<pagetSize){
                    listView.setNoMore();
                }
                Log.e("main","==="+newsEntity.getResult().getData().toString());

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
                currentPage=1 ;
                request(false);
            }
        });
        imageJokeEntities = new ArrayList<>();
        listView.setOnGetMoreListener(new LoadMoreListView.OnGetMoreListener() {
            @Override
            public void onGetMore() {
                currentPage++;
                request(false);
            }
        });
        adapter = new ImageJokeAdapter(getActivity(),imageJokeEntities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), NewsLookActivity.class);
                intent.putExtra("newsbean",adapter.getItem(i));
                startActivity(intent);
            }
        });
        setOnReloadDataListener(this);
    }

    @Override
    public void request(boolean isRefresh) {
        if (isRefresh){
            showLoadingPage("正在加载中...",R.drawable.ic_loading);
        }
        RequestParam param = new RequestParam();
        param.put("key", Constant.KEY);
        param.put("type","top");
        param.put("pagesize",pagetSize);
        param.put("page",currentPage);
        sb = NetWorkUtil.getNewsApi()
                .getImageJoke(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obXW);



    }
}
