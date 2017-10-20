package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:18.
 */

public class AqiBean {
    /**
     * city : {"aqi":"77","co":"1","no2":"33","o3":"80","pm10":"44","pm25":"56","qlty":"良","so2":"2"}
     */

    private CityBean city;

    public CityBean getCity() {
        return city;
    }

    public void setCity(CityBean city) {
        this.city = city;
    }
}
