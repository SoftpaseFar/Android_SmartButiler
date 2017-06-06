package com.goo1e.smartbutiler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.goo1e.smartbutiler.R;
import com.goo1e.smartbutiler.utils.ShareUtils;
import com.goo1e.smartbutiler.utils.StaticClass;
import com.goo1e.smartbutiler.utils.UtilTools;

import static com.goo1e.smartbutiler.utils.StaticClass.SHARE_IS_FIRST;

/**
 *闪屏页
 * 1.延时2000ms
 * 2.判断是否是第一次登陆
 * 3.自定义字体
 * 4.Activity全屏主题
 * Created by SoftpaseFar on 2017/3/30.
 */

public class SplashActivity extends AppCompatActivity{

    private TextView tv_splash;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否第一次运行
                    if (isFirst()) {
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    //初始化View
    private void initView() {
        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tv_splash =  (TextView)findViewById(R.id.tv_splash);
        //设置字体
        UtilTools.setFont(this,tv_splash);
    }

    //判断程序是否第一次运行
    private boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this, SHARE_IS_FIRST,true);
        ShareUtils.putBoolean(this,StaticClass.SHARE_IS_FIRST,false);
        if(isFirst) {
            return true;
        }else {
            return false;
        }
    }

    // 禁止返回键
    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }
}
