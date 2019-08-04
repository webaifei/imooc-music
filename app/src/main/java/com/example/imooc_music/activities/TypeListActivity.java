package com.example.imooc_music.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.imooc_music.R;
import com.example.imooc_music.adapters.AlbumAdapter;

public class TypeListActivity extends BaseActivity {

    private RecyclerView rcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);

        init();
    }

    /**
     * 初始化操作
     */
    private void init() {
        initNavgationBar(true, "专辑列表", false);
        rcList = findViewById(R.id.ms_album_list);
        // 设置layoutManager
        rcList.setLayoutManager(new LinearLayoutManager(this));
        // 设置adapter
        rcList.setAdapter(new AlbumAdapter(this));


    }
}
