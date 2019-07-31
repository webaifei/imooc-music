package com.example.imooc_music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.imooc_music.R;

import java.util.Timer;
import java.util.TimerTask;

// 1. 延时3s
// 2. 跳转view
public class WelcomeActivity extends BaseActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e("welcome activity", "当前线程：" + Thread.currentThread());
                router();
            }
        }, 3*1000);
    }

    /**
     * 跳转到主页view
     */
    private void router() {
//        Intent intent = new Intent(this, MainActivity.class);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
