package com.songjy.introduction.entity.weather;

import java.util.List;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:18.
 */

public class HeWeather5Bean {
    /**
     * aqi : {"city":{"aqi":"77","co":"1","no2":"33","o3":"80","pm10":"44","pm25":"56","qlty":"良","so2":"2"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.90498734","lon":"116.40528870","update":{"loc":"2017-10-19 15:46","utc":"2017-10-19 07:46"}}
     * daily_forecast : [{"astro":{"mr":"05:35","ms":"17:34","sr":"06:29","ss":"17:30"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-19","hum":"64","pcpn":"0.0","pop":"0","pres":"1020","tmp":{"max":"18","min":"9"},"uv":"4","vis":"16","wind":{"deg":"224","dir":"西南风","sc":"微风","spd":"4"}},{"astro":{"mr":"06:35","ms":"18:04","sr":"06:30","ss":"17:29"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2017-10-20","hum":"59","pcpn":"0.0","pop":"0","pres":"1018","tmp":{"max":"20","min":"11"},"uv":"4","vis":"20","wind":{"deg":"58","dir":"东北风","sc":"微风","spd":"6"}},{"astro":{"mr":"07:35","ms":"18:37","sr":"06:31","ss":"17:27"},"cond":{"code_d":"305","code_n":"305","txt_d":"小雨","txt_n":"小雨"},"date":"2017-10-21","hum":"47","pcpn":"0.0","pop":"13","pres":"1021","tmp":{"max":"18","min":"9"},"uv":"3","vis":"19","wind":{"deg":"72","dir":"东北风","sc":"微风","spd":"4"}}]
     * hourly_forecast : [{"cond":{"code":"100","txt":"晴"},"date":"2017-10-19 16:00","hum":"70","pop":"0","pres":"1020","tmp":"16","wind":{"deg":"108","dir":"东南风","sc":"微风","spd":"7"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-10-19 19:00","hum":"90","pop":"0","pres":"1021","tmp":"13","wind":{"deg":"89","dir":"东风","sc":"微风","spd":"6"}},{"cond":{"code":"100","txt":"晴"},"date":"2017-10-19 22:00","hum":"91","pop":"0","pres":"1020","tmp":"11","wind":{"deg":"178","dir":"南风","sc":"微风","spd":"3"}}]
     * now : {"cond":{"code":"101","txt":"多云"},"fl":"16","hum":"71","pcpn":"0","pres":"1019","tmp":"17","vis":"8","wind":{"deg":"176","dir":"南风","sc":"微风","spd":"7"}}
     * status : ok
     * suggestion : {"air":{"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"},"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"较舒适","txt":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"sport":{"brf":"适宜","txt":"天气较好，赶快投身大自然参与户外运动，尽情感受运动的快乐吧。"},"trav":{"brf":"适宜","txt":"天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"},"uv":{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}}
     */

    private AqiBean aqi;
    private BasicBean basic;
    private NowBean now;
    private String status;
    private SuggestionBean suggestion;
    private List<DailyForecastBean> daily_forecast;
    private List<HourlyForecastBean> hourly_forecast;

    public AqiBean getAqi() {
        return aqi;
    }

    public void setAqi(AqiBean aqi) {
        this.aqi = aqi;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionBean getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
        this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDaily_forecast() {
        return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
        this.daily_forecast = daily_forecast;
    }

    public List<HourlyForecastBean> getHourly_forecast() {
        return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
        this.hourly_forecast = hourly_forecast;
    }
}
