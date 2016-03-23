package com.lgh.tool.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgh.tool.R;
import com.lgh.tool.fragment.FirstFragment;
import com.lgh.tool.fragment.SecondFragment;
import com.lgh.tool.fragment.ThirdFragment;

/**
 * Created by Administrator on 2016/1/22.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"tab1","tab2","tab3"};
    private Context context;
    private final Fragment[] fragments={new FirstFragment(),new SecondFragment(),new ThirdFragment()};
    private int[] imageResId = {
            R.drawable.acm_inputbox,
            R.drawable.acm_inputbox,
            R.drawable.acm_inputbox
    };

    public MyPagerAdapter(FragmentManager fragmentManager,Context context){
        super(fragmentManager);
        this.context=context;
    }
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return tabTitles[position];//1.只有文字

        /**
         * 2.图片
        Drawable image = context.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
        */

        /**
         * 3.文字和图片
         *  // Generate title based on item position
         Drawable image = context.getResources().getDrawable(imageResId[position]);
         image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
         // Replace blank spaces with image icon
         SpannableString sb = new SpannableString("   " + tabTitles[position]);
         ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
         sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
         return sb;
         */
       return null;//4.自定义view时候
    }
    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv= (TextView) view.findViewById(R.id.tv_tab_item);
        tv.setText(tabTitles[position]);
//        ImageView img = (ImageView) view.findViewById(R.id.imageView);
//        img.setImageResource(imageResId[position]);
        return view;
    }
}
