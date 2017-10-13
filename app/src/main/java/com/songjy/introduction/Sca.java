package com.songjy.introduction;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by songjiyuan
 * on 17/10/11 # 下午2:28.
 */

public class Sca {

    static final String Url = "http://113.108.182.3:10080/apiweb/unitorder";
    static final String merId = "990581007426001";
    static final String APPID = "00000051";
    static final String KEY = "allinpay888";

    public static void main(String[] a) {
        Map<String, String> param = new HashMap<>();
        param.put("cusid", merId);
        param.put("appid", APPID);
        param.put("version", "11");
        param.put("trxamt", "100");
        param.put("reqsn", "");
        param.put("paytype", "");
        param.put("randomstr", "");
        param.put("body", "");
        param.put("remark", "");
        param.put("validtime", "");
        param.put("notify_url", "");
        param.put("limit_pay", "");
        param.put("sign", "");
    }
}
