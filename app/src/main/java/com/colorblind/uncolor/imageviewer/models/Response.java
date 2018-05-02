package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uncolor on 01.05.2018.
 */

public class Response {

    @Nullable
    @SerializedName("count")
    private long count;

    @Nullable
    @SerializedName("items")
    private ImageItem[] imageItems;

    public long getCount() {
        return count;
    }

    public ImageItem[] getImageItems() {
        return imageItems;
    }
}
