package com.jiajia.coco.andfixdemo.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/**
 * @author Create by Jerry
 * @date on 2019-05-25
 * @description
 */
public class Utils {
    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public static void printLog() {
        //TODO 异常信息修复位置
        String message = null;
        Log.e("TAG","error");
    }
}
