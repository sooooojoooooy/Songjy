package com.songjy.introduction.common.utils;

import android.app.Application;
import android.content.Context;

import com.songjy.introduction.App;
import com.songjy.introduction.common.Keys;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class PreferenceUtils extends BasePreference {

    public static void setLanguage(String name) {
        setPrefString(App.getInstance().getApplicationContext(),Keys.LANGUAGE_PREFERENCE,name);
    }

    public static String getLanguage() {
        return getPrefString(App.getInstance().getApplicationContext(),Keys.LANGUAGE_PREFERENCE,Keys.LANGUAGE_PRE_ITEM_CN);
    }
}
