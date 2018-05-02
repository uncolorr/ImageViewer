package com.colorblind.uncolor.imageviewer.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.colorblind.uncolor.imageviewer.api.Api;

/**
 * Created by uncolor on 01.05.2018.
 */

public class App extends Application {


    public static final String APP_PREFERENCES_USER = "user_pref";
    public static final String APP_SETTINGS = "app_settings";
    private static SharedPreferences settings;

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Api.init();
        instance = this;
        settings = getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    public static void Log(String message){
        Log.i("fg", message);
    }

}
