package com.ricky.happyes.widgets.imageloader.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;
import com.ricky.happyes.util.DataCleanUtils;

import java.io.File;

/**
 * glide缓存
 * Created by Ricky on 2017-4-18.
 */

public class GlideCacheConfiguration implements GlideModule {

    private static final int MAX_CACHE_SIZE = 100 * 1024 * 1024;//缓存最大值

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //设置磁盘缓存
        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                File cacheFile = new File(DataCleanUtils.getCachePath(context), "HappyES" + File.separator + "Glide");
                return DiskLruCacheWrapper.get(cacheFile, MAX_CACHE_SIZE);
            }
        });

        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);
        //扩大内存缓存
        builder.setMemoryCache(new LruResourceCache(customMemoryCacheSize));
        builder.setBitmapPool(new LruBitmapPool(customBitmapPoolSize));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
