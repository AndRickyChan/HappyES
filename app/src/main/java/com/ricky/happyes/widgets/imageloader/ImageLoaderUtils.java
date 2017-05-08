package com.ricky.happyes.widgets.imageloader;

import android.content.Context;

import com.ricky.happyes.widgets.imageloader.glide.GlideImageLoaderProvider;

/**
 * 图片加载工具
 * Created by Ricky on 2017-4-18.
 */

public class ImageLoaderUtils {

    private  ImageLoaderUtils mInstance;
    private  BaseImageLoaderProvider mProvider;

    public ImageLoaderUtils() {
        mProvider = new GlideImageLoaderProvider();
    }

    public <T extends ImageConfig> void loadImage(Context mContext, T config) {
        this.mProvider.loadImage(mContext, config);
    }
}
