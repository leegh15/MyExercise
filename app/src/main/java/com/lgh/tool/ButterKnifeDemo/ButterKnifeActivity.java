package com.lgh.tool.ButterKnifeDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lgh.tool.R;
import com.lgh.tool.myview.StretchScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/3/10.
 */
public class ButterKnifeActivity extends Activity {
    @Bind(R.id.hehe)
    TextView hehe;
    @Bind(R.id.btn_send1)
    Button btnSend1;
    @Bind(R.id.btn_send2)
    Button btnSend2;
    @Bind(R.id.btn_broadcaset)
    Button btnBroadcaset;
    @Bind(R.id.btn_pagersliding)
    Button btnPagersliding;
    @Bind(R.id.iv_head)
    ImageView ivHead;
    @Bind(R.id.pb)
    ProgressBar pb;
    @Bind(R.id.btn_music)
    Button btnMusic;
    @Bind(R.id.btn_shake)
    Button btnShake;
    @Bind(R.id.btn_view)
    Button btnView;
    @Bind(R.id.btn_tab)
    Button btnTab;
    @Bind(R.id.btn_listview)
    Button btnListview;
    @Bind(R.id.btn_sms)
    Button btnSms;
    @Bind(R.id.scroll)
    StretchScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_send1, R.id.btn_send2, R.id.btn_broadcaset, R.id.btn_pagersliding, R.id.iv_head, R.id.btn_music, R.id.btn_shake, R.id.btn_view, R.id.btn_tab, R.id.btn_listview, R.id.btn_sms})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send1:
                break;
            case R.id.btn_send2:
                break;
            case R.id.btn_broadcaset:
                break;
            case R.id.btn_pagersliding:
                break;
            case R.id.iv_head:
                break;
            case R.id.btn_music:
                break;
            case R.id.btn_shake:
                break;
            case R.id.btn_view:
                break;
            case R.id.btn_tab:
                break;
            case R.id.btn_listview:
                break;
            case R.id.btn_sms:
                break;
        }
    }
}
