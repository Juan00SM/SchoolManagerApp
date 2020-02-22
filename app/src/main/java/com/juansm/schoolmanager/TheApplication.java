package com.juansm.schoolmanager;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class TheApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
