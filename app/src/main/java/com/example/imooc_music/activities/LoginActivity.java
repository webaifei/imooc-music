package com.example.imooc_music.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.imooc_music.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        initNavgationBar(false, "音乐", false);
    }
}
