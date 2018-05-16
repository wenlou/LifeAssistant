package com.example.sxj52.lifeassistant.http;

import com.example.sxj52.lifeassistant.entity.BaseEntity;
import com.google.gson.annotations.SerializedName;



public class ApiResponseWraper<T> extends BaseEntity {
    @SerializedName("reason")
    private String reason ;
    @SerializedName("error_code")
    private String error_code ;
    @SerializedName("result")
    private DataEntity<T> result ;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public DataEntity<T> getResult() {
        return result;
    }

    public void setResult(DataEntity<T> result) {
        this.result = result;
    }
}
