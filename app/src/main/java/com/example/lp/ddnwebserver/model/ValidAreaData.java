package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

/**
 * 有效区域数据
 * */
public class ValidAreaData {
    @JSONField(name = Config.LINEUP)
    private String lineUp;

    @JSONField(name = Config.LINELEFT)
    private String lineLeft;

    @JSONField(name = Config.LINEDWON)
    private String lineDown;

    @JSONField(name = Config.LINERIGHT)
    private String lineRight;

    public String getLineUp() {
        return lineUp;
    }

    public void setLineUp(String lineUp) {
        this.lineUp = lineUp;
    }

    public String getLineLeft() {
        return lineLeft;
    }

    public void setLineLeft(String lineLeft) {
        this.lineLeft = lineLeft;
    }

    public String getLineDown() {
        return lineDown;
    }

    public void setLineDown(String lineDown) {
        this.lineDown = lineDown;
    }

    public String getLineRight() {
        return lineRight;
    }

    public void setLineRight(String lineRight) {
        this.lineRight = lineRight;
    }

    @Override
    public String toString() {
        return "ValidAreaData{" +
                "lineUp='" + lineUp + '\'' +
                ", lineLeft='" + lineLeft + '\'' +
                ", lineDown='" + lineDown + '\'' +
                ", lineRight='" + lineRight + '\'' +
                '}';
    }
}
