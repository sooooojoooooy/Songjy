package com.songjy.introduction;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;

import com.songjy.introduction.common.utils.LanguageManager;
import com.songjy.introduction.common.utils.PreferenceUtils;

import java.util.Locale;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class App extends Application {

    private static String sCacheDir;
    private static App application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        // 应用用户选择语言
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            LanguageManager.changeLanguage(this, PreferenceUtils.getLanguage());
        }
        /*
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }
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
}
