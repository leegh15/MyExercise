package com.lgh.tool.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import com.lgh.tool.R;
import com.lgh.tool.activity.common.BaseActivity;
import com.lgh.tool.service.MyService;
import com.lgh.tool.utils.AsyncHttpHelper;
import com.lgh.tool.utils.ImageUtils;
import com.lgh.tool.utils.LogUtils;
import com.lgh.tool.utils.MToast;
import com.lgh.tool.utils.MyToast;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.leakcanary.LeakCanary;

import org.apache.http.Header;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.jpush.android.api.JPushInterface;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView hehe;
    private ImageView iv_head;
    private static final int REQUEST_IMAGE = 2;

    private static final int PHOTO_REQUEST_CUT = 3;
    private ArrayList<String> mSelectPath;
    private ProgressBar pb;
    private Button btn_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        findViewById(R.id.btn_send1).setOnClickListener(this);
        findViewById(R.id.btn_send2).setOnClickListener(this);
        findViewById(R.id.btn_broadcaset).setOnClickListener(this);
        findViewById(R.id.btn_pagersliding).setOnClickListener(this);
        iv_head=(ImageView)findViewById(R.id.iv_head);
        iv_head.setOnClickListener(this);
        hehe = (TextView) findViewById(R.id.hehe);
        pb=(ProgressBar)findViewById(R.id.pb);
        findViewById(R.id.btn_music).setOnClickListener(this);
        findViewById(R.id.btn_shake).setOnClickListener(this);
        findViewById(R.id.btn_view).setOnClickListener(this);
        findViewById(R.id.btn_tab).setOnClickListener(this);
        findViewById(R.id.btn_listview).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.recycleview).setOnClickListener(this);
        findViewById(R.id.listveiw_checkbox).setOnClickListener(this);
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send1:
                showProgressDialog("正在加载中");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                    }
                }, 3000);
                break;
            case R.id.btn_send2:
                new AlertDialog.Builder(this)
                        .setTitle("退出")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setMessage("确认退出?")
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "退出成功", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                break;
            case R.id.btn_broadcaset:

                Intent intent = new Intent(MyService.ACTION1);
                intent.putExtra("style", 1);
                sendBroadcast(intent);

                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_pagersliding:
                Intent intent3 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent3);
                break;
            case R.id.iv_head:
                Intent iv_intent = new Intent(this, MultiImageSelectorActivity.class);
                // whether show camera
                iv_intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
                // max select image amount
                iv_intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 9);
                // select mode (MultiImageSelectorActivity.MODE_SINGLE OR MultiImageSelectorActivity.MODE_MULTI)
                iv_intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_SINGLE);
                // default select images (support array list)
                // 默认选择
                if(mSelectPath != null && mSelectPath.size()>0) {
                    iv_intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
                }
                startActivityForResult(iv_intent, REQUEST_IMAGE);

                break;
            case R.id.btn_music:
                upLoadMusic();
                break;
            case R.id.btn_shake:
                setShakeAnimation((ImageView)findViewById(R.id.iv_head),20,10);
                setShakeAnimation((ScrollView) findViewById(R.id.scroll), 20, 10);
                MyToast.showToast(MainActivity.this, "咬我啊", 3);
                MToast.showShort(MainActivity.this, "呵呵呵");
                break;
            case R.id.btn_view:
                Intent intent_view=new Intent(MainActivity.this, MyViewActivity.class);
                startActivity(intent_view);
                break;
            case R.id.btn_tab:
                Intent intent_tab=new Intent(MainActivity.this, TabActivity.class);
                startActivity(intent_tab);
                break;
            case R.id.btn_listview:
                Intent intent_list=new Intent(MainActivity.this, PinnedSectionListActivity.class);
                startActivity(intent_list);
                break;
            case R.id.btn_sms:
                Intent intent_sms=new Intent(MainActivity.this, SMSActivity.class);
                startActivity(intent_sms);
                break;
            case R.id.recycleview:
                Intent intent_recycleview=new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent_recycleview);
                break;
            case R.id.listveiw_checkbox:
                Intent intent_cb=new Intent(MainActivity.this, MyCBListViewActivity.class);
                startActivity(intent_cb);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                // Get the result list of select image paths
                mSelectPath = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                Uri uri=Uri.fromFile(new File(mSelectPath.get(0)));
                startPhotoZoom(uri);
                String dest=mSelectPath.get(0);
