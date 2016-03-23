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
public class SelectPopWindow extends PopupWindow {
    private TextView cancel, ok;
    private Context context;
    private View.OnClickListener onClickListener;

    public SelectPopWindow(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
        popUp();
    }

    public void popUp() {
        final View view = LayoutInflater.from(context).inflate(R.layout.popup_choose, null);
        cancel = (TextView) view.findViewById(R.id.cancel);
        ok = (TextView) view.findViewById(R.id.ok);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setAnimationStyle(R.style.PopWindowAnim);
        setOutsideTouchable(true);
        update();
        //防止虚拟软键盘被弹出菜单遮住
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置SelectPopupWindow弹出窗体的背景
        setBackgroundDrawable(dw);

        cancel.setOnClickListener(onClickListener);
        ok.setOnClickListener(onClickListener);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height=view.findViewById(R.id.rl_pop).getTop();
                int y=(int)event.getY();
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (y<height){
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

}
