package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by uncolor on 01.05.2018.
 */

public class Response extends RealmObject{

    @SerializedName("count")
    private long count;

    @Nullable
    @SerializedName("items")
    private RealmList<ImageItem> imageItems;

    public Response() {
    }

    public long getCount() {
        return count;
    }

    public List<ImageItem> getImageItems() {
        return imageItems;
    }
}
