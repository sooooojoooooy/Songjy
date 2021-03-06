package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:29.
 */

public class HourlyForecastBean {
    /**
     * cond : {"code":"100","txt":"晴"}
     * date : 2017-10-19 16:00
     * hum : 70
     * pop : 0
     * pres : 1020
     * tmp : 16
     * wind : {"deg":"108","dir":"东南风","sc":"微风","spd":"7"}
     */

    private CondBean cond;
    private String date;
    private String hum;
    private String pop;
    private String pres;
    private String tmp;
    private WindBean wind;

    public CondBean getCond() {
        return cond;
    }

    public void setCond(CondBean cond) {
        this.cond = cond;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }
}
