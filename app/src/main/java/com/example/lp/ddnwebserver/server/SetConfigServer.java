package com.example.lp.ddnwebserver.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.example.lp.ddnwebserver.MyApplication;
import com.example.lp.ddnwebserver.model.VoiceData;
import com.example.lp.ddnwebserver.model.WifiData;
import com.example.lp.ddnwebserver.service.BindServiceTest;

import static android.content.Context.BIND_AUTO_CREATE;

/***
 * 设置参数到本机
 * */
public class SetConfigServer {

    private static final String TAG="SetConfigServer";
    private  BindServiceTest.Mybinder myBinder;

    private Context context=MyApplication.getInstance();


    private static class InnerClass{
        private static SetConfigServer setConfigServer=new SetConfigServer();
    }
    private SetConfigServer(){
        context.bindService(new Intent(context, BindServiceTest.class),connection,BIND_AUTO_CREATE);
    }
    /*静态内部类单例*/
    public static SetConfigServer getInstance(){
        return InnerClass.setConfigServer;
    }
    /**
     * 设置wifi信息到本机
     * */
    public void setWifiData(WifiData wifiData) {
        /*SP操作，存入本地*/
        /*启动wifi服务，发送*/
      myBinder.getBinderInfo();
      myBinder.setBinderInfo(wifiData);
    }

    ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder= (BindServiceTest.Mybinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };



    public void setVoiceData(VoiceData voiceData) {
        Log.i(TAG, "setVoiceData: ");voiceData.toString();
        /*存入SP*/
        /*直接修改Tts配置*/

    }



}
