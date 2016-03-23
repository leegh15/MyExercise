package com.lgh.tool.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lgh.tool.R;

/**
 * Created by lgh on 2016/1/21.
 */
public class FirstFragment extends Fragment{
    private SwipeRefreshLayout swipeRefresh;
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_first,null);
        swipeRefresh=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);



        swipeRefresh.setColorSchemeResources(R.color.login_font_register,R.color.comment_font,R.color.colorPrimaryDark);
        textView=(TextView)view.findViewById(R.id.tv);
        textView.setText("第一屏");
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("刷新了");
                    }
                }, 3000);
            }
        });
        return view;

    }


}
