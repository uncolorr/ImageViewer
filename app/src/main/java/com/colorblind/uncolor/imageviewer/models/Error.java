package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by uncolor on 02.05.2018.
 */

public class Error extends RealmObject{

    @SerializedName("error_code")
    private int errorCode;

    @Nullable
    @SerializedName("error_msg")
    private String errorMessage;

    @Nullable
    @SerializedName("request_params")
    private RealmList<RequestParameter> requestParams;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<RequestParameter> getRequestParams() {
        return requestParams;
    }
}

