package com.baidu.test;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
