package com.songjy.introduction.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.songjy.introduction.R;
import com.songjy.introduction.common.C;

import butterknife.BindView;
import io.reactivex.Observable;

public class MapActivity extends BaseActivity implements BDLocationListener {

    @BindView(R.id.bmapView)
    MapView bmapView;
    private BaiduMap mBaiduMap;
    private boolean isFirstLoc = true;
    LocationClient mLocClient;

    @Override
    public void initParams(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_map;
    }

    @Override
    public void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // 设置百度地图
        mBaiduMap = bmapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);// 设置地图模式
        mBaiduMap.setMyLocationEnabled(true);
    }

    @Override
    public void doBusiness(Context mContext) {
        mLocClient = new LocationClient(mContext);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(C.isGPS); // 打开gps
        option.setCoorType(C.BD_COOR_TYPE); // 设置坐标类型
        option.setScanSpan(C.BD_SCAN_SPAN);// 定位间隔时间
        mLocClient.setLocOption(option);
        mLocClient.registerLocationListener(this);
        mLocClient.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLocClient != null)
            mLocClient.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mLocClient != null)
            mLocClient.restart();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onReceiveLocation(BDLocation location) {
        Observable.just(location)
                .filter(bdLocation -> bdLocation != null && bmapView != null)
                .doOnNext(bdLocation -> {
                    mBaiduMap.clear();
                    MyLocationData locData = new MyLocationData.Builder()
                            .accuracy(bdLocation.getRadius())
                            .direction(100)// 此处设置开发者获取到的方向信息，顺时针0-360
                            .latitude(bdLocation.getLatitude())
                            .longitude(bdLocation.getLongitude())
                            .build();
                    mBaiduMap.setMyLocationData(locData);
                })
                .filter(bdLocation -> isFirstLoc)
                .doOnNext(bdLocation -> {
                    isFirstLoc = false;
                    LatLng ll = new LatLng(location.getLatitude(),
                            location.getLongitude());
                    MapStatus.Builder builder = new MapStatus.Builder();
                    builder.target(ll).zoom(C.BD_ZOOM);
                    mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
                });
    }
}
