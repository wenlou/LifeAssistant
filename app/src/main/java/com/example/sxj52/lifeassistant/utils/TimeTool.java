package com.example.sxj52.lifeassistant.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sy on 2016/9/7.
 */
public class TimeTool  {
    //获得某年某月的天数：

    private static Calendar calendar = Calendar.getInstance();
    //根据年月获得当月的天数
    public int getDayCountOfMonthYear(int year,int month){

        System.out.println("year--->"+year+ " "+month);
        calendar.set(Calendar.YEAR,year);   //指定年月
        calendar.set(Calendar.MONTH,month-1);

        int dayCountOfMonthYear = calendar.getActualMaximum(calendar.DATE);//获得指定的年份和指定的月份中有多少天
        return dayCountOfMonthYear;
    }

    //获得指定年，指定月第一天的时间
    public int getFirstDayOfWeekInMonth(int year,int month){

        int monthOfFitstDayWeek =getWeekDay(year,month,1);
        return monthOfFitstDayWeek;
    }

    //获得指定年月日是星期几
    public int getWeekDay(int year,int month,int day){
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month-1);

        calendar.set(Calendar.DAY_OF_MONTH,day-1);
        int DayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return DayWeek;
    }

    public int getYear(Date date){
        calendar.setTime(date);
       int year =  calendar.get(Calendar.YEAR);
        return year;
    }
    public int getMonth(Date data){
        calendar.setTime(data);
        int month = calendar.get(Calendar.MONTH)+1;
        return month;
    }
    public int getDay(Date date){
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }
}
