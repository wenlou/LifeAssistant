package com.example.sxj52.lifeassistant.utils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sy on 2016/9/12.
 */
public class FileTool {

    private static final String Filename = "myschdule.route";

    //读取整个行程
    public static AllInfo getAllInfo(Context context){
        AllInfo allInfo = null;
        try {
            allInfo =readAllInfo(context);
        } catch (Exception e) {
            allInfo = new AllInfo();
            writeAllInfo(context,allInfo);
            allInfo = readAllInfo(context);
        }

        return allInfo;
    }
    //写入所有行程
    public static void writeAllInfo(Context context, AllInfo infos){
        try {
            FileOutputStream fos = context.openFileOutput(Filename,context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(infos);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获得所有行程
    public static AllInfo readAllInfo(Context context){

        AllInfo allInfo = null;
        try {
            FileInputStream fis = context.openFileInput(Filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            allInfo = (AllInfo)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allInfo;
    }

    //获得天的行程
    public static DayInfo getDayInfo(Context context, int year, int month , int day){

        DayInfo dayInfo =null;
        String key = getDayInfoKey(year,month,day);
        AllInfo infos = getAllInfo(context);
        if(infos != null){
            dayInfo = infos.getDayRouteList(key);
        }
        return dayInfo;
    }

    public static List<Info> getDayInfoList(Context context, int year, int month , int day){
        List<Info > list = new ArrayList<Info>();
        if(getDayInfo(context,year,month,day) != null){
            list = getDayInfo(context,year,month,day).getInfoList();
        }
        return list;
    }

    //判断当前是否有行程
    public static boolean isHasRoute(Context context, int year, int month, int day){
        DayInfo dayInfo   = getDayInfo(context,year,month,day);
        if(dayInfo != null && dayInfo.getInfoList().size()>0){
            return true;
        }
        return  false;
    }

    public static void removeInfo(Context context, int year
            , int month, int day, int hour, int minute){
        String dayInfoKey = getDayInfoKey(year,month,day);
        String infoKey = getInfoKey(hour,minute);
        AllInfo allInfo = getAllInfo(context);
        DayInfo dayInfo = allInfo.getDayRouteList(dayInfoKey);
        dayInfo.remove(infoKey);

        allInfo.addDayRouteList(dayInfoKey,dayInfo);
        writeAllInfo(context,allInfo);
    }


    public static String getDayInfoKey(int year, int month, int day){
        int key = (int)(year *1300+month*100+day*1);
        return key+"";
    }

    public static String getInfoKey(int hour , int minute){
        int key = (int)((hour*1+minute*0.01)*100);
        String timekey = key+"";
        return  timekey;
    }


}
