package com.example.sxj52.lifeassistant.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by sy on 2016/9/12.
 */
public class AllInfo implements Serializable {
    HashMap<String ,DayInfo> map = new HashMap<String ,DayInfo>();
    //timea是时间 xxxx年xx月xx日
    public void addDayRouteList(String time, DayInfo dayInfo){
        map.put(time,dayInfo);
    }

    public DayInfo getDayRouteList(String time){
        return map.get(time);
    }
}
