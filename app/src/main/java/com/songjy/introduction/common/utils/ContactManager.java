package com.songjy.introduction.common.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;

import com.songjy.introduction.common.C;


/**
 * Created by songjiyuan on 17/9/20.
 */

public class ContactManager {

    /**
     * 跳转到QQ界面（如果安装的话。。）
     * @param context
     * @param qq
     * @return
     */
    public static boolean sendQQMsg(Context context,String qq) {
        try {
            String url = C.SCHEME_QQ_CONTACT + qq;
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 跳转到发送短信界面（系统）
     * @param context
     * @param phoneNumber 电话号
     * @param message
     */
    public static void sendSMS(Context context,String phoneNumber, String message) {
        if (PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
            intent.putExtra("sms_body", message);
            context.startActivity(intent);
        }
    }

    /**
     * 跳转到打电话界面（系统）
     * @param context
     * @param phoneNumber 电话号
     */
    public static void phoneCall(Context context,String phoneNumber) {
        // 已经获得授权，可以打电话
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        //url:统一资源定位符
        //uri:统一资源标示符（更广）
        intent.setData(Uri.parse("tel:"+phoneNumber));
        //开启系统拨号器
        context.startActivity(intent);
    }
}
