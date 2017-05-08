package com.ricky.happyes.widgets.imageloader;

import android.content.Context;

/**
 * 图片加载配置提供器
 * Created by Ricky on 2017-4-18.
 */

public interface BaseImageLoaderProvider<T extends ImageConfig> {

    void loadImage(Context mContext, T config);

}
