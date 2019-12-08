package com.example.lp.ddnwebserver.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.example.lp.ddnwebserver.Config;

import java.util.List;

/**
 * 图片记录的数据
 * */
public class PhotoRecordData {

    @JSONField(name = Config.RECORDDATALIST)
    private List<RecordData> recordDataList;

    //所有数据个数
    @JSONField(name = Config.ALLDATANUMBER)
    private int allDataNumber;

    public List<RecordData> getRecordDataList() {
        return recordDataList;
    }

    public void setRecordDataList(List<RecordData> recordDataList) {
        this.recordDataList = recordDataList;
    }

    public int getAllDataNumber() {
        return allDataNumber;
    }

    public void setAllDataNumber(int allDataNumber) {
        this.allDataNumber = allDataNumber;
    }

    @Override
    public String toString() {
        return "PhotoRecordData{" +
                "recordDataList=" + recordDataList +
                ", allDataNumber=" + allDataNumber +
                '}';
    }
}
