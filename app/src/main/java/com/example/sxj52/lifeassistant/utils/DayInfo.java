package com.example.sxj52.lifeassistant.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class DayInfo implements Serializable {

    HashMap<String,Info> infos = new HashMap<String ,Info>();

    public void addInfo(String key, Info info){
        infos.put(key,info);
    }
    public HashMap<String,Info> getDayInfos(){
        return infos;
    }

    public Info getInfo(String key){
        return infos.get(key);
    }

    public List<Info> getInfoList(){

        List<Info> list = new ArrayList<>();
        HashMap map = getDayInfos();
        Collection<String> set1 = map.values();
        Iterator iterator = set1.iterator();
        while (iterator.hasNext()){
            Info value = (Info) iterator.next();
            list.add(value);
        }
        return list;
    }

    public void remove(String key){
        infos.remove(key);
    }

    @Override
    public String toString() {
        return "DayInfo{" +
                "infos=" + infos +
                '}';
    }
}
