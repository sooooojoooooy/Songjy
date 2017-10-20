package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:22.
 */

public class WindBean {
    /**
     * deg : 176
     * dir : 南风
     * sc : 微风
     * spd : 7
     */

    private String deg;
    private String dir;
    private String sc;
    private String spd;

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }
}
