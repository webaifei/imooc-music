package com.example.imooc_music.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imooc_music.R;
import com.example.imooc_music.helper.MediaPlay;

/**
 * 自定义光碟view
 */
public class DiscView extends FrameLayout {
    private Context mContext;

    private View mView;
    // 光碟
    private ImageView circleBg;
    // 播放资源地址
    private String mPath;

    // 动画描述
    private Animation startPlayNeedleAnimation, stopPlayNeedleAnimation, startPlayRotationAnimation;
    // 播放指针
    private ImageView needle;
    //开始播放按钮
    private ImageView startPlayBtn;

    // 播放控制类
    public MediaPlay mediaPlay;

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    // 是否正在播放
    private boolean isPlay = false;

    public DiscView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public DiscView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DiscView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DiscView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.disc_view, this, false);
        // 动画
        // 加载动画
        startPlayNeedleAnimation = AnimationUtils.loadAnimation(mContext, R.anim.start_play_need);
        stopPlayNeedleAnimation = AnimationUtils.loadAnimation(mContext, R.anim.stop_play_need);
        startPlayRotationAnimation = AnimationUtils.loadAnimation(mContext, R.anim.play_rotate);
        // 获取视图引用
        needle = mView.findViewById(R.id.needle);
        startPlayBtn = mView.findViewById(R.id.play_btn);
        circleBg = mView.findViewById(R.id.profile_image);
        // 添加播放事件
        startPlayBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(mPath);
            }
        });
        circleBg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlay();
            }
        });

        addView(mView);

        mediaPlay = MediaPlay.getInstance(context);

    }

    /**
     * 切换播放状态
     */
    private void togglePlay() {
        if (isPlay) {
            stopMusic();
        } else {
            playMusic(mPath);
        }
    }

    /**
     * 开始播放动画
     */
    public void playMusic(String path) {
        mPath = path;
        needle.startAnimation(startPlayNeedleAnimation);
        circleBg.startAnimation(startPlayRotationAnimation);
        startPlayBtn.setVisibility(GONE);
        isPlay = true;
        // 要播放的音乐是当前播放音乐
        if(mediaPlay.getPath() != null
                && mediaPlay.getPath().equals(mPath)) {
            mediaPlay.play();
        } else {
            mediaPlay.setPath(mPath);
            mediaPlay.setOnMediaPlayListener(new MediaPlay.OnMediaPlayListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlay.play();
                }
            });
        }
    }

    /**
     * 停止播放音乐
     */
    public void stopMusic() {
        needle.startAnimation(stopPlayNeedleAnimation);
        circleBg.clearAnimation();
        startPlayBtn.setVisibility(VISIBLE);
        isPlay = false;
        mediaPlay.pause();
    }

    /**
     * 给光碟设置一个背景
     */
    public void setPlayGround(String url) {
        Glide.with(this)
                .load(url)
                .into(circleBg);
    }
}
