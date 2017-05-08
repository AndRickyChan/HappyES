package com.ricky.happyes.widgets.imageloader.glide;

import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ricky.happyes.widgets.imageloader.ImageConfig;

/**
 * Glide加载图片配置类
 * Created by Ricky on 2017-4-18.
 */

public class GlideImageConfig extends ImageConfig {
    private int cacheCategry;//加载策略
    private int scaleType;
    private BitmapTransformation transformation;//glide进行图片形状变换

    public GlideImageConfig(Builder builder) {
        this.cacheCategry = builder.cacheCategry;
        this.transformation = builder.transformation;
        this.url = builder.url;
        this.errorView = builder.errorImage;
        this.placeholderView = builder.placeholderImage;
        this.imageView = builder.mImageView;
        this.scaleType = builder.scaleType;
    }

    public int getScaleType() {
        return scaleType;
    }

    public void setScaleType(int scaleType) {
        this.scaleType = scaleType;
    }

    public int getCacheCategry() {
        return cacheCategry;
    }

    public void setCacheCategry(int cacheCategry) {
        this.cacheCategry = cacheCategry;
    }

    public BitmapTransformation getTransformation() {
        return transformation;
    }

    public void setTransformation(BitmapTransformation transformation) {
        this.transformation = transformation;
    }

    public static class Builder {
        private String url;
        private ImageView mImageView;
        private int errorImage;
        private int placeholderImage;
        private int cacheCategry;
        private int scaleType;
        private BitmapTransformation transformation;

        public Builder() {
            //构造方法中初始化赋值
            this.url = "";
            this.mImageView = null;
            this.errorImage = 0;
            this.placeholderImage = 0;
            this.cacheCategry = 0;
            this.scaleType = 0;
            this.transformation = null;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder imageView(ImageView mImageView) {
            this.mImageView = mImageView;
            return this;
        }

        public Builder errorImage(int errorImage) {
            this.errorImage = errorImage;
            return this;
        }

        public Builder placeholder(int placeholderImage) {
            this.placeholderImage = placeholderImage;
            return this;
        }

        public Builder cacheCategry(int cacheCategry) {
            this.cacheCategry = cacheCategry;
            return this;
        }

        public Builder transformation(BitmapTransformation transformation) {
            this.transformation = transformation;
            return this;
        }

        public Builder scaleType(int scaleType) {
            this.scaleType = scaleType;
            return this;
        }

        public GlideImageConfig build() {
            return new GlideImageConfig(this);
        }
    }
}
