package com.example.sxj52.lifeassistant.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.chat.activity.ChooseareaActivity;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.entity.WeatherEntity;
import com.example.sxj52.lifeassistant.ui.activity.MainActivity;
import com.example.sxj52.lifeassistant.utils.HttpUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherAdapter extends BaseAdapter {
    private ArrayList<WeatherEntity> weatherEntities;
    private Context ctx ;
    public WeatherAdapter(Context mContext, ArrayList<WeatherEntity> weatherEntities) {
        this.ctx = mContext ;
       this.weatherEntities=weatherEntities;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public WeatherEntity getItem(int position) {
        return weatherEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        final WeatherEntity weatherEntity = weatherEntities.get(position);
        ViewHolder holder = null ;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (convertView==null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_weather,null);
            holder = new ViewHolder();
            // 初始化各控件
            holder.bingPicImg = (ImageView) convertView.findViewById(R.id.bing_pic_img);
            holder.weatherLayout = (ScrollView) convertView.findViewById(R.id.weather_layout);
            holder.titleCity = (TextView) convertView.findViewById(R.id.title_city);
            holder.titleUpdateTime = (TextView) convertView.findViewById(R.id.title_update_time);
            holder.degreeText = (TextView) convertView.findViewById(R.id.degree_text);
            holder.weatherInfoText = (TextView) convertView.findViewById(R.id.weather_info_text);
            holder.forecastLayout = (LinearLayout) convertView.findViewById(R.id.forecast_layout);
            holder.aqiText = (TextView) convertView.findViewById(R.id.aqi_text);
            holder.pm25Text = (TextView) convertView.findViewById(R.id.pm25_text);
            holder.comfortText = (TextView) convertView.findViewById(R.id.comfort_text);
            holder.carWashText = (TextView) convertView.findViewById(R.id.car_wash_text);
            holder.sportText = (TextView) convertView.findViewById(R.id.sport_text);
            holder.navButton=convertView.findViewById(R.id.nav_button);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String cityName = weatherEntity.getHeWeather5().get(0).getBasic().getCity();
        String updateTime = weatherEntity.getHeWeather5().get(0).getBasic().getUpdate().getLoc().split(" ")[1];
        String degree = weatherEntity.getHeWeather5().get(0).getNow().getTmp()+ "℃";
        String weatherInfo = weatherEntity.getHeWeather5().get(0).getNow().getCond().getTxt();
        holder.titleCity.setText(cityName);
        holder.titleUpdateTime.setText(updateTime);
        holder.degreeText.setText(degree);
        holder.weatherInfoText.setText(weatherInfo);
        holder.forecastLayout.removeAllViews();
        holder.navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(ctx,ChooseareaActivity.class);
               ctx.startActivity(intent);
            }
        });
        for (WeatherEntity.HeWeather5Bean.DailyForecastBean forecast : weatherEntity.getHeWeather5().get(0).getDailyForecast()) {
            View view = LayoutInflater.from(ctx).inflate(R.layout.forecast_item, holder.forecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dateText.setText(forecast.getDate());
            infoText.setText(forecast.getCond().getTxtD());
            maxText.setText(forecast.getTmp().getMax());
            minText.setText(forecast.getTmp().getMin());
            holder.forecastLayout.addView(view);
        }
        if (weatherEntity.getHeWeather5().get(0).getAqi() != null) {
            holder.aqiText.setText(weatherEntity.getHeWeather5().get(0).getAqi().getCity().getAqi());
            holder.pm25Text.setText(weatherEntity.getHeWeather5().get(0).getAqi().getCity().getPm25());
        }
        String comfort = "舒适度：" + weatherEntity.getHeWeather5().get(0).getSuggestion().getComf().getTxt();
        String carWash = "洗车指数：" +weatherEntity.getHeWeather5().get(0).getSuggestion().getCw().getTxt();
        String sport = "运行建议：" + weatherEntity.getHeWeather5().get(0).getSuggestion().getSport().getTxt();
        holder.comfortText.setText(comfort);
        holder.carWashText.setText(carWash);
        holder.sportText.setText(sport);
        holder.weatherLayout.setVisibility(View.VISIBLE);
        String bingPic = prefs.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(ctx).load(bingPic).placeholder(R.drawable.bg).into(holder.bingPicImg);
        } else {
           Glide.with(ctx).load(R.drawable.bg).into(holder.bingPicImg);
        }
        return convertView;
    }
    public static class ViewHolder{
        private ScrollView weatherLayout;

        private TextView titleCity;

        private TextView titleUpdateTime;

        private TextView degreeText;

        private TextView weatherInfoText;

        private LinearLayout forecastLayout;

        private TextView aqiText;

        private TextView pm25Text;

        private TextView comfortText;

        private TextView carWashText;

        private TextView sportText;

        private ImageView bingPicImg;

        private Button navButton;

    }


}
