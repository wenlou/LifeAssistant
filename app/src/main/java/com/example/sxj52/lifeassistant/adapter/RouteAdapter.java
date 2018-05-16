package com.example.sxj52.lifeassistant.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.utils.Info;

import java.util.List;



public class RouteAdapter extends BaseAdapter {

    private Context context;
    private List<Info> infoList;
    public RouteAdapter(Context context, List<Info> infoList){
        this.context = context;
        this.infoList = infoList;
    }
    @Override
    public int getCount() {
        return infoList.size();
    }

    @Override
    public Object getItem(int position) {
        return infoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        HolderView holderView;
        if(convertView == null || convertView.getTag() == null){
            view = View.inflate(context, R.layout.route_show_item_layout,null);
            holderView = new HolderView(view);
            view.setTag(holderView);
        }else {
            view = convertView;
            holderView = (HolderView)view.getTag();
        }

        Info info = infoList.get(position);

        String time = getTime(info);
        String data = getData(info);
        holderView.timeTextView.setText(time);
        holderView.routeTextView.setText(data);

        return view;
    }

    private String getTime(Info info){

        String time = "";
        if(info != null){
            if(info.getYear() >=0 ){
                time += info.getYear()+"年";
            }
            if(info.getMonth() >=0){
                time += info.getMonth()+"月";
            }
            if(info.getDay() >= 0){
                time += info.getDay()+"日";
            }
            if(info .getHour()>=0){
                time += info.getHour()+":";
            }
            if(info.getMinute() >0){
                time += info.getMinute();
            }
        }
        return time;
    }

    private String getData(Info info){
        if(info != null){
            return info.getData();
        }
        return "";
    }

    class HolderView{
        TextView timeTextView;
        TextView routeTextView;
        public HolderView(View view){
            timeTextView = (TextView) view.findViewById(R.id.time_text);
            routeTextView =(TextView)view.findViewById(R.id.data_text);
        }
    }


}
