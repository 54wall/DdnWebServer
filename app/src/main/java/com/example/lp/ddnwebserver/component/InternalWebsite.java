package com.example.lp.ddnwebserver.component;

import com.yanzhenjie.andserver.annotation.Website;
import com.yanzhenjie.andserver.framework.website.StorageWebsite;

/**使用存储在Sd存储卡上的html目录
 * 优先级
 * 高于WebConfig中addwebsite
 * 需要使用的时候必须加上@Website
 * @Website
 * */
public class InternalWebsite extends StorageWebsite {

    public InternalWebsite() {
        super("/sdcard/web","index.html");
    }
}