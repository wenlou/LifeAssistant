package com.example.sxj52.lifeassistant.chat.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.sxj52.lifeassistant.R;
import com.example.sxj52.lifeassistant.entity.NewsEntity;
import com.example.sxj52.lifeassistant.ui.activity.BaseActivity;


/**
 * author：Administrator on 2016/12/19 17:25
 * e-mail：wenzh@bbtree.com
 * description:文件说明
 * version:版本
 */
public class NewsLookActivity extends BaseActivity {
    private static String url = "";
    private static NewsEntity newsbean;
    private WebView webView;
    private TextView tv_title,iv_name,iv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_info);
        setBackView();
        setTitle("新闻详情");
        newsbean= (NewsEntity) getIntent().getSerializableExtra("newsbean");
        url=newsbean.getUrl();
        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.webview);
        tv_title=(TextView) findViewById(R.id.tv_title);
        iv_name=(TextView)findViewById(R.id.iv_name);
        iv_time=(TextView)findViewById(R.id.iv_time);
        tv_title.setText(newsbean.getTitle());
        iv_name.setText(newsbean.getAuthor_name());
        iv_time.setText(newsbean.getDate());
        // 启用javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 从assets目录下面的加载html
        webView.loadUrl(url);
    }

}
