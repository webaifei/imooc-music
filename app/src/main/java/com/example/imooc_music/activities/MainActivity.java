package com.example.imooc_music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imooc_music.R;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        initNavgationBar(false, "音乐", true);
    }

    /**
     * 导航到个人中心页
     * @param view
     */
    public void routerMe(View view) {
        startActivity(new Intent(this, MeActivity.class));
    }
}
