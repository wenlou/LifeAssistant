package com.example.sxj52.lifeassistant.http;



import com.example.sxj52.lifeassistant.http.api.NewsApi;
import com.example.sxj52.lifeassistant.utils.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhihao.wen on 2016/4/20.
 */
public class NetWorkUtil {
    private static OkHttpClient okHttpClient;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static NewsApi NewsApi;
    /**
     * 初始化okhttp
     */
    public static void initOkhttp() {
        if (okHttpClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        }

    }

    /**
     * 获取头条新闻
     *
     * @return
     */
    public static NewsApi getNewsApi() {
        initOkhttp();
        if (NewsApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(gsonConverterFactory)
                    .build();
            NewsApi = retrofit.create(NewsApi.class);
        }
        return NewsApi;
    }


}
