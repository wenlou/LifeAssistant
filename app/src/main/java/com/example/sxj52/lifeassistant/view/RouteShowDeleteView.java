package com.example.sxj52.lifeassistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.sxj52.lifeassistant.R;


/**
 * Created by sy on 2016/9/13.
 */
public class RouteShowDeleteView extends ListView implements View.OnTouchListener{

    private GestureDetector detector;                                    //手势
    private GestureDetector.SimpleOnGestureListener gestureListener;     //手势监听
    private View buttonView;                                             //删除按钮的View
    private ViewGroup selectItemGroup;                                   //选择的item
    private int selectItem;                                              //选择的Item
    private DelectListener delectListener = null;

    private boolean isShowButton =false;
    public RouteShowDeleteView(Context context) {
        super(context);
        init(context);
    }

    public RouteShowDeleteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RouteShowDeleteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context){

        setOnTouchListener(this);
        gestureListener = new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onDown(MotionEvent e) {
                if(!isShowButton){
                    selectItem = pointToPosition((int)e.getX(),(int)e.getY());//得到选择listView中的item
                }
                return false;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if(!isShowButton && Math.abs(velocityX)> Math.abs(velocityY)
                        && Math.abs(velocityX) >getWidth()/3 ){
                    buttonView = LayoutInflater.from(context).inflate(R.layout.button_layout,null);
                    buttonView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            selectItemGroup.removeView(buttonView);
                            buttonView = null;
                            isShowButton = false;
                            if(delectListener != null){
                                delectListener.delect(selectItem);
                            }
                        }
                    });
                    //getChileAt获得的是屏幕上显示的Item序号
                    selectItemGroup = (ViewGroup) getChildAt(selectItem-getFirstVisiblePosition());
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    params.addRule(RelativeLayout.CENTER_VERTICAL);
                    selectItemGroup.addView(buttonView,params);
                    isShowButton = true;
                }
                return false;
            }
        };
        detector = new GestureDetector(context,gestureListener);//设置手势监听
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(isShowButton){
            selectItemGroup.removeView(buttonView);
            isShowButton = false;
            buttonView = null;
            return false;
        }else
            return detector.onTouchEvent(event);
    }

    public interface DelectListener{
        void delect(int selectItem);
    }

    public void setDelectListener(DelectListener delectListener){
        this.delectListener = delectListener;
    }

}