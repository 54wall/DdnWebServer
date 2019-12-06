package com.example.lp.ddnwebserver;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.example.lp.ddnwebserver.server.SetConfigServer;
import com.example.lp.ddnwebserver.util.FileUtils;
import com.yanzhenjie.andserver.util.IOUtils;

import java.io.File;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    private File mRootDir;

    @Override
    public void onCreate() {
        super.onCreate();

        if (mInstance == null) {
            mInstance = this;
            initRootPath(this);
        }
        //提前绑定服务，避免使用时才绑定崩溃
        SetConfigServer.getInstance();
    }

    @NonNull
    public static MyApplication getInstance() {
        return mInstance;
    }

    @NonNull
    public File getRootDir() {
        return mRootDir;
    }

    private void initRootPath(Context context) {
        if (mRootDir != null) {
            return;
        }
        if (FileUtils.storageAvailable()) {
            mRootDir = Environment.getExternalStorageDirectory();
        } else {
            mRootDir = context.getFilesDir();
        }
        mRootDir = new File(mRootDir, "AndServer");
        IOUtils.createFolder(mRootDir);
    }
}
