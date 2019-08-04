package com.example.imooc_music.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.imooc_music.R;
import com.example.imooc_music.activities.PlayActivity;

public class MusicListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private RecyclerView _muList;
    private View viewItem;
    private boolean hasSetHeight = false;

    public MusicListAdapter(Context context, RecyclerView muList) {
        mContext = context;
        _muList = muList;
    }

    /**
     * 设置item 显示
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewItem = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (!hasSetHeight) {
            setRcViewHeight();
            hasSetHeight = true;
        }
        Glide.with(mContext)
                .load("http://p2.music.126.net/SAtrRLKX6KMQmRR0-7WJcA==/109951164260967314.jpg?param=140y140")
                .into(viewHolder.icon);
        // 添加路由跳转
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * 动态设置当前recycleview的高度
     */
    private void setRcViewHeight() {
        if (_muList == null) {
            return;
        }
        int count = getItemCount();
        int itemHeight = viewItem.getLayoutParams().height;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) _muList.getLayoutParams();
        layoutParams.height = itemHeight * count;
        _muList.setLayoutParams(layoutParams);
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView icon;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        icon = itemView.findViewById(R.id.mu_list_item_icon);
    }
}
