package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:22.
 */

public class CondBean {
    /**
     * code : 101
     * txt : 多云
     * "code_d": "104",
     * "code_n": "101",
     * "txt_d": "阴",
     * "txt_n": "多云"
     */

    private String code;
    private String txt;
    private String code_d;
    private String code_n;
    private String txt_d;
    private String txt_n;

    public String getCode_d() {
        return code_d;
    }

    public void setCode_d(String code_d) {
        this.code_d = code_d;
    }

    public String getCode_n() {
        return code_n;
    }

    public void setCode_n(String code_n) {
        this.code_n = code_n;
    }

    public String getTxt_d() {
        return txt_d;
    }

    public void setTxt_d(String txt_d) {
        this.txt_d = txt_d;
    }

    public String getTxt_n() {
        return txt_n;
    }

    public void setTxt_n(String txt_n) {
        this.txt_n = txt_n;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
