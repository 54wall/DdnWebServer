package com.example.lp.ddnwebserver.component;

import android.os.Environment;
import android.util.Log;

import com.yanzhenjie.andserver.annotation.Website;
import com.yanzhenjie.andserver.framework.website.FileBrowser;

/**
 * 指定目录作为本地存储文件夹
 * */
@Website
public class SimpleBrowser extends FileBrowser {
    public SimpleBrowser() {
        super(Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.e("PATH", Environment.getExternalStorageDirectory().getAbsolutePath());
    }
}