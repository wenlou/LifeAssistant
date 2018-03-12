package com.example.sxj52.lifeassistant.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.chat.activity.RegestActivity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.utils.DateUtils;
import com.example.sxj52.lifeassistant.utils.GlideCircleTransform;

import java.util.List;

public class ImageJokeAdapter extends BaseAdapter {
    private List<NewsEntity> newsEntities ;
    private Context ctx ;
    public ImageJokeAdapter(Context mContext, List<NewsEntity> newsEntities) {
        this.ctx = mContext ;
        this.newsEntities = newsEntities ;
    }

    @Override
    public int getCount() {
        return newsEntities.size();
    }

    @Override
    public NewsEntity getItem(int position) {
        return newsEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        ViewHolder holder = null ;
        final NewsEntity newsEntity = newsEntities.get(position);
        if (convertView==null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_detail_doc,null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.time = (TextView) convertView.findViewById(R.id.tv_commnetsize);
            holder.soure=(TextView) convertView.findViewById(R.id.tv_source);
            holder.image = (ImageView) convertView.findViewById(R.id.iv_logo);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.time.setText("更新时间："+ newsEntity.getDate());
        holder.title.setText(newsEntity.getTitle());
        holder.soure.setText(newsEntity.getAuthor_name());
        Glide.with(ctx).load(newsEntity.getThumbnail_pic_s()).centerCrop().into(holder.image);
        return convertView;
    }
    public static class ViewHolder{
        private TextView title;
        private TextView time;
        private TextView soure;
        private ImageView image ;
    }

}
