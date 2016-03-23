package com.lgh.tool.activity;


import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.lgh.tool.R;
import com.lgh.tool.adapter.MyPagerAdapter;

/**
 * Created by Administrator on 2016/2/3.
 */
public class TabActivity extends FragmentActivity {
    private MyPagerAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        adapter=new MyPagerAdapter(getSupportFragmentManager(),this);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        tabLayout=(TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab自定义view时候

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }
}
