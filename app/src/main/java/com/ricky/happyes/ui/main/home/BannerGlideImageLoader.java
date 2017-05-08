package com.ricky.happyes.ui.main.home;

import android.content.Context;
import android.widget.ImageView;

import com.ricky.happyes.util.ImageUtils;
import com.youth.banner.loader.ImageLoader;

/**
 * 首页banner图片加载器
 * Created by Ricky on 2017-4-18.
 */

public class BannerGlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        ImageUtils.getInstance().loadBannerImage(context, (String) path, imageView);
    }

    @Override
    public ImageView createImageView(Context context) {
        ImageView mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return mImageView;
    }
}
