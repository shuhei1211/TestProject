package com.example.app.controller;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.preference.PreferenceManager;

import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.util.AQUtility;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import jp.shuhei.iwamoto.customlogger.Logged;

public class ApplicationController extends Application {

    // *******************************************************************
    // Constants
    // *******************************************************************
    /** debug mode */
    public static final boolean DEBUG_MODE = true;


    // *******************************************************************
    // LifeCycle
    // *******************************************************************
    @Override
    public void onCreate() {
        doStrictMode();
        super.onCreate();
        Logged.i("Application onCreate");
        setImageLoaderConfig();
    }

    @Override
    public void onLowMemory() {
        Logged.i("Application onLowMemory");
        BitmapAjaxCallback.clearCache();
    }

    @Override
    public void onTerminate() {
        Logged.i("Application onTerminate");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Logged.i("Application onConfigurationChanged");
    }

    // *******************************************************************
    // method
    // *******************************************************************
    /** Get Application Setting */
    public SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    /** StrictMode */
    private void doStrictMode() {
        if (DEBUG_MODE)
            AQUtility.debug("enable strict mode!");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
    }

    /**
     * https://github.com/nostra13/Android-Universal-Image-Loader
     * http://qiita.com/chuross/items/e3ca79065d9b67716ace
     * UniversalImageLoader setImageLoaderConfigiration
     * memoryCacheExtraOptions -
     */
    private void setImageLoaderConfig() {
        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .discCacheExtraOptions(480, 800, Bitmap.CompressFormat.JPEG, 75)
//        .taskExecutor(...)
//        .taskExecutorForCachedImages(...)
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 1) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LRULimitedMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(1000 * 1024 * 1024)
//        .memoryCacheSizePercentage(13) // default
                .discCache(new UnlimitedDiscCache(cacheDir)) // default
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileCount(100)
                .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new ImageDownloader() {
                    @Override
                    protected InputStream getStreamFromNetwork(URI uri) throws IOException {
                        return null;
                    }
                })
//                .imageDownloader(new BaseImageDownloader(getApplicationContext())) // default
//                .imageDecoder(new BaseImageDecoder()) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .build();
    }
}
