package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ResponseModel extends RealmObject {

    @Nullable
    @SerializedName("response")
    private Response response;

    @Nullable
    @SerializedName("error")
    private Error error;

    @Nullable
    public Response getResponse() {
        return response;
    }

    @Nullable
    public Error getError() {
        return error;
    }

    public void setResponse(@Nullable Response response) {
        this.response = response;
    }

    public void setError(@Nullable Error error) {
        this.error = error;
    }
}
