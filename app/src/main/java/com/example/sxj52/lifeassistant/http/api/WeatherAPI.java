package com.example.sxj52.lifeassistant.http.api;

import com.example.sxj52.lifeassistant.entity.WeatherEntity;
import com.example.sxj52.lifeassistant.http.RequestParam;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface WeatherAPI {
//
//    @SerializedName("HeWeather data service 3.0") @Expose
//    public List<Weather> mHeWeatherDataService30s
//            = new ArrayList<>();
    @GET("weather")
    Observable<WeatherEntity> mWeatherAPI(@QueryMap RequestParam param);
}
