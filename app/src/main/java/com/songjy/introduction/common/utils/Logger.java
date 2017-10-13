package com.songjy.introduction.common.utils;

import android.util.Log;

/**
 * Created by songjiyuan
 * on 17/9/27 # 下午3:42.
 */

public class Logger {

    private static String Tag = "";

    private static final boolean isDebug = true;

    public Logger(String Tag) {
        this.Tag = Tag;
    }

    public static void v(String msg) {
        if (isDebug) {
            Log.v(Tag, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(Tag, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(Tag, msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(Tag, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(Tag, msg);
        }
    }
}
