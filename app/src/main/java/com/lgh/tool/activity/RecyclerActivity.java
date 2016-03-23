package com.lgh.tool.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lgh.tool.R;
import com.lgh.tool.activity.common.BaseActivity;
import com.lgh.tool.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/18.
 */
public class RecyclerActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private List<String> mData = new ArrayList<String>();
    ;
    private LinearLayoutManager mLayoutManager;
    private MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerView.setHasFixedSize(true);
        adapter=new MyRecyclerViewAdapter(RecyclerActivity.this, mData);
        recyclerView.setAdapter(adapter);
        initData();
//        recyclerView.addItemDecoration(new );
        adapter.setOnItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(RecyclerActivity.this,"这是第"+position+"项。。。"+ mData.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initData() {
        for (int i = 0; i <= 10; i++) {
            mData.add(i, "RecyclerView" + i);
        }
    }

}
