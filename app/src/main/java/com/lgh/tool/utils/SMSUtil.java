package com.lgh.tool.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created by Administrator on 2016/3/1.
 */
public class SMSUtil {


    private static IValidateSMSCode iValidateSMSCode;
    public static String CHINA = "86";
    private static Handler mSMSHandle = new MySMSHandler();
    public static void initSDK(Context context,String appkey, String appSecrect){

        SMSSDK.initSDK(context,appkey,appSecrect);
        EventHandler eh=new EventHandler(){

            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                mSMSHandle.sendMessage(msg);
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }
    /**
     * 消息处理Handle
     */
    private static class MySMSHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;

            if (result == SMSSDK.RESULT_COMPLETE) {
                //提交验证码成功
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //验证成功回调
                    if(null != iValidateSMSCode){
                        iValidateSMSCode.OnSucced();
                    }
                }
            } else {
                ((Throwable)data).printStackTrace();
                //验证失败
                if(null != iValidateSMSCode){
                    iValidateSMSCode.OnFiled();
                }
            }
        }
    }
    /**
     * 释放资源
     */
    public static void release(){
        // 销毁回调监听接口
        SMSSDK.unregisterAllEventHandler();
    }

    /**
     * 请求获取短信验证码
     * @param phone 手机号
     */
    public static void getVerificationCode(String country,String phone){
        getVerificationCode(country,phone);
    }
    /**
     * 提交短信验证码，校验是否正确
     * @param phone 手机号
     * @param validateCode 手机短信验证码
     */
    public static void submitVerificationCode(String country,String phone, String validateCode,IValidateSMSCode callback){
        iValidateSMSCode = callback;
        SMSSDK.submitVerificationCode(country, phone, validateCode);
    }
    public interface IValidateSMSCode{
        void OnSucced();
        void OnFiled();
    }

}
