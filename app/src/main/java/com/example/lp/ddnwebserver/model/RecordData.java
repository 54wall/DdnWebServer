package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

/**
 * 记录数据
 * */
public class RecordData {
    @JSONField(name = Config.PERSONRECODPATH)
    private String personPath;
    @JSONField(name = Config.TEMPERRECODPATH)
    private String temperPath;
    @JSONField(name = Config.DATA)
    private String data;
    @JSONField(name = Config.TEMP)
    private String temp;

    public String getPersonPath() {
        return personPath;
    }

    public void setPersonPath(String personPath) {
        this.personPath = personPath;
    }

    public String getTemperPath() {
        return temperPath;
    }

    public void setTemperPath(String temperPath) {
        this.temperPath = temperPath;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "RecordData{" +
                "personPath='" + personPath + '\'' +
                ", temperPath='" + temperPath + '\'' +
                ", data='" + data + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }
}
