package com;

import android.app.Application;

/**
 * Created by lixinlin on 2018/1/18.
 */

public class MyApplication extends Application {
    private static Application mApplication ;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static Application getmApplication() {
        return mApplication;
    }
}
