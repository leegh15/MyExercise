package com.lgh.tool.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.lgh.tool.R;
import com.lgh.tool.adapter.MyCheckListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/3/22.
 */
public class MyCBListViewActivity extends Activity {
    private ListView listView;
    private MyCheckListViewAdapter adapter;
    //    private String[] beans = new String[] { "1", "2", "3", "4", "5", "6", "7",
//            "8", "9", "10", "11", "12", "13","14","15","16","17","18","19" };
//    private List<String> list=new ArrayList<String>();
    List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycblistview);
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyCheckListViewAdapter(MyCBListViewActivity.this, list);
        listView.setAdapter(adapter);
        getData();
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    //    public void initData(){
//        for (int i=0;i<20;i++){
//            list.add("第"+i+"项");
//        }
//    }
    private void getData() {
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("cbid", i);
            map.put("text", "本元素的上边缘" + i);
            list.add(map);
        }

    }
}
