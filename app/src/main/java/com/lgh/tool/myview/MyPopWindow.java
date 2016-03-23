package com.lgh.tool.myview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lgh.tool.R;

/**
 * Created by Administrator on 2016/2/2.
 */
public class MyPopWindow implements View.OnClickListener {
    private TextView cancel, ok;
//    private Context context;
    private PopupWindow popupWindow;
    private MyPopWindowListener myPopWindowListener;
//    public MyPopWindow(Context context){
//        this.context = context;
//    }
    public void popUp(Context context) {
        final View view = LayoutInflater.from(context).inflate(R.layout.popup_choose, null);
        cancel = (TextView) view.findViewById(R.id.cancel);
        ok = (TextView) view.findViewById(R.id.ok);
        popupWindow=new PopupWindow();
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.PopWindowAnim);
        popupWindow.setOutsideTouchable(true);
        popupWindow.update();
        //防止虚拟软键盘被弹出菜单遮住
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPopupWindow弹出窗体的背景
        popupWindow.setBackgroundDrawable(dw);

        cancel.setOnClickListener(this);
        ok.setOnClickListener(this);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height=view.findViewById(R.id.rl_pop).getTop();
                int y=(int)event.getY();
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (y<height){
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                popupWindow.dismiss();
                break;
            case R.id.ok:
                myPopWindowListener.onOk();
                break;
        }
    }
    public void setMyPopWindowListener(MyPopWindowListener myPopWindowListener){
        this.myPopWindowListener=myPopWindowListener;
    }
    public interface MyPopWindowListener{
        void onOk();
    }
}
