package com.example.imooc_music.helper;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class MediaPlay {
    private  static MediaPlay mediaPlay;

    private Context mContext;

    private MediaPlayer mediaPlayer;

    private String path;

    public String getPath() {
        return path;
    }
    public OnMediaPlayListener getOnMediaPlayListener() {
        return onMediaPlayListener;
    }

    public void setOnMediaPlayListener(OnMediaPlayListener onMediaPlayListener) {
        this.onMediaPlayListener = onMediaPlayListener;
    }

    private OnMediaPlayListener onMediaPlayListener;

    private MediaPlay (Context context) {
        mContext = context;
        mediaPlayer = new MediaPlayer();
    }
    // 单例实现
    public static MediaPlay getInstance(Context context) {
        if(mediaPlay == null) {
            synchronized (MediaPlay.class) {
                if(mediaPlay == null) {
                    mediaPlay = new MediaPlay(context);
                }
            }
        }
        return mediaPlay;
    }

    /**
     * 设置播放的音乐路径
     */
    public void setPath(String url) {
        path = url;
        // 如果正在播放 重置播放状态
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
        }
        // 设置播放资源路径
        try {
            mediaPlayer.setDataSource(mContext,Uri.parse(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 准备播放
        mediaPlayer.prepareAsync();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if(onMediaPlayListener != null) {
                    onMediaPlayListener.onPrepared(mp);
                }
            }
        });


    }

    /**
     * 播放音乐
     */
    public void play() {
        if(mediaPlayer.isPlaying()) return;
        mediaPlayer.start();
    }

    /**
     * 暂停播放
     */
    public void pause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }

    }

    public interface OnMediaPlayListener {
        void onPrepared(MediaPlayer mp);
    }
}
