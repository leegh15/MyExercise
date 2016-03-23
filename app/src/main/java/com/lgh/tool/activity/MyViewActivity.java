package com.lgh.tool.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;

import com.lgh.tool.R;
import com.lgh.tool.myview.MyCustomView;

/**
 * Created by Administrator on 2016/2/3.
 */
public class MyViewActivity extends Activity {
    private LinearLayout ll_custom;
    private MyCustomView my_customeview;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_myview);
        ll_custom=(LinearLayout)findViewById(R.id.ll_custom);
//        ll_custom.addView(new MyCustomView(this));
        my_customeview=(MyCustomView)findViewById(R.id.my_customeview);
        new Thread(my_customeview).start();
    }
}
