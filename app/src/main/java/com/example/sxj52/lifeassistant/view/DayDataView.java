package com.example.sxj52.lifeassistant.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sxj52.lifeassistant.R;



public class DayDataView extends LinearLayout {

    private LayoutInflater inflater;
    private View view;
    private TextView textView;
    private ImageView imageView;

    public boolean HASROUTE = false;//是否有行程
    public boolean isToday = false;

    private static int PROMAT_NOW_COLOR = Color.parseColor("#f70338");      //有事红点色        //红

    private static int TODAY_TEXT_COLOR = Color.parseColor("#f24d24");      //今天的Text颜色
    private static int NOT_TODAY_TEXT_COLOR = Color.parseColor("#1a1919");  //非今天的Text颜色    //黑

    private static int TODAY_COLOR = Color.parseColor("#56e929");           //选中的背景色
    private static int NOT_TODAY_COLOR = Color.parseColor("#00FFFFFF");        //非选中背景色

    Drawable drawable = getResources().getDrawable(R.drawable.prompt_shape);
    public DayDataView(Context context) {
        super(context);
        init(context);
    }

    public DayDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DayDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.day_layout,this);
        textView = (TextView)view.findViewById(R.id.text);
        imageView = (ImageView)view.findViewById(R.id.image);
        setHasRoute(false);
        setToday(false);
        setSelect(false);
    }

    //设置是否有行程，有就显示红点
    public void setHasRoute(boolean hasRoute){
        HASROUTE = hasRoute;
        if(HASROUTE){
            imageView.setVisibility(View.VISIBLE);
           //imageView.setBackgroundResource(R.drawable.prompt_shape);
        }else {
            imageView.setVisibility(View.GONE);//掩藏起来
        }
    }

    //设置是今天
    public void setToday(boolean isTody){
        if(isTody){
            textView.setTextColor(TODAY_TEXT_COLOR);
        }else {
            textView.setTextColor(NOT_TODAY_TEXT_COLOR);
        }
    }

    //设置是否选中
    public void setSelect(boolean isSelect){
        if(isSelect){
            view.setBackgroundColor(TODAY_COLOR);
        }else {
            view.setBackgroundColor(NOT_TODAY_COLOR);
        }
    }

    public void setText(String text){
        if(textView != null){
            textView.setText(text);
        }
    }
    public int getDay(){
        if(textView != null){
            try {
                int day = Integer.parseInt(textView.getText().toString());
                return day;
            }catch (Exception e){
               return 0;
            }
        }
        return 0;
    }

}
