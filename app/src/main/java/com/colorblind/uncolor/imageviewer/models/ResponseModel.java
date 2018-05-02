package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ResponseModel {

    @Nullable
    @SerializedName("response")
    private Response response;

    @Nullable
    @SerializedName("error")
    public Error error;

    public Response getResponse() {
        return response;
    }

    @Nullable
    public Error getError() {
        return error;
    }
}
