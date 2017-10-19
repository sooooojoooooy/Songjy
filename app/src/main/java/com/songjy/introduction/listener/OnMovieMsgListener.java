package com.songjy.introduction.listener;

import com.songjy.introduction.entity.douban.DbMovieEntity;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午4:16.
 */

public interface OnMovieMsgListener {
    void onSuccess(DbMovieEntity rqs);

    void onFail();
}
