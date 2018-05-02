package com.colorblind.uncolor.imageviewer.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by uncolor on 01.05.2018.
 */

public class Api {

    private static Api api;
    private static ApiSource apiSource;
    private Retrofit retrofit;

    private Api() {
        Gson gson = new GsonBuilder()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create(gson)) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();
        apiSource = retrofit.create(ApiSource.class);

    }

    public static void init() {
        if (api == null) {
            api = new Api();
        }
    }

    public static ApiSource getSource() {
        return apiSource;
    }
}