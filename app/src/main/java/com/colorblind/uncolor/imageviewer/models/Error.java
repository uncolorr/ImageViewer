package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by uncolor on 02.05.2018.
 */

public class Error {

    @Nullable
    @SerializedName("error_code")
    public int errorCode;

    @Nullable
    @SerializedName("error_msg")
    public String errorMessage;

    @Nullable
    @SerializedName("request_params")
    public List<RequestParameter> requestParams;

    @Nullable
    public int getErrorCode() {
        return errorCode;
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }

    @Nullable
    public List<RequestParameter> getRequestParams() {
        return requestParams;
    }
}

