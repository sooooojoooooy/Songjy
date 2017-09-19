package com.songjy.introduction.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import com.songjy.introduction.common.Keys;

import java.util.Locale;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class LanguageManager {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static void changeLanguage(Context context, String locale) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        switch (locale){
            case Keys.LANGUAGE_PRE_ITEM_CN:
                config.setLocale(Locale.SIMPLIFIED_CHINESE);
                break;
            case Keys.LANGUAGE_PRE_ITEM_EN:
                config.setLocale(Locale.US);
                break;
            default:
                break;
        }
        resources.updateConfiguration(config, dm);
    }
}
