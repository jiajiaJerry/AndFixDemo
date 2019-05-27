package com.jiajia.coco.andfixdemo.andfix;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import java.io.File;

/**
 * @author Create by Jerry
 * @date on 2019-05-27
 * @description 1.检查patch文件 2.下载patch文件 3.加载下载好的patch文件
 */
public class AndFixService extends Service {
    private static final int UPDATE_PATCH = 0x02;
    private static final int DOWNLOAD_PATCH = 0x01;
    private static final String FILE_END = ".apatch";
    private String  mPathFileDir;
    private String mPathFile;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:{
                    checkPatchUpdate();
                    break;
                }
                case DOWNLOAD_PATCH:{
                    downloadPatch();
                    break;
                }
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }

    //文件目录的构造
    private void init() {
        mPathFileDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        File patchDir = new File(mPathFileDir);
        try {
            if (patchDir == null || !patchDir.exists()) {
                patchDir.mkdir();
            }
        } catch (Exception e) {
            stopSelf();
        }
    }

    //检查服务器是否有patch文件
    private void checkPatchUpdate() {
        //TODO 网络请求
        //请求结果
//        if (有文件){
//            //下载patch文件
//            mHandler.sendEmptyMessage(DOWNLOAD_PATCH);
//        }else{
//            stopSelf();
//        }
    }

    private void downloadPatch() {
        mPathFile = mPathFileDir.concat(String.valueOf(System.currentTimeMillis())).concat(FILE_END);
        //TODO 网络请求
        //将下载好的文件添加到andfix
        AndFixPatchManager.getInstance().addPatch(mPathFile);
    }
}
