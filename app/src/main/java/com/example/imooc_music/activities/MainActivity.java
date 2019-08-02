package com.example.imooc_music.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.imooc_music.R;
import com.example.imooc_music.adapters.MusicGridAdapter;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {
    //专辑列表
    private RecyclerView muGrid;

    private MusicGridAdapter adapter;

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
        muGrid.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
    }

    /**
     * 导航到个人中心页
     * @param view
     */
    public void routerMe(View view) {
        startActivity(new Intent(this, MeActivity.class));
    }
}
