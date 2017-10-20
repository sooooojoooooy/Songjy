package com.songjy.introduction.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.songjy.introduction.R;
import com.songjy.introduction.adapter.WeatherAdapter;
import com.songjy.introduction.entity.weather.HeWeather5Bean;
import com.songjy.introduction.entity.weather.WeatherEntity;
import com.songjy.introduction.listener.OnWeatherRequestListener;
import com.songjy.introduction.model.WeatherMsgModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;

/**
 * Created by songjiyuan
 * on 17/10/19 # 下午4:40.
 */

public class WeatherFragment extends BaseFragment implements
        OnWeatherRequestListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout swiprefresh;
    @BindView(R.id.llay_error)
    LinearLayout llayError;
    private WeatherAdapter mAdapter;
    private List<HeWeather5Bean> weatherData;
    private WeatherMsgModel model;


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        model = new WeatherMsgModel(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        swiprefresh.setOnRefreshListener(this);
        loadData();
    }

    private void loadData() {
        Observable.just(getContext())
                .doOnNext(context -> swiprefresh.setRefreshing(true))
                .doOnNext(context -> model.getWeatherMsg())
                .subscribe();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void onSuccess(WeatherEntity req) {
        weatherData = new ArrayList<>();
        weatherData.clear();
        weatherData.addAll(req.getHeWeather5());
        mAdapter = new WeatherAdapter(weatherData);
        recyclerview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        swiprefresh.setRefreshing(false);
        recyclerview.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFail() {
        swiprefresh.setRefreshing(false);
        recyclerview.setVisibility(View.GONE);
        llayError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRefresh() {
        loadData();
    }

    @OnClick(R.id.llay_error)
    public void onViewClicked() {
        loadData();
        llayError.setVisibility(View.GONE);
    }
}
