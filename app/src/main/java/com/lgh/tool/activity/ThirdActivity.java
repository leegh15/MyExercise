package com.lgh.tool.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.ViewGroup;

import com.lgh.tool.R;
import com.lgh.tool.activity.common.BaseActivity;
import com.lgh.tool.fragment.FirstFragment;
import com.lgh.tool.fragment.SecondFragment;
import com.lgh.tool.fragment.ThirdFragment;
import com.lgh.tool.myview.PagerSlidingTabStrip;

/**
 * Created by Administrator on 2016/1/21.
 */
public class ThirdActivity extends BaseActivity{
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tabs=(PagerSlidingTabStrip)findViewById(R.id.pagersliding);
        pager=(ViewPager)findViewById(R.id.viewpager);
        adapter=new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

    }
    public class MyPagerAdapter extends FragmentPagerAdapter{
//        private final String[] Title={"第一页","第二页","第三页"};
        private final Fragment[] fragments={new FirstFragment(),new SecondFragment(),new ThirdFragment()};
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }
        @Override
        public int getCount() {
            return fragments.length;
        }


    }
}
