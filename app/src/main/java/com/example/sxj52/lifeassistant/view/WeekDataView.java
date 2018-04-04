package com.example.sxj52.lifeassistant.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by sy on 2016/9/7.
 */
public class WeekDataView extends View {

    private int mTopLineColor = Color.parseColor("#CCE4F2"); // 上边线颜色
    private int mButtomLineColor = Color.parseColor("#CCE4F2");  // 下边线颜色
    private int mWeedayColor = Color.parseColor("#1FC2F3");  // 工作时间颜色
    private int mWeekenColor = Color.parseColor("#fa4451");  // 周末时间颜色

    private int mStrokeWidth = 5;  //线宽
    private int mWeekSize = 15;    //字体的大小

    private int defaultheight  = 100;

    private String[] weekdays = {"日","一","二","三","四","五","六"};

    private Paint mPaint ;
    private DisplayMetrics mDisplayMetrics;

    public WeekDataView(Context context) {
        super(context);
        init();
    }

    public WeekDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WeekDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //初始化工作
    private void init(){
        mPaint = new Paint();
        mDisplayMetrics = getResources().getDisplayMetrics();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if(withMode == MeasureSpec.AT_MOST){
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(withSize,withMode); //在WARP_CONTENT的时候匹配父窗口
        }if(heightMode == MeasureSpec.AT_MOST){
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(defaultheight,withMode);//WARP_CONTENT的时候默认的高度为40
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getWidth();
        int height = getHeight();
        float textSize = mWeekSize * mDisplayMetrics.scaledDensity;//根据屏幕的放大倍数得到TextSize

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setTextSize(textSize);

        mPaint.setColor(mTopLineColor);
        canvas.drawLine(0,0,width,0,mPaint); //绘制顶部的线条

        mPaint.setColor(mButtomLineColor);
        canvas.drawLine(0,height,width,height,mPaint); //绘制底部的线条

        mPaint.setStyle(Paint.Style.FILL);
        int columeWith = width/weekdays.length;
        for(int i= 0;i<weekdays.length;i++){
            String nowDay = weekdays[i];
            float textWith = mPaint.measureText(nowDay);
            int startX = (int)(columeWith*i+(columeWith-textWith)/2);         //计算开始X轴位置
            int startY = (int)(height - (mPaint.ascent()-mPaint.descent()))/2;//计算开始Y轴位置

            if(nowDay.equals("六") || nowDay.equals("日")){
                mPaint.setColor(mWeekenColor);
            }else {
                mPaint.setColor(mWeedayColor);
            }
              canvas.drawText(nowDay,startX,startY,mPaint);//画出周期时间
        }
    }

    public void setmTopLineColor(int mTopLineColor){
        this.mTopLineColor = mTopLineColor;
    }

    public void setmButtomLineColor(int mButtomLineColor){
        this.mButtomLineColor = mButtomLineColor;
    }
    public void setmWeedayColor(int mWeedayColor){
        this.mWeedayColor = mWeedayColor;
    }
    public void setmWeekenColor(int mWeekenColor){
        this.mWeekenColor = mWeekenColor;
    }
    public void setmStrokeWidth(int mStrokeWidth){
        this.mStrokeWidth = mStrokeWidth;
    }
    public void setmWeekSize(int weekSize){
        this.mWeekSize = mWeekSize;
    }
}
