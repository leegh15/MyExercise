package com.lgh.tool.utils;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;


import com.lgh.tool.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admins on 2015/9/19.
 * 图片下载方法的return
 * author  zpp
 */
public class ImageLoaderUtils {

    //圆角矩形
    public DisplayImageOptions setRectangleOptions(){
        DisplayImageOptions DisplayImageOptions = null;
        DisplayImageOptions = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.nopic03) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.nopic03) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.nopic03) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角矩形图片
                .build(); // 创建配置过得DisplayImageOption对象
        return DisplayImageOptions;
    }
    //圆形图片
    public DisplayImageOptions setCirclelmageOptions(){
        DisplayImageOptions DisplayImageOptions = null;
        DisplayImageOptions = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.nopic03) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.nopic03) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.nopic03) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new CircleBitmapDisplayer()) // 设置成圆角图片
                .build(); // 创建配置过得DisplayImageOption对象
        return DisplayImageOptions;
    }
    //图片铺满布局（有拉伸）
    public DisplayImageOptions setFullOptions() {
        DisplayImageOptions DisplayImageOptions = null;
        DisplayImageOptions = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.nopic03) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.nopic03) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.nopic03) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY_STRETCHED) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(0))// 设置下载的图片是否缓存在SD卡中//矩形
                .build(); // 创建配置过得DisplayImageOption对象
        return DisplayImageOptions;
    }
    //center图片无伸缩 但可能无法铺满布局
    public DisplayImageOptions setcenterOptions(){
        DisplayImageOptions DisplayImageOptions = null;
        DisplayImageOptions = new  DisplayImageOptions.Builder()//
                .cacheInMemory(true)//
                .cacheOnDisk(true)//
                .bitmapConfig(Bitmap.Config.RGB_565)//
                .build();
        return DisplayImageOptions;

    }
    public static class AnimateFirstDisplayListener extends
            SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections
                .synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view,
                                      Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                // 是否第一次显示
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    // 图片淡入效果
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
    public boolean fileIsExists(String name){
        try{
            File f=new File(name);
            if(!f.exists()){
                return false;
            }

        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
}
