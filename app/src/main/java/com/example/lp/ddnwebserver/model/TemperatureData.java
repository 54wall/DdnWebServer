package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;

import static com.example.lp.ddnwebserver.Config.TEMPERATURE_THRESHOLD;

/**
 * 温度信息
 * */
public class TemperatureData {
    @JSONField(name =TEMPERATURE_THRESHOLD)
    private String Temperature;

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    @Override
    public String toString() {
        return "TemperatureData{" +
                "Temperature='" + Temperature + '\'' +
                '}';
    }
}
