package com.example.lp.ddnwebserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.lp.ddnwebserver.model.WifiData;

/**
 * 测试BindService
 * */
public class BindServiceTest extends Service {
    private static final String TAG="BindServiceTest";
    public static Boolean isAlive=false;

    public BindServiceTest() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        isAlive=true;
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
       
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e(TAG, "onBind: ");
      return new Mybinder();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isAlive=false;
        Log.e(TAG, "onDestroy: " );
    }

    public class Mybinder extends Binder{
        public String getBinderInfo(){
            Log.i(TAG, "getBinderInfo: ");
            return BindServiceTest.class.getName();
        }
        public void setBinderInfo(WifiData wifiData){
            Log.i(TAG, "setBinderInfo: ");
            wifiData.getWifiName();
        }

    }

}
