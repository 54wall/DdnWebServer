/*
 * Copyright 2018 Zhenjie Yan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lp.ddnwebserver.controller;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lp.ddnwebserver.Config;
import com.example.lp.ddnwebserver.model.CameraData;
import com.example.lp.ddnwebserver.model.CurrentSettingData;
import com.example.lp.ddnwebserver.model.FFCData;
import com.example.lp.ddnwebserver.model.TemperCameraData;
import com.example.lp.ddnwebserver.model.TemperatureData;
import com.example.lp.ddnwebserver.model.VoiceData;
import com.example.lp.ddnwebserver.model.WifiData;
import com.example.lp.ddnwebserver.server.CurrentConfigServer;
import com.example.lp.ddnwebserver.server.SetConfigServer;
import com.example.lp.ddnwebserver.util.JsonUtils;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestMapping;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.framework.body.StringBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yanzhenjie.andserver.http.RequestBody;
import com.yanzhenjie.andserver.util.MediaType;

import java.io.IOException;
import java.util.Set;

/**
 * 设置界面控制器
 * lp
 * 2019/07/30
 */
@RestController
@RequestMapping(path = "/setting")
public class SettingController {

    /**
     * 默认获取到当前的所有配置信息
     * 要通过MessageConverter自动处理一遍
     */
    @GetMapping(path = "/")
    public CurrentSettingData getSetting() {
        return CurrentConfigServer.getInstance().getSetting();
    }

    /**
     * 手动刷新获取到当前的所有配置信息
     * 直接返回不经过MessageConverter
     */
    @GetMapping(path = "/refresh/setting")
    public void getSetting2(HttpResponse response) {
        CurrentSettingData currentSettingData = CurrentConfigServer.getInstance().getSetting();
        String content = JsonUtils.successfulJson(currentSettingData);
        StringBody body = new StringBody(content);
        response.setBody(body);
    }

    /**
     * 设置wifi信息
     * */
    @PostMapping(path = Config.setWifiRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WifiData setWifiConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setWifiConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WifiData wifiData = JSON.parseObject(content, WifiData.class);
        SetConfigServer.getInstance().setWifiData(wifiData);
        return wifiData;

//HttpRequest request
//        //将请求转换为Json
//        JSONObject jsonObject = JsonUtils.request2Json(request);
//        Log.i("setWifiConfig", "jsonObject: "+JsonUtils.toJsonString(jsonObject));
//        WifiData wifiData = JSON.toJavaObject(jsonObject, WifiData.class);
//        SetConfigServer.getInstance().setWifiData(wifiData);
    }

    /**
     * 设置语音信息
     * */
    @PostMapping(path =Config.setVoiceRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VoiceData setVoiceConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setVoiceConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        VoiceData voiceData = JSON.parseObject(content, VoiceData.class);
        SetConfigServer.getInstance().setVoiceData(voiceData);
        return voiceData;

    }

    /***
    * 设置温度阀值
    * */
    @PostMapping(path = Config.setTemperatureRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TemperatureData setTemperatureConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setTemperatureConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TemperatureData temperatureData = JSON.parseObject(content, TemperatureData.class);
        SetConfigServer.getInstance().setTemperatureData(temperatureData);

        return temperatureData;

    }
    /***
     * 设置曝光参数
     * */
    @PostMapping(path = Config.setExploreRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CameraData setCameraConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setCameraConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CameraData cameraData = JSON.parseObject(content, CameraData.class);
        SetConfigServer.getInstance().setCameraData(cameraData);
        return cameraData;
    }

    /***
     * 设置FFC补偿参数
     * 可为负数
     * */
    @PostMapping(path = Config.setFFCCompensationRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FFCData setFFCcompensationConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setFFCcompensation", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FFCData ffcData = JSON.parseObject(content, FFCData.class);
        SetConfigServer.getInstance().setFFCData(ffcData);
        return ffcData;
    }
    /***
     * 黑体温度校准
     * 值为参考的目标黑体温度
     * */
    @PostMapping(path = Config.setBlackCalibrationnRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FFCData setFFCalibrationConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setFFCalibrationConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FFCData ffcData = JSON.parseObject(content, FFCData.class);
        SetConfigServer.getInstance().setFFCData(ffcData);
        return ffcData;
    }

    /***
     * 平均温度校准
     * */
    @PostMapping(path = Config.setAvgCalibrationnRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public FFCData setFFCavgConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setFFCalibrationConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FFCData ffcData = JSON.parseObject(content, FFCData.class);
        SetConfigServer.getInstance().setFFCData(ffcData);
        //平均温度校准，没有参数传来，因此获得的为空，要给出返回值
        if(ffcData==null){
            ffcData=new FFCData();
        }
        return ffcData;
    }
    /***
     * 设置目标距离
     * */
    @PostMapping(path = Config.setDistanceRequestPath,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TemperCameraData setTempCameraConfig(RequestBody request){
        String content = null;
        try {
            content = request.string();
            Log.i("setFFCalibrationConfig", content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TemperCameraData temperCameraData = JSON.parseObject(content, TemperCameraData.class);
        SetConfigServer.getInstance().setTemperatureCameraData(temperCameraData);
        return temperCameraData;
    }

}