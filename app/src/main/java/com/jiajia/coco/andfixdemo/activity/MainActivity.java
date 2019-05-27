package com.jiajia.coco.andfixdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jiajia.coco.andfixdemo.R;
import com.jiajia.coco.andfixdemo.andfix.AndFixPatchManager;
import com.jiajia.coco.andfixdemo.andfix.AndFixService;
import com.jiajia.coco.andfixdemo.util.TLog;
import com.jiajia.coco.andfixdemo.util.Utils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apatch";
    private String mPatchDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 使用示例
        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        //创建文件夹
        File file = new File(mPatchDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        TLog.i(mPatchDir);

        //TODO Service示例
        Intent intent = new Intent(this, AndFixService.class);
        startService(intent);
    }

    //异常事件
    public void createBug(View view) {
        Utils.printLog();
    }

    //修复事件
    public void fixBug(View view) {
        AndFixPatchManager.getInstance().addPatch(getPatchName());
    }

    public String getPatchName() {
        return mPatchDir.concat("andFixNew").concat(FILE_END);
    }
}
