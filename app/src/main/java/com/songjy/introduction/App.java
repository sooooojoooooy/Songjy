package com.songjy.introduction;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.mapapi.SDKInitializer;
import com.songjy.introduction.common.utils.LanguageManager;
import com.songjy.introduction.common.utils.PreferenceUtils;

import java.util.Locale;

import io.reactivex.Observable;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class App extends Application {

    private static String sCacheDir;
    private static App application;
    private static RequestQueue requestQueue;

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
}
