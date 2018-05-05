package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by uncolor on 02.05.2018.
 */

public class RequestParameter extends RealmObject{

    @Nullable
    @SerializedName("key")
    private String key;

    @Nullable
    @SerializedName("value")
    private String value;

    @Nullable
    public String getKey() {
        return key;
    }

    @Nullable
    public String getValue() {
        return value;
    }
}
