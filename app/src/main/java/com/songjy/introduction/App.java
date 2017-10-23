package com.songjy.introduction;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.mapapi.SDKInitializer;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.songjy.introduction.common.utils.LanguageManager;
import com.songjy.introduction.common.utils.PreferenceUtils;


import java.io.File;

import io.reactivex.Observable;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class App extends Application {

    private static String sCacheDir;
    private static App application;
    private static RequestQueue requestQueue;
    private static DisplayImageOptions option;

    @Override
    public void onCreate() {
        super.onCreate();
        Observable.just(getApplicationContext())
                .doOnNext(context -> application = this)
                .doOnNext(context -> {
                    // 应用用户选择语言
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        LanguageManager.changeLanguage(this, PreferenceUtils.getLanguage());
                    }
                })
                .doOnNext(context -> {
                    //  如果存在SD卡则将缓存写入SD卡,否则写入手机内存
                    if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
                        sCacheDir = getApplicationContext().getExternalCacheDir().toString();
                    } else {
                        sCacheDir = getApplicationContext().getCacheDir().toString();
                    }
                })
                .doOnNext(context -> {
                    SDKInitializer.initialize(getApplicationContext());
                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    ImageLoader.getInstance().init(getImageConfig());
                })
                .subscribe();
    }

    public static Application getInstance() {
        return application;
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    private ImageLoaderConfiguration getImageConfig() {
        return new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions 内存缓存文件的最大长宽
                .threadPoolSize(5) // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 1) // 设置当前线程的优先级
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(5 * 1024 * 1024))
                .memoryCacheSize(5 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(getApplicationContext())) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();
    }

    public static DisplayImageOptions getOption() {
        if (option == null){
            option = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.mipmap.ic_launcher)//设置图片下载期间显示的图片
//                    .showImageForEmptyUri(R.drawable.emptyurl)//设置图片uri为空或是错误的时候显示的图片
//                    .showImageOnFail(R.drawable.emptyurl)//设置图片加载或解码过程中发生错误显示的图片
                    .resetViewBeforeLoading(false)//设置图片在加载前是否重置、复位
//.delayBeforeLoading(1000)//下载前的延迟时间
                    .cacheInMemory(true)//设置下载的图片是否缓存在内存中
                    .cacheOnDisk(true)//设置下载的图片是否缓存在sd卡中
                    .considerExifParams(false)//思考可交换的参数
                    .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)//设置图片的显示比例
                    .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型
                    .displayer(new RoundedBitmapDisplayer(40))//设置图片的圆角半径
                    .displayer(new FadeInBitmapDisplayer(3000))//设置图片显示的透明度过程的时间
                    .build();
        }
        return option;
    }
}
