package com.example.imooc_music.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.imooc_music.R;
import com.example.imooc_music.activities.TypeListActivity;

public class MusicGridAdapter extends RecyclerView.Adapter<MusicGridAdapter.ViewHolder> {
    private Context mContext;

    public MusicGridAdapter(Context context) {
        mContext = context;
    }

    /**
     * 设置每一个item的布局文件
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_grid_music, viewGroup, false));
    }

    /**
     * 数据绑定到view
     * @param viewHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load("http://p3.music.126.net/9u0Yh6-yefEGNTFZ4ZNjNg==/109951164208231738.jpg?param=100y100")
                .into(viewHolder.icon);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TypeListActivity.class);
                mContext.startActivity(intent);
            }
        });
    }


    /**
     * 当前item数量
     * @return
     */
    @Override
    public int getItemCount() {
        return 6;
    }

    /**
     * 实现内部ViewHolder
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.mu_grid_item_icon);
        }
    }
}
