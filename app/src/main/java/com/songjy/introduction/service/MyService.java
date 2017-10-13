package com.songjy.introduction.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.songjy.introduction.common.utils.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {
    private Logger logger;
    protected String TAG = "";
    private MyBinder mBinder = new MyBinder();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss", Locale.CHINA);
    private boolean flag = true;

    public MyService() {
        TAG = sdf.format(new Date());
        logger = new Logger(TAG);
    }

    @Override
    public IBinder onBind(Intent intent) {
        logger.e(TAG + "onBind" + sdf.format(new Date()));
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (flag) {
                    Log.e(TAG + "onStartCommand", sdf.format(new Date()));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.e(TAG + "unbindService", sdf.format(new Date()));
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG + "onDestroy", sdf.format(new Date()));
        flag = false;
    }

    public class MyBinder extends Binder {

        public void startWork() {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    while (flag) {
                        Log.e(TAG + "startWork", sdf.format(new Date()));
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        public void stopWork() {
            Log.e(TAG + "stopWork", sdf.format(new Date()));
        }
    }
}
