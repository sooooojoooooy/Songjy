package com.songjy.introduction.common;

import com.songjy.introduction.R;

/**
 * Created by songjiyuan
 * on 17/10/12 # 下午2:21.
 */

public enum WeatherTypeEnum {
    SUNNY("100", R.mipmap.a100),
    CLOUDY("101", R.mipmap.a101),
    FEW_CLOUDS("102", R.mipmap.a102),
    PARTLY_CLOUDY("103", R.mipmap.a103),
    OVERCAST("104", R.mipmap.a104),
    WINDY("200", R.mipmap.a200),
    CALM("201", R.mipmap.a201),
    LIGHT_BREEZE("202", R.mipmap.a202),
    MODERATE("203", R.mipmap.a203),
    FRESH_BREEZE("204", R.mipmap.a204),
    STRONG_BREEZE("205", R.mipmap.a205),
    HIGH_WIND("206", R.mipmap.a206),
    GALE("207", R.mipmap.a207),
    STRONG_GALE("208", R.mipmap.a208),
    STORM_WIND("209", R.mipmap.a209),
    VIOLENT_STORM("210", R.mipmap.a210),
    HURRICANE("211", R.mipmap.a211),
    TORNADO("212", R.mipmap.a212),
    TROPICAL_STORM("213", R.mipmap.a213),
    SHOWER_RAIN("300", R.mipmap.a300),
    HEAVY_SHOWER_RAIN("301", R.mipmap.a301),
    THUNDERSHOWER("302", R.mipmap.a302),
    HEAVY_THUNDERSTORM("303", R.mipmap.a303),
    HAIL("304", R.mipmap.a304),
    LIGHT_RAIN("305", R.mipmap.a305),
    MODERATE_RAIN("306", R.mipmap.a306),
    HEAVY_RAIN("307", R.mipmap.a307),
    EXTREME_RAIN("308", R.mipmap.a308),
    DRIZZLE_RAIN("309", R.mipmap.a309),
    STORM_RAIN("310", R.mipmap.a310),
    HEAVY_STORM("311", R.mipmap.a311),
    SEVERE_STORM("312", R.mipmap.a312),
    FREEZING_RAIN("313", R.mipmap.a313),
    LIGHT_SNOW("400", R.mipmap.a400),
    MODERATE_SNOW("401", R.mipmap.a401),
    HEAVY_SNOW("402", R.mipmap.a402),
    SNOWSTORM("403", R.mipmap.a403),
    SLEET("404", R.mipmap.a404),
    RAIN_AND_SNOW("405", R.mipmap.a405),
    SHOWER_SNOW("406", R.mipmap.a406),
    SNOW_FLURRY("407", R.mipmap.a407),
    MIST("500", R.mipmap.a500),
    FOGGY("501", R.mipmap.a501),
    HAZE("502", R.mipmap.a502),
    SAND("503", R.mipmap.a503),
    DUST("504", R.mipmap.a504),
    DUSTSTORM("507", R.mipmap.a507),
    SANDSTORM("508", R.mipmap.a508),
    UNKNOWN("999", R.mipmap.a999);

    // 成员变量
    private String name;
    private int id;

    WeatherTypeEnum(String s, int i) {
        this.name = s;
        this.id = i;
    }

    // 普通方法
    public static int getResId(String name) {
        for (WeatherTypeEnum c : WeatherTypeEnum.values()) {
            if (c.getName().equals(name)) {
                return c.id;
            }
        }
        return UNKNOWN.getId();
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
