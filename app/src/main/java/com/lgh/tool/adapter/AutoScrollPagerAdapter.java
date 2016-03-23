package com.lgh.tool.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.lgh.tool.R;

import java.util.List;

/**
 * Created by Administrator on 2016/2/19.
 */
public class AutoScrollPagerAdapter extends PagerAdapter {
private int imageView[]={R.drawable.nopic03,R.drawable.nopic03,R.drawable.nopic03};
    private Context context;
    public AutoScrollPagerAdapter(Context context){
        this.context=context;

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return false;
    }
}
