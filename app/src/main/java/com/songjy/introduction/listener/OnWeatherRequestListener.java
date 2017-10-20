package com.songjy.introduction.listener;

import com.songjy.introduction.entity.weather.WeatherEntity;

/**
 * Created by songjiyuan
 * on 17/10/20 # 上午11:13.
 */

public interface OnWeatherRequestListener {
    void onSuccess(WeatherEntity req);

    void onFail();
}
