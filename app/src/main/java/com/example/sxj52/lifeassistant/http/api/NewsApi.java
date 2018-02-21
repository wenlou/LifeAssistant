package com.example.sxj52.lifeassistant.http.api;

import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.http.ApiResponseWraperNoData;
import com.example.sxj52.lifeassistant.http.RequestParam;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by zhihao.wen on 2016/4/20.
 */
public interface NewsApi {
    @GET("toutiao/index")
    Observable<NewsEntity> getImageJoke(@QueryMap RequestParam param);
}
