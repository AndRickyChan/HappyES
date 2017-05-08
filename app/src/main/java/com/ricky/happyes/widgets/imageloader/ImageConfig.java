package com.ricky.happyes.widgets.imageloader;

import android.widget.ImageView;

/**
 * 图片加载基础配置类
 * Created by Ricky on 2017-4-18.
 */

public class ImageConfig {
    protected String url ;
    protected ImageView imageView;
    protected int errorView;
    protected int placeholderView;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getErrorView() {
        return errorView;
    }

    public void setErrorView(int errorView) {
        this.errorView = errorView;
    }

    public int getPlaceholderView() {
        return placeholderView;
    }

    public void setPlaceholderView(int placeholderView) {
        this.placeholderView = placeholderView;
    }
}
