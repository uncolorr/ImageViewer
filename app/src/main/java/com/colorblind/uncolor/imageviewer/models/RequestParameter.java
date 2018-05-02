package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uncolor on 02.05.2018.
 */

public class RequestParameter {

    @Nullable
    @SerializedName("key")
    public String key;

    @Nullable
    @SerializedName("value")
    public String value;

    @Nullable
    public String getKey() {
        return key;
    }

    @Nullable
    public String getValue() {
        return value;
    }
}
