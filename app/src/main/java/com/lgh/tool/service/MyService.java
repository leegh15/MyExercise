package com.lgh.tool.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/1/18.
 */
public class MyService extends Service {
    public static final String ACTION1="com.lgh.tool.myservice";
    public static final String ACTION2="com.lgh.tool.myservice2";
    private MyRecever myRecever;
    private int style;
    private int type;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myRecever=new MyRecever();
        IntentFilter filter=new IntentFilter(ACTION1);

        registerReceiver(myRecever, filter);

    }

    public class MyRecever extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            style=intent.getIntExtra("style",0);
            if (style==1){
                Log.i("style......", style + "");
                type=1;
            }
            callInService();
        }

    }
    public void callInService() {
        Intent intent2=new Intent(ACTION2);
        intent2.putExtra("type", type);
        sendBroadcast(intent2);
        Log.i("发送type......", type + "");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myRecever);
    }
}
