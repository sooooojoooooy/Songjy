package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:23.
 */

public class SuggestBean {
    /**
     * brf : 很差
     * txt : 气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。
     */

    private String brf;

    private String txt;

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
