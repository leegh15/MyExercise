package com.lgh.tool.myview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.lgh.tool.R;
import com.lgh.tool.utils.DeviceUtil;

/**
 * Created by Administrator on 2016/3/3.
 */
public class MyCustomView extends View implements Runnable{
    private Context context;
    private Paint paint;
    private int radiu;
    private Bitmap bitmap;
    private int x;
    private int y;
    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initPaint();
        initRes(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(DeviceUtil.getScreenSize((Activity) context)[0] / 2, DeviceUtil.getScreenSize((Activity) context)[1] / 2, radiu, paint);
        canvas.drawRect(0, 0, DeviceUtil.getScreenSize((Activity) context)[0] / 2, DeviceUtil.getScreenSize((Activity) context)[1] / 2, paint);
        canvas.drawBitmap(bitmap,x,y,paint);
    }
    public void initPaint(){
        paint =new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
// 生成色彩矩阵
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.393F, 0.769F, 0.189F, 0, 0,
                0.349F, 0.686F, 0.168F, 0, 0,
                0.272F, 0.534F, 0.131F, 0, 0,
                0, 0, 0, 1, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

    }
    /**
     * 初始化资源
     */
    private void initRes(Context context) {
        // 获取位图
        bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.iv_head);

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        x = DeviceUtil.getScreenSize((Activity) context)[0] / 2 - bitmap.getWidth() / 2;
        y = DeviceUtil.getScreenSize((Activity) context)[1] / 2 - bitmap.getHeight() / 2;
    }
//    public synchronized void setRadiu(int radiu){
//        this.radiu=radiu;
//        invalidate();
//    }

    @Override
    public void run() {
        /*
         * 确保线程不断执行不断刷新界面
         */
        while (true){
            if (radiu<200){
                radiu++;
                postInvalidate();
            }else {
                radiu=0;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
