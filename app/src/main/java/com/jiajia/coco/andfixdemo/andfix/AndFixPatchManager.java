package com.jiajia.coco.andfixdemo.andfix;

import android.annotation.SuppressLint;
import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.jiajia.coco.andfixdemo.util.TLog;
import com.jiajia.coco.andfixdemo.util.Utils;

/**
 * @author Create by Jerry
 * @date on 2019-05-25
 * @description 管理AndFix所有的api
 */
public class AndFixPatchManager {

    private static AndFixPatchManager mInstance = null;

    @SuppressLint("StaticFieldLeak")
    private static PatchManager mPatchManager = null;

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }

    //初始化AndFix方法
    public void initPatch(Context context) {
        mPatchManager = new PatchManager(context);
        mPatchManager.init(Utils.getVersionName(context));
        mPatchManager.loadPatch();
    }

    //加载我们的patch文件
    public void addPatch(String path) {
        TLog.i(path);
        try {
            if (mPatchManager != null) {
                mPatchManager.addPatch(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
