package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

public class WifiData {


    @JSONField(name = Config.WIFI_NAME)
    private String wifi_name;

    @JSONField(name =Config.WIFI_PASSWD)
    private String wifi_passwd;

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

    @Override
    public String toString() {
        return "WifiData{" +
                "wifi_name='" + wifi_name + '\'' +
                ", wifi_passwd='" + wifi_passwd + '\'' +
                '}';
    }
}

