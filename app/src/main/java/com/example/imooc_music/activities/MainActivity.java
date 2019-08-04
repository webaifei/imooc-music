package com.example.imooc_music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.imooc_music.R;
import com.example.imooc_music.adapters.MusicGridAdapter;
import com.example.imooc_music.adapters.MusicListAdapter;
import com.example.imooc_music.views.ItemDecoration;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {
    //专辑列表
    private RecyclerView muGrid;

    private RecyclerView muList;

    private MusicGridAdapter adapter;

    private MusicListAdapter listAdapter;

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

        muGrid = findViewById(R.id.ms_types_list);

        muGrid.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new MusicGridAdapter(this);
        muGrid.setAdapter(adapter);
        setMuGridOffsets(8);
        muGrid.addItemDecoration(new ItemDecoration(8));
        muGrid.setNestedScrollingEnabled(false);

        muList = findViewById(R.id.ms_music_list);
        muList.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new MusicListAdapter(this, muList);
        muList.setAdapter(listAdapter);
        muList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        muList.setNestedScrollingEnabled(false);

    }

    /**
     * 导航到个人中心页
     *
     * @param view
     */
    public void routerMe(View view) {
        startActivity(new Intent(this, MeActivity.class));
    }

    /**
     * 设置当前recycleview的margin-left
     *
     * @param mSpac
     */
    private void setMuGridOffsets(int mSpac) {
        // 通过将整个recycleview 向左移动 mSpac 来达到效果
        // 获取当前recycleview 的布局参数
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) muGrid.getLayoutParams();
        layoutParams.leftMargin = -mSpac;
        muGrid.setLayoutParams(layoutParams);
    }
}
