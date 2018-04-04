package com.example.sxj52.lifeassistant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.utils.FileTool;
import com.example.sxj52.lifeassistant.utils.TimeTool;
import com.example.sxj52.lifeassistant.view.DayDataView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




/**
 * Created by sy on 2016/9/7.
 */
public class MonthDataAdapter extends BaseAdapter {

    private int currentYear;          //当前的年
    private int currentmonth;         //当前的月
    private int currentDay;           //当前的日

    private int todayYear,todayMonth,todayDay;//今天

    private int dayOfMonthCount;      //当前月的天数
    private int monthOfFitstDayWeek;  //当前月第一天是星期几

    private int emptyItemCount;
    private Calendar calendar;
    private Context context;
    private List<String> dayList = null;
    private TimeTool timeTool;
    public MonthDataAdapter(Context context, Date date){
        this.context = context;
        calendar = Calendar.getInstance();
        timeTool = new TimeTool();
        setTime(date);
        setMonData();
        setEmptyItemCount();
        initList();
    }

    //获得月份的信息
    private void setMonData(){
       // dayOfMonthCount = timeTool.getDayCountOfMonthYear(currentYear,currentmonth);
        monthOfFitstDayWeek = timeTool.getFirstDayOfWeekInMonth(currentYear,currentmonth);

        //获得一个月多少天
        calendar.set(Calendar.YEAR,currentYear);   //指定年月
        calendar.set(Calendar.MONTH,currentmonth-1);
        dayOfMonthCount = calendar.getActualMaximum(calendar.DATE);//获得指定的年份和指定的月份中有多少天

        System.out.println("DayCountOfMonthYear---> "+currentYear+" "+currentmonth);
        System.out.println("DayCountOfMonthYear---> "+dayOfMonthCount);
    }
    private void setEmptyItemCount(){
        if(monthOfFitstDayWeek >= 7){
            emptyItemCount = 0;
        }else {
            emptyItemCount = monthOfFitstDayWeek;
        }
    }

    private void initList(){
        Integer dayOfMonthCount = this.dayOfMonthCount;
        if(dayList== null){
            dayList = new ArrayList<String>();
        }
        dayList.clear();
        for(int i = 0;i<emptyItemCount;i++){
            dayList.add("");
        }
        for(int i = 1;i<=dayOfMonthCount;i++){
            dayList.add(String.valueOf(i));
        }
    }



    @Override
    public int getCount() {
        return dayList.size();
    }

    @Override
    public Object getItem(int position) {

        return dayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        DayDataView view  = null;
        HolderView holderView;

        if(convertView == null || convertView.getTag()==null){
            view = (DayDataView) View.inflate(context, R.layout.item_day_layout,null);
            holderView = new HolderView(view);
            view.setTag(holderView);
        }else {
            view =(DayDataView) convertView;
            holderView = (HolderView)view.getTag();
        }
        holderView.dayDataView.setText(String.valueOf(getItem(position)));

        int day = holderView.dayDataView.getDay();
        if(day > 0 ){
            if( FileTool.isHasRoute(context,currentYear,currentmonth,day)){
                holderView.dayDataView.setHasRoute(true);
            }else {
                holderView.dayDataView.setHasRoute(false);
            }
        }else { holderView.dayDataView.setClickable(false);}


        return view;
    }
    public class HolderView{
        public  DayDataView dayDataView;
        public HolderView(View view){
            this.dayDataView= (DayDataView)view;
        }
    }

    public void setTime(Date date){
        calendar.setTime(date);
        currentYear  = calendar.get(Calendar.YEAR);       //获得当前的年月日
        currentmonth = calendar.get(Calendar.MONTH)+1;
        currentDay   = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void setYear(int year){
        this.currentYear = year;
    }
    public void setMonth(int month){
        this.currentmonth = month;
    }
    public void setDay(int day){this.currentDay = day;}

    public void notifyDataSetChanged(){
        setMonData();
        setEmptyItemCount();
        initList();
        this.notifyDataSetInvalidated();//没有一个集合处理所有这个东西
    }
}
