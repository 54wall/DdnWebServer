package com.example.lp.ddnwebserver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="MainActivity";

    private ServerManager mServerManager;

    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnBrowser;
    private TextView mTvMessage;


    private String mRootUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = findViewById(R.id.btn_start);
        mBtnStop = findViewById(R.id.btn_stop);
        mBtnBrowser = findViewById(R.id.btn_browse);
        mTvMessage = findViewById(R.id.tv_message);

        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mBtnBrowser.setOnClickListener(this);

        // AndServer run in the service.
        mServerManager = new ServerManager(this);
        mServerManager.register();

        // startServer;
        mBtnStart.performClick();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mServerManager.unRegister();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_start: {
                Log.i(TAG, "onClick: ");
                mServerManager.startServer();
                break;
            }
            case R.id.btn_stop: {
                mServerManager.stopServer();
                break;
            }
            case R.id.btn_browse: {
                if (!TextUtils.isEmpty(mRootUrl)) {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(mRootUrl));
                    startActivity(intent);
                }
                break;
            }
            default:
                break;
        }
    }

    /**
     * Start notify.
     */
    public void onServerStart(String ip) {

        mBtnStart.setVisibility(View.GONE);
        mBtnStop.setVisibility(View.VISIBLE);
        mBtnBrowser.setVisibility(View.VISIBLE);

        if (!TextUtils.isEmpty(ip)) {
            List<String> addressList = new LinkedList<>();
            mRootUrl = "http://" + ip + ":8080/";
            addressList.add(mRootUrl);
            addressList.add("http://" + ip + ":8080/login.html");
            mTvMessage.setText(TextUtils.join("\n", addressList));
        } else {
            mRootUrl = null;
            mTvMessage.setText(R.string.server_ip_error);
        }
    }

    /**
     * Error notify.
     */
    public void onServerError(String message) {

        mRootUrl = null;
        mBtnStart.setVisibility(View.VISIBLE);
        mBtnStop.setVisibility(View.GONE);
        mBtnBrowser.setVisibility(View.GONE);
        mTvMessage.setText(message);
    }

    /**
     * Stop notify.
     */
    public void onServerStop() {

        mRootUrl = null;
        mBtnStart.setVisibility(View.VISIBLE);
        mBtnStop.setVisibility(View.GONE);
        mBtnBrowser.setVisibility(View.GONE);
        mTvMessage.setText(R.string.server_stop_succeed);
    }


}
