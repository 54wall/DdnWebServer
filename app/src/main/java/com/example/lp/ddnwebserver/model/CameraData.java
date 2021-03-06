package com.example.lp.ddnwebserver.model;

import com.alibaba.fastjson.annotation.JSONField;

import static com.example.lp.ddnwebserver.Config.CAMERA_EXPLORE;

/**
 * 摄像头信息
 * 曝光值
 * */
public class CameraData {
    @JSONField(name = CAMERA_EXPLORE)
    private String explorer;

    public String getExplorer() {
        return explorer;
    }

    public void setExplorer(String explorer) {
        this.explorer = explorer;
    }

    @Override
    public String toString() {
        return "CameraData{" +
                "explorer='" + explorer + '\'' +
                '}';
    }
}
