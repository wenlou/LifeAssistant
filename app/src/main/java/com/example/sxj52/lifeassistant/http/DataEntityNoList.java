package com.example.sxj52.lifeassistant.http;

import com.example.sxj52.lifeassistant.entity.BaseEntity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.google.gson.annotations.SerializedName;


/**
 * Created by zhihao.wen on 2016/11/3.
 */

public class DataEntityNoList<T> extends BaseEntity {
    @SerializedName("data")
    private NewsEntity data ;

    public NewsEntity getData() {
        return data;
    }

    public void setData(NewsEntity data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                ", data=" + data +
                '}';
    }
}
