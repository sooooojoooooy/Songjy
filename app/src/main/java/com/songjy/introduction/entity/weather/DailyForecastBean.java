package com.songjy.introduction.entity.weather;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:27.
 */

public class DailyForecastBean {
    /**
     * astro : {"mr":"05:35","ms":"17:34","sr":"06:29","ss":"17:30"}
     * cond : {"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"}
     * date : 2017-10-19
     * hum : 64
     * pcpn : 0.0
     * pop : 0
     * pres : 1020
     * tmp : {"max":"18","min":"9"}
     * uv : 4
     * vis : 16
     * wind : {"deg":"224","dir":"西南风","sc":"微风","spd":"4"}
     */

    private AstroBean astro;
    private CondBean cond;
    private String date;
    private String hum;
    private String pcpn;
    private String pop;
    private String pres;
    private TmpBean tmp;
    private String uv;
    private String vis;
    private WindBean wind;

    public AstroBean getAstro() {
        return astro;
    }

    public void setAstro(AstroBean astro) {
        this.astro = astro;
    }

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

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
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

    public TmpBean getTmp() {
        return tmp;
    }

    public void setTmp(TmpBean tmp) {
        this.tmp = tmp;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }
}
