package com.songjy.introduction.common;

import com.songjy.introduction.App;

import java.io.File;

/**
 * Created by songjiyuan
 * on 17/9/19 # 下午4:12.
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
    public static final String URL_WEATHER = "https://free-api.heweather.com/v5/weather";

    // 百度地图设置
    public static final float BD_ZOOM = 18.0f;
    public static final int BD_SCAN_SPAN = 1000;
    public static final String BD_COOR_TYPE = "bd09ll";
    public static final boolean isGPS = true;

    // 天气
    public static final String WEATHER_KEY = "644ff25beb6f4aa5affa33ad53065569";
    public static final String WEATHER_LOCATION = "Beijing";
}
