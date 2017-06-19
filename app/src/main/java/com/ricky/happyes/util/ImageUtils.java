package com.ricky.happyes.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ricky.happyes.R;
import com.ricky.happyes.widgets.imageloader.ImageLoaderUtils;
import com.ricky.happyes.widgets.imageloader.glide.GlideCircleTransform;
import com.ricky.happyes.widgets.imageloader.glide.GlideImageConfig;
import com.ricky.happyes.widgets.imageloader.glide.GlideScaleType;

/**
 * 图片加载工具
 * Created by Ricky on 2017-3-18.
 */

public class ImageUtils {

    private static ImageUtils instance;
    private ImageLoaderUtils mImageLoaderUtils;

    private ImageUtils() {
        mImageLoaderUtils = new ImageLoaderUtils();
    }

    /**
     * 单例模式获取实例
     */
    public static ImageUtils getInstance() {
        if (instance == null) {
            synchronized (ImageUtils.class) {
                if (instance == null) {
                    instance = new ImageUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 加载头像为圆形
     *
     * @param url        头像地址
     * @param mImageView 头像加载器
     */
    public void loadPortraitHeader(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_user_portrait)
                .placeholder(R.drawable.ic_default_user_portrait)
                .transformation(new GlideCircleTransform(mContext))
                .imageView(mImageView)
                .scaleType(GlideScaleType.CENTER_CROP)
                .build());
    }

    /**
     * 加载首页banner图片集合
     */
    public void loadBannerImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .imageView(mImageView)
                .scaleType(GlideScaleType.CENTER_CROP)
                .build());
    }

    /**
     * 加载首页中最热景点的图片
     */
    public void loadHotTravelItemImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .imageView(mImageView)
                .scaleType(GlideScaleType.CENTER_CROP)
                .build());
    }

    /**
     * 加载美食类型图片
     */
    public void loadFoodTypeImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .transformation(new GlideCircleTransform(mContext))
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }

    /**
     * 加载商家列表图片
     */
    public void loadShopLogoImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }

    /**
     * 加载商家套餐图片
     */
    public void loadMealLogoImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }

    /**
     * 加载商家背景图片
     */
    public void loadShopBgLogoImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }

    /**
     * 加载套餐背景图片
     */
    public void loadMealBgLogoImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }
    /**
     * 加载套餐背景图片
     */
    public void loadTravelBgLogoImage(Context mContext, String url, ImageView mImageView) {
        mImageLoaderUtils.loadImage(mContext, new GlideImageConfig.Builder()
                .url(url)
                .errorImage(R.drawable.ic_default_test)
                .placeholder(R.drawable.ic_default_test)
                .scaleType(GlideScaleType.CENTER_CROP)
                .imageView(mImageView)
                .build());
    }
}
