package com.example.lp.ddnwebserver.server;

import com.example.lp.ddnwebserver.Config;
import com.example.lp.ddnwebserver.model.CurrentSettingData;
import com.example.lp.ddnwebserver.util.JsonUtils;
import com.example.lp.ddnwebserver.util.PreferencesUtils;

import static com.example.lp.ddnwebserver.Config.CAMERA_EXPLORE;
import static com.example.lp.ddnwebserver.Config.DEVICE_NO;
import static com.example.lp.ddnwebserver.Config.DISTANCE;
import static com.example.lp.ddnwebserver.Config.ERROR_VOICE;
import static com.example.lp.ddnwebserver.Config.FFC_CALIBRATION_PARAMETER;
import static com.example.lp.ddnwebserver.Config.FFC_COMPENSATION_PARAMETER;
import static com.example.lp.ddnwebserver.Config.NORMAL_VOICE;
import static com.example.lp.ddnwebserver.Config.SYSTEM_VOICE;
import static com.example.lp.ddnwebserver.Config.TEMPERATURE_THRESHOLD;
import static com.example.lp.ddnwebserver.Config.VERSION_NAME;
import static com.example.lp.ddnwebserver.Config.VOICE_SPEED;
import static com.example.lp.ddnwebserver.Config.WIFI_NAME;
import static com.example.lp.ddnwebserver.Config.WIFI_PASSWD;

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
        currentSettingData.setDevice_no(PreferencesUtils.getString(DEVICE_NO,"DEVICE_NO"));
        currentSettingData.setWifi_name(PreferencesUtils.getString(WIFI_NAME,"WIFI_NAME"));
        currentSettingData.setWifi_passwd(PreferencesUtils.getString(WIFI_PASSWD,"WIFI_PASSWD"));
        currentSettingData.setCamera_explore(PreferencesUtils.getString(CAMERA_EXPLORE,"CAMERA_EXPLORE"));
        currentSettingData.setDistance(PreferencesUtils.getString(DISTANCE,"2.0"));
        currentSettingData.setError_voice(PreferencesUtils.getString(ERROR_VOICE,"10"));
        currentSettingData.setFFC_compensation_parameter(PreferencesUtils.getString(FFC_COMPENSATION_PARAMETER,"10"));
        currentSettingData.setFFC_calibration_parameter(PreferencesUtils.getString(FFC_CALIBRATION_PARAMETER,"10"));
        currentSettingData.setNormal_voice(PreferencesUtils.getString(NORMAL_VOICE,"10"));
        currentSettingData.setSystem_voice(PreferencesUtils.getString(SYSTEM_VOICE,"15"));
        currentSettingData.setTemperature_threshold(PreferencesUtils.getString(TEMPERATURE_THRESHOLD,"30"));
        currentSettingData.setVoice_speed(PreferencesUtils.getString(VOICE_SPEED,"1.0"));
        currentSettingData.setVersion_name(PreferencesUtils.getString(VERSION_NAME,"1.1.0"));
        currentSettingData.setMovex(PreferencesUtils.getString(Config.MOVEX,"0"));
        currentSettingData.setMovey(PreferencesUtils.getString(Config.MOVEY,"0"));
        currentSettingData.setScale(PreferencesUtils.getFloat(Config.SCALE,1));
        currentSettingData.setLineUp(PreferencesUtils.getString(Config.LINEUP,"20"));
        currentSettingData.setLineLeft(PreferencesUtils.getString(Config.LINELEFT,"20"));
        currentSettingData.setLineDown(PreferencesUtils.getString(Config.LINEDWON,"620"));
        currentSettingData.setLineRight(PreferencesUtils.getString(Config.LINERIGHT,"450"));
        currentSettingData.toString();
        return currentSettingData;
    }
    public CurrentSettingData getSetting() {
        CurrentSettingData currentSettingData = initData();
        return currentSettingData;
    }
}
