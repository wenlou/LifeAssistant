package com.example.sxj52.lifeassistant.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.example.sxj52.lifeassistant.adapter.MonthDataAdapter;
import com.example.sxj52.lifeassistant.utils.TimeTool;

import java.util.Date;



/**
 * Created by sy on 2016/9/7.
*/
public class MonthDataView extends RelativeLayout implements GridView.OnItemClickListener{

    GridView mGridView;
    private MonthDataAdapter adapter;
    private TimeTool timeTool;
    private OnDaySelectListener onDaySelectListener;

    private static int Today_Tag = 01111;
    public MonthDataView(Context context) {
        super(context);
        init(context);
    }

    public MonthDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MonthDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        timeTool = new TimeTool();
        mGridView = new GridView(context);
       // mGridView.setCacheColorHint(0);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setAlpha(0);
        mGridView.setSelector(colorDrawable);   //设置选择的时候不要出现背景色
        mGridView.setNumColumns(7);
        RelativeLayout.LayoutParams params = new LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Date date = new Date();
        adapter = new MonthDataAdapter(context,date);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
        this.addView(mGridView,params);
    }

    public void setTime(int year, int month, int day){
        adapter.setYear(year);
        adapter.setMonth(month);
        adapter.setDay(day);
        adapter.notifyDataSetChanged();
        setTodayTime(year,month,day);
    }

    public void refresh(){
        adapter.notifyDataSetChanged();
    }

    //设置今天
    private void setTodayTime(final int year, final int month, final int day){
        Date date = new Date(System.currentTimeMillis());
        final int todayYear  = timeTool.getYear(date);
        final int todayMonth = timeTool.getMonth(date);
        final int todayDay   = timeTool.getDay(date);

        mGridView.post(new Runnable() {
            @Override
            public void run() {
                setAllNotToday();//设置该月所有天都不是今天
                //设置今天
                if(year == todayYear && month == todayMonth ){
                    int emptyNum = getEmptyNum(year,month);
                    int firstVisableView = mGridView.getFirstVisiblePosition();
                    int lastVisableView = mGridView.getChildCount()+firstVisableView-1;
                    System.out.println("--->"+emptyNum+" "+firstVisableView+" "+lastVisableView);
                    DayDataView todayView = (DayDataView) mGridView.getChildAt(emptyNum+todayDay-1);
                    todayView.setToday(true);
                }
            }
        });
    }

    //设置说有天都不是今天
    private void setAllNotToday(){
        int firstVisiableView = mGridView.getFirstVisiblePosition();
        int lastVisiableView = mGridView.getChildCount()+firstVisiableView-1;

        for(int i = 0;i<mGridView.getChildCount();i++){
            DayDataView dayDataView = (DayDataView) mGridView.getChildAt(i);
            dayDataView.setToday(false);
        }
    }

    //设置所有天都没有被选中
    public void setAllNotSelect(){
        int firstVisiableView = mGridView.getFirstVisiblePosition();
        int lastVisiableView = mGridView.getChildCount()+firstVisiableView-1;

        for(int i = 0;i<mGridView.getChildCount();i++){
            DayDataView dayDataView = (DayDataView) mGridView.getChildAt(i);
            dayDataView.setSelect(false);
        }
    }

    //设置当前被选择
    public void setSelect(int year,int month,int day){

        //monthDataView.setAllNotSelect();
        if(this.getTag() != null){
            ((DayDataView)this.getTag()).setSelect(false);
        }
        DayDataView dayDataView =(DayDataView)getSelectViewByTime(year,month,day);
        if(dayDataView != null)dayDataView.setSelect(true);
        this.setTag(dayDataView);
    }

    //根据年月日拿到相应的View
    public View getSelectViewByTime(int year, int month, int day){
        int position = this.getEmptyNum(year,month)+day-1;
        System.out.println("--->position"+position+" "+mGridView.getChildCount());
        View view = mGridView.getChildAt(position);
        return view;
    }

    private int getEmptyNum(int year,int month){
        int emptyNum = timeTool.getFirstDayOfWeekInMonth(year,month);
        if(emptyNum>=7){
            emptyNum = 0;
        }
        return emptyNum;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DayDataView dayDataView = (DayDataView) view;
        int day = dayDataView.getDay();
        if(onDaySelectListener !=null && day> 0){      //day> 0设置开始非天数的格子不可点击
            onDaySelectListener.onDaySelect(day,dayDataView);
        }
    }

    //日期选择时候的触发接口
    interface OnDaySelectListener{
        void onDaySelect(int day, View view);//day 是那天， view 是点击中的 view
    }
    public void setOnDaySelectListener(OnDaySelectListener onDaySelectListener){
        this.onDaySelectListener = onDaySelectListener;
    }

}
