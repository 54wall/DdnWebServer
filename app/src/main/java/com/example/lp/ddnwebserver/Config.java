package com.example.lp.ddnwebserver;

public interface Config {

    /***
     * 字段的命名
     * */
    String DEVICE_NO="device_no";
    String VERSION_NAME="version_name";
    String WIFI_NAME="wifi_name";
    String WIFI_PASSWD="wifi_passwd";
    String SYSTEM_VOICE="system_voice";
    String ERROR_VOICE="error_voice";
    String NORMAL_VOICE ="normal_voice";
    String VOICE_SPEED="voice_speed";
    String TEMPERATURE_THRESHOLD="temperature_threshold";
    String DISTANCE="distance";
    String FFC_COMPENSATION_PARAMETER="ffc_compensation_parameter";
    String FFC_CALIBRATION_PARAMETER="ffc_calibration_parameter";
    String CAMERA_EXPLORE="camera_explore";



    //api路径
    //设置wifi
    String setWifiRequestPath="/set/wifi";
    //设置语音
    String setVoiceRequestPath="/set/voice";
    //设置温度阀值
    String setTemperatureRequestPath="/set/temperature";
    //设置摄像头曝光
    String setExploreRequestPath="/set/camera_explore";
    //设置FFC补偿
    String setFFCCompensationRequestPath="/set/FFC_compensation";
    //设置黑体校准参数
    String setBlackCalibrationnRequestPath="/set/FFC_black_calibrationn";
    //设置平均温度校准
    String setAvgCalibrationnRequestPath="/set/FFC_avg_calibrationn";
    //设置距离
    String setDistanceRequestPath= "/set/temper_distance";



}
