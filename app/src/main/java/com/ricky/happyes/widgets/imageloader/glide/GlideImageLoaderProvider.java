package com.ricky.happyes.widgets.imageloader.glide;

import android.content.Context;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ricky.happyes.widgets.imageloader.BaseImageLoaderProvider;

/**
 * Glide图片加载配置提供器
 * Created by Ricky on 2017-4-18.
 */

public class GlideImageLoaderProvider implements BaseImageLoaderProvider<GlideImageConfig> {

    @Override
    public void loadImage(Context mContext, GlideImageConfig config) {
        if (mContext == null) {
            throw new IllegalStateException("Context is required");
        }
        if (config == null) {
            throw new IllegalStateException("Config is required");
        }
        if (config.getImageView() == null) {
            throw new IllegalStateException("ImageView is required");
        }

        RequestManager manager;
        manager = Glide.with(mContext);

        DrawableRequestBuilder<String> requestBuilder;
        requestBuilder = manager.load(config.getUrl());
        requestBuilder.crossFade();
        //设置缩放模式
        switch (config.getScaleType()) {
            case GlideScaleType.CENTER_CROP:
                requestBuilder.centerCrop();
                break;
            case GlideScaleType.FIT_CENTER:
                requestBuilder.fitCenter();
                break;
        }

        //设置缓存策略
        switch (config.getCacheCategry()) {
            case GlideCacheCategry.ALL:
                requestBuilder.diskCacheStrategy(DiskCacheStrategy.ALL);
                break;
            case GlideCacheCategry.NONE:
                requestBuilder.diskCacheStrategy(DiskCacheStrategy.NONE);
                break;
            case GlideCacheCategry.RESULT:
                requestBuilder.diskCacheStrategy(DiskCacheStrategy.RESULT);
                break;
            case GlideCacheCategry.SOURCE:
                requestBuilder.diskCacheStrategy(DiskCacheStrategy.SOURCE);
                break;
        }

        if (config.getTransformation() != null) {
            requestBuilder.transform(config.getTransformation());
        }

        if (config.getErrorView() != 0) {
            requestBuilder.error(config.getErrorView());
        }
        if (config.getPlaceholderView() != 0) {
            requestBuilder.placeholder(config.getPlaceholderView());
        }

        requestBuilder.into(config.getImageView());
    }
}
