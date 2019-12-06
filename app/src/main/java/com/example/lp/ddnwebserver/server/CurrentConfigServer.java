package com.example.lp.ddnwebserver.server;

import com.example.lp.ddnwebserver.model.CurrentSettingData;
import com.example.lp.ddnwebserver.util.JsonUtils;

public class CurrentConfigServer {

    private static class InnerClass{
        private static CurrentConfigServer currentConfigServer=new CurrentConfigServer();
    }
    private CurrentConfigServer(){

    }
    /*静态内部类单例*/
    public static CurrentConfigServer getInstance(){
        return InnerClass.currentConfigServer;
    }
    private CurrentSettingData currentSettingData;

    private CurrentSettingData initData() {
        currentSettingData =new CurrentSettingData();
        currentSettingData.setDevice_no("deviceno");
        currentSettingData.setWifi_name("wifiname");
        currentSettingData.setWifi_passwd("wifipasswd");
        currentSettingData.setCamera_explore("1");
        currentSettingData.setDistance("10");
        currentSettingData.setError_voice("11");
        currentSettingData.setFFC_compensation_parameter("0.5");
        currentSettingData.setNormal_voice("12");
        currentSettingData.setSystem_voice("15");
        currentSettingData.setTemperature_threshold("30");
        currentSettingData.setVoice_speed("1.0");
        currentSettingData.setVersion_name("1.1.0");
        currentSettingData.toString();
        return currentSettingData;
    }
    public CurrentSettingData getSetting() {
        CurrentSettingData currentSettingData = initData();
        return currentSettingData;
    }
}
