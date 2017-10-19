package com.songjy.introduction.model;

import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.songjy.introduction.App;
import com.songjy.introduction.common.C;
import com.songjy.introduction.entity.douban.DbMovieEntity;
import com.songjy.introduction.listener.OnMovieMsgListener;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午4:27.
 */

public class MovieMsgModel {
    private OnMovieMsgListener listener;

    public MovieMsgModel(OnMovieMsgListener movieMsgListener) {
        listener = movieMsgListener;
    }

    public void getT250MovieMsg(int start, int count) {
        StringBuilder url = new StringBuilder();
        url.append(C.URL_DOUBAN);
        url.append("?start=");
        url.append(start);
        url.append("&count=");
        url.append(count);
        App.getRequestQueue().add(new StringRequest(
                Request.Method.GET, url.toString(),
                response -> {
                    if (TextUtils.isEmpty(response)) {
                        return;
                    }
                    Gson gson = new Gson();
                    DbMovieEntity entity = gson.fromJson(response, DbMovieEntity.class);
                    listener.onSuccess(entity);
                }, error -> listener.onFail()));
    }
}
