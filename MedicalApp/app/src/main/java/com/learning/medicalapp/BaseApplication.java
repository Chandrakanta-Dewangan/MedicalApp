package com.learning.medicalapp;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication instance;
    private static final String TAG = BaseApplication.class.getSimpleName();

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
