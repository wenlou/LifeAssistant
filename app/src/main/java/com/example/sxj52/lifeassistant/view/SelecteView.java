package com.example.sxj52.lifeassistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.utils.TimeTool;

import java.util.Calendar;
import java.util.Date;




public class SelecteView extends LinearLayout implements View.OnClickListener {
    private View view;
    private ImageView addImage;
    private ImageView reduceImage;
    private TextView yearText;
    private TextView monthText;
    private TextView dayText;

    private boolean isYearTextSelect = false;
    private boolean isMonthtextSelect = true;
    private boolean isDaytextSelect = false;

    private OnSetChangeListener onSetChangeListener;

    public SelecteView(Context context) {
        super(context);
        init(context);
    }

    public SelecteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SelecteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.select_layout,null);
        this.addView(view,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addImage = (ImageView)findViewById(R.id.add_image);
        reduceImage = (ImageView)findViewById(R.id.reduce_image);
        yearText = (TextView)findViewById(R.id.year_text);
        monthText = (TextView)findViewById(R.id.month_text);
        dayText = (TextView)findViewById(R.id.day_text);

        addImage.setOnClickListener(this);
        reduceImage.setOnClickListener(this);
        yearText.setOnClickListener(this);
        monthText.setOnClickListener(this);
        dayText.setOnClickListener(this);
    }

    private void setAllNotSelect(){
        isDaytextSelect = false;
        isMonthtextSelect =false;
        isYearTextSelect = false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int withSize = MeasureSpec.getSize(widthMeasureSpec);

        if(heightMode == MeasureSpec.AT_MOST){
            heightSize = addImage.getHeight();
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,heightMode);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setYear(int year){
        this.yearText.setText(String.valueOf(year));
    }
    public int getYear(){
        String data = this.yearText.getText().toString();
        int year = 2016;
        try {
            year = Integer.valueOf(data.trim()).intValue();
        }catch (Exception e){
            return  0;
        }
        return year;
    }

    public void setMonth(int month){
        this.monthText.setText(String.valueOf(month));
    }
    public int getMonth(){
        String data = this.monthText.getText().toString();
        int month = 1;
        try {
            month = Integer.valueOf(data.trim()).intValue();
        }catch (Exception e){
            return month;
        }
        return month;
    }

    public void setDay(int day){
        this.dayText.setText(String.valueOf(day));
    }
    public int getDay(){
        String data = this.dayText.getText().toString();
        int day = 1;
        try {
            day = Integer.valueOf(data.trim()).intValue();
        }catch (Exception e){
            return day;
        }
        return day;
    }

    public void setDate(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        System.out.println("--->time "+year+" "+month+" "+day);

        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }
    public void setTime(int year,int month,int day){
        setYear(year);
        setMonth(month);
        setDay(day);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.year_text:
                setAllNotSelect();
                isYearTextSelect = !isYearTextSelect;
                break;
            case R.id.month_text:
                setAllNotSelect();
                isMonthtextSelect = !isMonthtextSelect;
                break;
            case R.id.day_text:
                setAllNotSelect();
                isDaytextSelect = !isDaytextSelect;
                break;
            case R.id.add_image:
                addTime();
                if(onSetChangeListener != null)
                    onSetChangeListener.onChange(getYear(),getMonth(),getDay());
                break;
            case R.id.reduce_image:
                reduceTime();
                if(onSetChangeListener != null)
                    onSetChangeListener.onChange(getYear(),getMonth(),getDay());
                break;
        }
    }

    private void addTime(){
        addDay();
        addMonth();
        addYear();
        setMoreToDay(getYear(),getMonth(),getDay());
    }
    private void reduceTime(){
        reduceDay();
        reduceMonth();
        reduceYear();
        setMoreToDay(getYear(),getMonth(),getDay());
    }
    private void addDay(){
        if(isDaytextSelect){
            setDay(getDay()+1);
            addOnlyDayToMonth();
            addOnlyMonthToYear();
        }
    }
    private void addMonth(){
        if(isMonthtextSelect){
            setMonth(getMonth()+1);
            addOnlyMonthToYear();
        }
    }
    private void addYear(){
        if (isYearTextSelect){
            setYear(getYear()+1);
        }
    }

    private void reduceDay(){
        if(isDaytextSelect){
            setDay(getDay()-1);
            reduceOnlyDayToMonth();
            reduceOnlyMonthToYear();
        }
    }
    private void reduceMonth(){
        if(isMonthtextSelect){
            setMonth(getMonth()-1);
            reduceOnlyMonthToYear();
        }
    }
    private void reduceYear(){
        if(isYearTextSelect){
            setYear(getYear()-1);
        }
    }

    private void addOnlyDayToMonth(){
        int maxday =  new TimeTool().getDayCountOfMonthYear(getYear(),getMonth());
        int day = getDay();
        if(day > maxday){
            day = 1;
            int month = getMonth();
            month++;
            setDay(day);
            setMonth(month);
        }
    }

    private void addOnlyMonthToYear(){
        int month = getMonth();
        if(month>12){
            month=1;
            setMonth(month);
            setYear(getYear()+1);
        }
    }

    private void reduceOnlyDayToMonth(){

        int day = getDay();
        if(day <1){
            int lastMonythMaxday = getLatMonthDayNum();
            day = lastMonythMaxday;
            setDay(day);
            setMonth(getMonth()-1);
        }
    }
    private void reduceOnlyMonthToYear(){
        int month = getMonth();
        if(month<1){
            month = 12;
            setMonth(month);
            setYear(getYear()-1);
        }
    }

    private int getLatMonthDayNum(){
        int month = getMonth();
        int year = getYear();
        int maxDay = 0;
        if(month >1){
            maxDay = new TimeTool().getDayCountOfMonthYear(year,month-1); //正常情况下
        }else {
            maxDay = new TimeTool().getDayCountOfMonthYear(year-1,12);//上一个月是去年
        }
        return  maxDay;
    }

    //年月改变的时候，判断该年该月的天数，和当前显示的天数
    private void setMoreToDay(int year,int month,int day){
        TimeTool timeTool = new TimeTool();
        int dayNum = timeTool.getDayCountOfMonthYear(year,month);
        if(dayNum < day){
            setDay(dayNum);
        }
        System.out.println("--->year="+year+"month="+month+"day="+day);
    }

    //创建一个接口作为监听
    interface OnSetChangeListener{
        void onChange(int year, int month, int day);
    }

    public void setOnSetChangeListener(OnSetChangeListener onSetChangeListener){
        this.onSetChangeListener = onSetChangeListener;
    }
}
