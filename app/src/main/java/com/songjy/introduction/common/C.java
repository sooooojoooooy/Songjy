package com.songjy.introduction.common;

import com.songjy.introduction.App;

import java.io.File;

/**
 * Created by songjiyuan on 17/9/19.
 */

public class C {

    //  联系方式
    public static final String QQ = "957555825";
    public static final String PHONE = "+8613521250289";
    public static final String E_MAIL = "songjiyuan1994@icloud.com";
    public static final String WECHAT_ID = "songsamalove";

    //  文件路径
    public static final String NET_CACHE = App.getAppCacheDir() + File.separator + "NetCache";

    //  Url
    public static final String SCHEME_QQ_CONTACT = "mqqwpa://im/chat?chat_type=wpa&uin=";
    public static final String URL_DOUBAN = "https://api.douban.com/v2/movie/top250";

    // 百度地图设置
    public static final float BD_ZOOM = 18.0f;
    public static final int BD_SCAN_SPAN = 1000;
    public static final String BD_COOR_TYPE = "bd09ll";
    public static final boolean isGPS = true;
}
