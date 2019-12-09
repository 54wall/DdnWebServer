package com.example.lp.ddnwebserver;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.lp.ddnwebserver.database.PhotoRecordDb;
import com.example.lp.ddnwebserver.server.SetConfigServer;
import com.example.lp.ddnwebserver.util.FileUtils;
import com.example.lp.ddnwebserver.util.TimeUtils;
import com.yanzhenjie.andserver.util.IOUtils;

import org.litepal.LitePal;

import java.io.File;
import java.util.Random;

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
        LitePal.initialize(this);//初始化LitePal数据库
        //提前绑定服务，避免使用时才绑定崩溃
        SetConfigServer.getInstance();
       // putDataIntoDb();
    }

    //放入测试数据
    private void putDataIntoDb() {
        LitePal.deleteAll(PhotoRecordDb.class);
        for(int i=0;i<100;i++){
            PhotoRecordDb photoRecordDb=new PhotoRecordDb();
            photoRecordDb.setPersonPath(Config.person_path);
            photoRecordDb.setTemperPath(Config.temper_path);
            photoRecordDb.setDate(Long.valueOf(TimeUtils.randomDate("20191001101010",TimeUtils.getYMDHMSDate())));
            Random random=new Random();
            int temp=random.nextInt(20)+20;
            photoRecordDb.setTemp(temp);
            Log.i("放入测试数据", photoRecordDb.toString());
            photoRecordDb.save();
        }
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
