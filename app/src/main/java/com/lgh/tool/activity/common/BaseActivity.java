package com.lgh.tool.activity.common;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lgh.tool.R;
import com.lgh.tool.utils.DeviceUtil;

import java.io.File;


public class BaseActivity extends FragmentActivity {

    protected PopupWindow popUpWindow;
    private Dialog loadingDialog;
    public File tempFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }


    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();

        //config.setToDefaults();
        config.fontScale = 1.0f;
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /*
     * 返回
     */
    public void doBack(View view) {
        finishWithRight();

    }

    @Override
    public void onBackPressed() {
        finishWithRight();

    }

    /**
     * 得到自定义的progressDialog
     *
     * @param msg
     * @return
     */
    public void showProgressDialog(String msg) {

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                getApplicationContext(), R.anim.loading_animation);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息

        loadingDialog = new Dialog(this, R.style.loading_dialog);// 创建自定义样式dialog

        loadingDialog.setCancelable(true);// 不可以用“返回键”取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
        loadingDialog.show();

    }


    public void closeProgressDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

   /* public void setTitleText(String str) {
        title.setText(str);
    }*/

    /**
     * 右侧进入
     *
     * @param intent
     */
    public void startActivityWithRight(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    /**
     * 右侧退出
     */
    public void finishWithRight() {
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    /**
     * 下方进入
     *
     * @param intent
     */
    public void startActivityWithBottom(Intent intent) {
        startActivity(intent);
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_top_out);
    }

    /**
     * 下方退出
     */
    public void finishWithBottom() {
        finish();
        overridePendingTransition(R.anim.push_top_in, R.anim.push_bottom_out);
    }
    public void showPopupWindow(View view, View windowTokenView, boolean showAsDropDown, int height) {
        if (popUpWindow == null) {
            popUpWindow = new PopupWindow();
            // 设置SelectPicPopupWindow的View
            popUpWindow.setContentView(view);
            // 设置SelectPicPopupWindow弹出窗体的宽
            if (showAsDropDown) {
                popUpWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            } else {
                popUpWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            }
            // 设置SelectPicPopupWindow弹出窗体的高
            popUpWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            // 设置SelectPicPopupWindow弹出窗体可点击
            popUpWindow.setFocusable(true);
            //防止虚拟软键盘被弹出菜单遮住
            popUpWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            if (!showAsDropDown) {
                // 设置SelectPicPopupWindow弹出窗体动画效果
                popUpWindow.setAnimationStyle(R.style.PopWindowAnim);
            }
            // 实例化一个ColorDrawable颜色为半透明
            ColorDrawable dw = new ColorDrawable(0xb0000000);
            // 设置SelectPicPopupWindow弹出窗体的背景
            popUpWindow.setBackgroundDrawable(dw);
        } else {
            popUpWindow.setContentView(view);
        }

        if (showAsDropDown) {
            popUpWindow.showAsDropDown(windowTokenView, 20, -120);
        } else {
            popUpWindow.showAtLocation(windowTokenView, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, DeviceUtil.dip2px(getApplicationContext(), height));
        }
    }

    public void closePopupWindow() {
        if (popUpWindow != null && popUpWindow.isShowing()) {
            popUpWindow.dismiss();
        }
    }
    /**
     * 设置晃动动画
     * @param counts 晃动多少下
     * @param durationMillis 持续秒时间
     */
    public void setShakeAnimation(View view,int counts,int durationMillis){
        Animation translateAnimation = new TranslateAnimation(-10, 10, 10, -10);//动画晃动位置
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(durationMillis*1000);
//        view.setAnimation(translateAnimation);
        view.startAnimation(translateAnimation);
    }
}
