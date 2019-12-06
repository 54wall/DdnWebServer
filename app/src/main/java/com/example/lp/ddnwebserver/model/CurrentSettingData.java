package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;

import com.example.lp.ddnwebserver.Config;

/**
 * 当前设置信息
 * */
public class CurrentSettingData {
    @JSONField(name =Config.DEVICE_NO)
    private String device_no;

    @JSONField(name =Config.VERSION_NAME)
    private String version_name;

    @JSONField(name =Config.WIFI_NAME)
    private String wifi_name;

    @JSONField(name =Config.WIFI_PASSWD)
    private String wifi_passwd;

    @JSONField(name =Config.SYSTEM_VOICE)
    private String system_voice;

    @JSONField(name =Config.ERROR_VOICE)
    private String error_voice;

    @JSONField(name =Config.NORMAL_VOICE)
    private String normal_voice;

    @JSONField(name =Config.VOICE_SPEED)
    private String voice_speed;

    @JSONField(name =Config.TEMPERATURE_THRESHOLD)
    private String temperature_threshold;

    @JSONField(name =Config.DISTANCE)
    private String distance;

    @JSONField(name =Config.FFC_COMPENSATION_PARAMETER)
    private String FFC_compensation_parameter;

    @JSONField(name =Config.CAMERA_EXPLORE)
    private String camera_explore;

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public String getWifi_name() {
        return wifi_name;
    }

    public void setWifi_name(String wifi_name) {
        this.wifi_name = wifi_name;
    }

    public String getWifi_passwd() {
        return wifi_passwd;
    }

    public void setWifi_passwd(String wifi_passwd) {
        this.wifi_passwd = wifi_passwd;
    }

    public String getSystem_voice() {
        return system_voice;
    }

    public void setSystem_voice(String system_voice) {
        this.system_voice = system_voice;
    }

    public String getError_voice() {
        return error_voice;
    }

    public void setError_voice(String error_voice) {
        this.error_voice = error_voice;
    }

    public String getNormal_voice() {
        return normal_voice;
    }

    public void setNormal_voice(String normal_voice) {
        this.normal_voice = normal_voice;
    }

    public String getVoice_speed() {
        return voice_speed;
    }

    public void setVoice_speed(String voice_speed) {
        this.voice_speed = voice_speed;
    }

    public String getTemperature_threshold() {
        return temperature_threshold;
    }

    public void setTemperature_threshold(String temperature_threshold) {
        this.temperature_threshold = temperature_threshold;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFFC_compensation_parameter() {
        return FFC_compensation_parameter;
    }

    public void setFFC_compensation_parameter(String FFC_compensation_parameter) {
        this.FFC_compensation_parameter = FFC_compensation_parameter;
    }

    public String getCamera_explore() {
        return camera_explore;
    }

    public void setCamera_explore(String camera_explore) {
        this.camera_explore = camera_explore;
    }

    @Override
    public String toString() {
        return "CurrentSettingData{" +
                "device_no='" + device_no + '\'' +
                ", version_name='" + version_name + '\'' +
                ", wifi_name='" + wifi_name + '\'' +
                ", wifi_passwd='" + wifi_passwd + '\'' +
                ", system_voice='" + system_voice + '\'' +
                ", error_voice='" + error_voice + '\'' +
                ", normal_voice='" + normal_voice + '\'' +
                ", voice_speed='" + voice_speed + '\'' +
                ", temperature_threshold='" + temperature_threshold + '\'' +
                ", distance='" + distance + '\'' +
                ", FFC_compensation_parameter='" + FFC_compensation_parameter + '\'' +
                ", camera_explore='" + camera_explore + '\'' +
                '}';
    }
}
