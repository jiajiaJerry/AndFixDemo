package com.jiajia.coco.andfixdemo.application;

import android.app.Application;

import com.jiajia.coco.andfixdemo.andfix.AndFixPatchManager;

/**
 * @author Create by Jerry
 * @date on 2019-05-25
 * @description
 */
public class AndFixApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //完成andFix模块的初始化
        initAndFix();
    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }
}
