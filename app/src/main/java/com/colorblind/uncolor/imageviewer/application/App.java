package com.colorblind.uncolor.imageviewer.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.colorblind.uncolor.imageviewer.api.Api;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by uncolor on 01.05.2018.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Api.init();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("lastresponse.realm").build();
        Realm.setDefaultConfiguration(config);
        instance = this;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    public static void Log(String message){
        Log.i("fg", message);
    }

}
