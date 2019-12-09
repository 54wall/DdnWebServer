package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

import java.util.Date;

/**
 * 条件查询请求数据
 * */
public class RecordQueryRequest {

    //当前多少页
    @JSONField(name = Config.CURRENTPAGE)
    private int currentpage;

    //每页多少条
    @JSONField(name = Config.EVERPAGENUMBER)
    private int everPageNumber;

    //过滤条件
    @JSONField(name = Config.STARTIME)
    private Date starTime;
    @JSONField(name = Config.ENDTIME)
    private Date endTime;
    @JSONField(name = Config.MINTEMP)
    private String minTemp;
    @JSONField(name = Config.MATEMP)
    private String maxTemp;

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getEverPageNumber() {
        return everPageNumber;
    }

    public void setEverPageNumber(int everPageNumber) {
        this.everPageNumber = everPageNumber;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

}
