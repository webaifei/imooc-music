package com.example.imooc_music.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.imooc_music.R;

public class MeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        init();
    }

    private void init() {
        initNavgationBar(true, "我的", false);
    }

    /**
     * 退出登录
     * @param view
     */
    public void logout(View view) {
        // api
        // 清除本地个人信息缓存
        // 跳转到登录页
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
