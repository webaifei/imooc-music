package com.example.imooc_music.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imooc_music.R;

import org.w3c.dom.Text;

public class BaseActivity extends Activity {
    private ImageView backIcon, meIcon;
    private TextView titleView;

    protected void initNavgationBar(boolean isShowBack, String title, boolean isShowMe) {
        backIcon = findViewById(R.id.back);
        meIcon = findViewById(R.id.me_icon);
        titleView = findViewById(R.id.titleView);
//        设置返回按钮显示 隐藏
        backIcon.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        titleView.setText(title);
        meIcon.setVisibility(isShowMe ? View.VISIBLE : View.GONE);

//        添加返回按钮事件
        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        个人中心导航
        meIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, MeActivity.class));
            }
        });
    }
}
