package com.example.sxj52.lifeassistant;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;

import org.litepal.LitePal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sxj on 2018/2/18.
 */

public class App extends Application {
    public String appId = "iCjhvj7SYY70OwYy4xUHcqF3-gzGzoHsz";
    public String appKey = "YpRBahxti8pXX45yq0IUgrC2";
    public static final String LIKES = "likes";
    public static final String STATUS_DETAIL = "StatusDetail";
    public static final String DETAIL_ID = "detailId";
    public static final String CREATED_AT = "createdAt";
    public static final String FOLLOWER = "follower";
    public static final String FOLLOWEE = "followee";

    public static String cacheDir = "";
    public static Context mAppContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this,appId,appKey);
         LitePal.initialize(this);
//        AVIMMessageManager.registerDefaultMessageHandler(new CustomMessageHandler());


        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();

        }
        else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }
    public static Map<String, AVUser> userCache = new HashMap<>();

    public static void regiserUser(AVUser user) {
        userCache.put(user.getObjectId(), user);
    }

    public static void registerBatchUser(List<AVUser> users) {
        for (AVUser user : users) {
            regiserUser(user);
        }
    }

    public static AVUser lookupUser(String userId) {
        return userCache.get(userId);
    }


    private boolean ExistSDCard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        }
        else {
            return false;
        }
    }


}
