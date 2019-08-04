package com.example.imooc_music.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpac;

    public ItemDecoration(int spac) {
        mSpac = spac;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // parent.getChildLayoutPosition(view) 获取当前item 在recycleview中的position
//        not workint
//        if(parent.getChildLayoutPosition(view) % 3 == 0) {
//            outRect.left = 0;
//        } else {
//            outRect.left = mSpac;
//        }
        outRect.left = mSpac;

    }
}
