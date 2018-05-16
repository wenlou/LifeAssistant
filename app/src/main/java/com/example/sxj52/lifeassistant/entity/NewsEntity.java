package com.example.sxj52.lifeassistant.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NewsEntity extends BaseEntity{

    @SerializedName("uniquekey")
    private String uniquekey;
    @SerializedName("title")
    private String title;
    @SerializedName("date")
    private String date;
    @SerializedName("category")
    private String category;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail_pic_s")
    private String thumbnail_pic_s;
    @SerializedName("thumbnail_pic_s02")
    private String thumbnail_pic_s02;
    @SerializedName("thumbnail_pic_s03")
    private String thumbnail_pic_s03;
    @SerializedName("author_name")
    private String author_name;

    @SerializedName("reason")
    private String reason;
    @SerializedName("result")
    private ResultBean result;
    @SerializedName("error_code")
    private int errorCode;

    public static NewsEntity objectFromData(String str) {

        return new Gson().fromJson(str, NewsEntity.class);
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "uniquekey='" + uniquekey + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public static class ResultBean {



        @SerializedName("stat")
        private String stat;
        @SerializedName("data")
        private List<NewsEntity> data;

        public static ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, ResultBean.class);
        }

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<NewsEntity> getData() {
            return data;
        }

        public void setData(List<NewsEntity> data) {
            this.data = data;
        }
    }
}
