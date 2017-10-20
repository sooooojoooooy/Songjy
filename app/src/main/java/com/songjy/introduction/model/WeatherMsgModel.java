package com.songjy.introduction.model;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.songjy.introduction.App;
import com.songjy.introduction.common.C;
import com.songjy.introduction.entity.weather.WeatherEntity;
import com.songjy.introduction.listener.OnWeatherRequestListener;

/**
 * Created by songjiyuan
 * on 17/10/20 # 上午11:23.
 */

public class WeatherMsgModel {

    private OnWeatherRequestListener listener;

    public WeatherMsgModel(OnWeatherRequestListener listener) {
        this.listener = listener;
    }

    public void getWeatherMsg() {
        StringBuilder url = new StringBuilder();
        url.append(C.URL_WEATHER);
        url.append("?city=");
        url.append(C.WEATHER_LOCATION);
        url.append("&key=");
        url.append(C.WEATHER_KEY);
        App.getRequestQueue().add(new StringRequest(
                Request.Method.GET, url.toString(),
                response -> {
                    if (TextUtils.isEmpty(response)) {
                        return;
                    }
                    Gson gson = new Gson();
                    WeatherEntity entity = gson.fromJson(response, WeatherEntity.class);
                    listener.onSuccess(entity);
                }, error -> listener.onFail()));
    }
}
