package com.example.imooc_music.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.imooc_music.R;
import com.example.imooc_music.views.DiscView;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 播放音乐
 */
public class PlayActivity extends BaseActivity {

    private ImageView playBg;

    private DiscView discView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        init();
    }

    private void init() {
        // 隐藏statusbar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        playBg = findViewById(R.id.play_bg);
        discView = findViewById(R.id.dis_view);

        Glide.with(this)
                .load("http://i1.whymtj.com/uploads/tu/201907/9999/f6fe68f5f0.jpg")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(playBg);
        discView.setPlayGround("http://i1.whymtj.com/uploads/tu/201907/9999/f6fe68f5f0.jpg");
        discView.playMusic("http://audio01.dmhmusic.com/71_53_T10045908377_128_4_1_0_sdk-cpm/0209/M00/62/ED/ChR461sX8oSAecYpADSUC7tDpp4347.mp3?xcode=26b01387549ec8e14dd9b1f66a38daf505b6236");
    }

    /**
     * 返回
     * @param view
     */
    public void backRoute(View view) {
        onBackPressed();
    }
}
