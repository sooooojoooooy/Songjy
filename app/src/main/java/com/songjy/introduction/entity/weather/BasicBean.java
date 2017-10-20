package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:21.
 */

public class BasicBean {
    /**
     * city : 北京
     * cnty : 中国
     * id : CN101010100
     * lat : 39.90498734
     * lon : 116.40528870
     * update : {"loc":"2017-10-19 15:46","utc":"2017-10-19 07:46"}
     */

    private String city;
    private String cnty;
    private String id;
    private String lat;
    private String lon;
    private UpdateBean update;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }
}
