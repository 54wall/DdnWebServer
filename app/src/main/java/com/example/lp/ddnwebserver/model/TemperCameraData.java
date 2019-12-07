package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

/**
 * 温度摄像头参数
 * */
public class TemperCameraData {
    @JSONField(name = Config.DISTANCE)
    private String distance;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "TemperCameraData{" +
                "distance='" + distance + '\'' +
                '}';
    }
}
