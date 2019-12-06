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
import com.example.lp.ddnwebserver.model.CurrentSettingData;
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
import com.yanzhenjie.andserver.util.MediaType;

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
    @PostMapping(path = "/set/wifi",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void setWifiConfig(HttpRequest request,HttpResponse response){
        //将请求转换为Json
        JSONObject jsonObject = JsonUtils.request2Json(request);
        Log.i("setWifiConfig", "jsonObject: "+JsonUtils.toJsonString(jsonObject));
        WifiData wifiData = JSON.toJavaObject(jsonObject, WifiData.class);
        SetConfigServer.getInstance().setWifiData(wifiData);

    }

    /**
     * 设置语音信息
     * */
    @PostMapping(path = "/set/voice",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void setVoiceConfig(HttpRequest request,HttpResponse response){
        //将请求转换为Json
        JSONObject jsonObject = JsonUtils.request2Json(request);
        Log.i("setVoiceConfig", "setVoiceConfig: "+JsonUtils.toJsonString(jsonObject));
        VoiceData voiceData = JSON.toJavaObject(jsonObject, VoiceData.class);
        SetConfigServer.getInstance().setVoiceData(voiceData);

    }
}