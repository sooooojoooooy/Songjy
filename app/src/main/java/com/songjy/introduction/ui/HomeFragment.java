package com.songjy.introduction.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.songjy.introduction.R;
import com.songjy.introduction.service.MyService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import butterknife.Bind;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment implements ServiceConnection {

    @Bind(R.id.btn_bind_service)
    Button btnBindService;
    @Bind(R.id.btn_unbind_service)
    Button btnUnbindService;
    @Bind(R.id.btn_start_service)
    Button btnStartService;
    @Bind(R.id.btn_stop_service)
    Button btnStopService;
    MyService.MyBinder myBinder;

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @OnClick({R.id.btn_bind_service, R.id.btn_unbind_service, R.id.btn_start_service, R.id.btn_stop_service})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_bind_service:
                showSnackbar(view, "绑定Service");
                intent = new Intent(getContext(), MyService.class);
                getContext().bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                showSnackbar(view, "解绑Service");
                getContext().unbindService(this);
                break;
            case R.id.btn_start_service:
                showSnackbar(view, "开启Service");
                intent = new Intent(getContext(), MyService.class);
                getContext().startService(intent);
                break;
            case R.id.btn_stop_service:
//                showSnackbar(view, "关闭Service");
//                intent = new Intent(getContext(), MyService.class);
//                getContext().stopService(intent);
                myBinder.stopWork();
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myBinder = (MyService.MyBinder) iBinder;
        myBinder.startWork();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        myBinder.stopWork();
    }

    @Override
    public void onBindingDied(ComponentName name) {

    }
}
