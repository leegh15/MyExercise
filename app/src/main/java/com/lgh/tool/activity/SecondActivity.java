package com.lgh.tool.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lgh.tool.R;
import com.lgh.tool.activity.common.BaseActivity;
import com.lgh.tool.myview.ClearEditText;
import com.lgh.tool.myview.MyPopWindow;
import com.lgh.tool.myview.SelectPopWindow;
import com.lgh.tool.service.MyService;
import com.lgh.tool.utils.MToast;
import com.lgh.tool.utils.MyToast;
import com.lgh.tool.utils.ShortCutUtils;

/**
 * Created by Administrator on 2016/1/16.
 */
public class SecondActivity extends BaseActivity implements View.OnClickListener ,MyPopWindow.MyPopWindowListener{
    private TextView tv_receive;
    private int type;
    private SecondReceiver receiver;

    private ClearEditText mClearEditText;
    private Button btn_create_icon,btn_popup,btn_poptow;
    private SelectPopWindow selectPopWindow;
    private MyPopWindow myPopWindow;
    private Button btn_touch;
    private TextView tv_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }
    public void initView(){
        tv_receive=(TextView)findViewById(R.id.tv_receive);

        Intent intent=new Intent(this,MyService.class);
        startService(intent);
        Log.i("接受到最终type", type + "");
        receiver=new SecondReceiver();
        IntentFilter filter=new IntentFilter(MyService.ACTION2);
        registerReceiver(receiver, filter);

        mClearEditText = (ClearEditText) findViewById(R.id.filter_edit);
        textChange();
        btn_create_icon=(Button)findViewById(R.id.btn_create_icon);
        btn_create_icon.setOnClickListener(this);
        findViewById(R.id.btn_popup).setOnClickListener(this);
        findViewById(R.id.btn_poptow).setOnClickListener(this);
        findViewById(R.id.btn_popthree).setOnClickListener(this);
        btn_touch=(Button)findViewById(R.id.btn_touch);

        btn_touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "onClick execute");
            }
        });
        btn_touch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("TAG", "onTouch execute, action " + event.getAction());
                return true;
            }
        });
        tv_delete=(TextView)findViewById(R.id.tv_delete);
        tv_delete.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }
    public void textChange(){
        mClearEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mClearEditText.setShakeAnimation();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_create_icon:
            if (ShortCutUtils.hasShortcut(this)){
                ShortCutUtils.delShortcut(this);
                MyToast.showToast(this, "删除图标", 2);
            }else {
                ShortCutUtils.addShortcut(this);
                MyToast.showToast(this,"创建图标",2);
            }
            break;
            case R.id.btn_popup:
                showBottomPopup();
                break;
            case R.id.ok:
                MyToast.showToast(SecondActivity.this,"确定",2);
                popUpWindow.dismiss();
                break;
            //pop第二弹
            case R.id.btn_poptow:
                selectPopWindow=new SelectPopWindow(this, onClickListener);
                selectPopWindow.showAtLocation(findViewById(R.id.btn_poptow), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
            //pop第三弹
            case R.id.btn_popthree:
                myPopWindow=new MyPopWindow();
                myPopWindow.popUp(this);
                myPopWindow.setMyPopWindowListener(this);
                break;

        }
    }
private View.OnClickListener onClickListener=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                selectPopWindow.dismiss();
                break;
            case R.id.ok:
                MyToast.showToast(SecondActivity.this,"确定",2);
                selectPopWindow.dismiss();
                break;
        }
    }
};

    @Override
    public void onOk() {
        MyToast.showToast(this,"第三确定",2);
    }


    public class SecondReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        type=intent.getIntExtra("type",0);
        if (type==1){
            Log.i("接受到最终type", type + "");
            tv_receive.setText("接收到了广播");
        }
    }
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);

    }
    public  void showBottomPopup() {
        View view = View.inflate(this, R.layout.popup_choose, null);
        view.findViewById(R.id.ok).setOnClickListener(this);
        if (popUpWindow == null) {
            popUpWindow = new PopupWindow();
            // 设置SelectPicPopupWindow的View
            popUpWindow.setContentView(view);
            // 设置SelectPicPopupWindow弹出窗体的宽
            popUpWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            // 设置SelectPicPopupWindow弹出窗体的高
            popUpWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            // 设置SelectPicPopupWindow弹出窗体可点击
            popUpWindow.setFocusable(true);
            popUpWindow.setOutsideTouchable(true);
            popUpWindow.update();
            //防止虚拟软键盘被弹出菜单遮住
            popUpWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            // 设置SelectPicPopupWindow弹出窗体动画效果
            popUpWindow.setAnimationStyle(R.style.PopWindowAnim);
//            // 实例化一个ColorDrawable颜色为半透明
//            ColorDrawable dw = new ColorDrawable(0xb0000000);
//            // 设置SelectPicPopupWindow弹出窗体的背景
//            popUpWindow.setBackgroundDrawable(dw);
        } else {
            popUpWindow.setContentView(view);
        }
        popUpWindow.showAtLocation(findViewById(R.id.btn_popup), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

    }
    public void closePopupWindow() {
        if (popUpWindow != null && popUpWindow.isShowing()) {
            popUpWindow.dismiss();
        }
    }


}