//                iv_head.setImageBitmap(ImageUtils.pathToBitmap(dest));
            }
        }
        else if (requestCode==PHOTO_REQUEST_CUT){
            if (resultCode == RESULT_OK) {
//                iv_head.setImageDrawable(Drawable.createFromPath(tempFile.getAbsolutePath()));
                iv_head.setImageBitmap(ImageUtils.pathToBitmap(tempFile.getAbsolutePath()));
                //上传图片
                upLoad();
            }

        }
    }
    public void upLoad(){
        RequestParams params=new RequestParams();
        params.put("userId",27964);
        params.put("picId",682247);
        params.put("nickName","呵呵");
        params.put("trueName","吼吼");
        params.put("birthday","1980-01-01");
        params.put("sex",2);
        params.put("marriage",3);
        try {
            params.put("files", new File(tempFile.getAbsolutePath()),"jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String url="http://appapi.rexian.cn:8080/HKCityApi/userinfo/upDateUserInfo";
        AsyncHttpHelper.postAbsoluteUrl(url, params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                String statusMsg = com.alibaba.fastjson.JSONObject.parseObject(s).getString("statusMsg");
                Toast.makeText(MainActivity.this, statusMsg, Toast.LENGTH_SHORT).show();
                LogUtils.i("图片path", tempFile.getAbsolutePath());
                pb.setProgress(0);
            }

            @Override
            public void onProgress(int bytesWritten, int totalSize) {
                super.onProgress(bytesWritten, totalSize);
                int count = (int) ((bytesWritten * 1.0 / totalSize) * 100);
                // 上传进度显示
                pb.setProgress(count);
            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }
        });
    }
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        intent.putExtra("noFaceDetection", true);
        File temp = new File("/sdcard/exerciseTool/");//自已项目 文件夹
        if (!temp.exists()) {
            temp.mkdir();
        }
        tempFile = new File("/sdcard/exerciseTool/" + getPhotoFileName()); // 以时间秒为文件名
        intent.putExtra("output", Uri.fromFile(tempFile));  // 专入目标文件
        intent.putExtra("outputFormat", "JPEG"); //输入文件格式
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    public String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HHmmss");
        return dateFormat.format(date) + ".jpg";
    }
    public Bitmap decodMap(String dest){
        //加载SD卡上的图片
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(dest, opts);
        //获取图片的宽高
        int w = opts.outWidth;
        int h = opts.outHeight;
        //获取屏幕信息
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        //获取屏幕的高和宽
        int sw = metrics.widthPixels;
        int sh = metrics.heightPixels;
        //计算采样因子
        int wSampleSize = w / sw;
        int hSampleSize = h / sh;
        int sampleSize = (wSampleSize > hSampleSize) ? wSampleSize : hSampleSize;
        ///////////////////////根据采样因子从文件中解码出Bitmap对象
        opts.inJustDecodeBounds = false;
        opts.inSampleSize = sampleSize;
        Bitmap bmp = BitmapFactory.decodeFile(dest, opts);
        return bmp;
    }
    public void upLoadMusic(){
//        showProgressDialog("正在上传");
        RequestParams params=new RequestParams();
        params.put("userId",27964);
        params.put("picId",682247);
        params.put("nickName","呵呵");
        params.put("trueName","吼吼");
        params.put("birthday","1980-01-01");
        params.put("sex", 2);
        params.put("marriage",3);
        try {
            params.put("files", new File("/sdcard/Download/sleepalone.mp3"),"mp3");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String url="http://appapi.rexian.cn:8080/HKCityApi/userinfo/upDateUserInfo";
        AsyncHttpHelper.postAbsoluteUrl(url, params, new TextHttpResponseHandler() {

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
            }

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                String statusMsg= com.alibaba.fastjson.JSONObject.parseObject(s).getString("statusMsg");
                Toast.makeText(MainActivity.this, statusMsg, Toast.LENGTH_SHORT).show();

                pb.setProgress(0);
//                closeProgressDialog();
            }

            @Override
            public void onProgress(int bytesWritten, int totalSize) {
                super.onProgress(bytesWritten, totalSize);
                int count = (int) ((bytesWritten * 1.0 / totalSize) * 100);
                // 上传进度显示
                pb.setProgress(count);

            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }
        });
    }
}
