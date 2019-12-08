package com.example.lp.ddnwebserver.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

/**
 * 校准定位数据
 * 人脸定位框和温度摄像头定位框的偏移值
 * */
public class CalibratPositionData {
    @JSONField(name = Config.MOVEX)
    private String moveX;
    @JSONField(name = Config.MOVEY)
    private String moveY;
    @JSONField(name = Config.SCALE)
    private float scale;

    public String getMoveX() {
        return moveX;
    }

    public void setMoveX(String moveX) {
        this.moveX = moveX;
    }

    public String getMoveY() {
        return moveY;
    }

    public void setMoveY(String moveY) {
        this.moveY = moveY;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "CalibratPositionData{" +
                "moveX='" + moveX + '\'' +
                ", moveY='" + moveY + '\'' +
                ", scale=" + scale +
                '}';
    }
}
