package com.colorblind.uncolor.imageviewer.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ImageItem {

    @Nullable
    @SerializedName("id")
    private long id;

    @Nullable
    @SerializedName("album_id")
    private long albumId;

    @Nullable
    @SerializedName("owner_id")
    private long ownerId;

    @Nullable
    @SerializedName("photo_75")
    private String photo75;

    @Nullable
    @SerializedName("photo_130")
    private String photo130;

    @Nullable
    @SerializedName("photo_604")
    private String photo604;

    @Nullable
    @SerializedName("width")
    private int width;

    @Nullable
    @SerializedName("height")
    private int height;

    @Nullable
    @SerializedName("text")
    private String text;

    @Nullable
    @SerializedName("date")
    private long date;

    public long getId() {
        return id;
    }

    public long getAlbumId() {
        return albumId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getPhoto75() {
        return photo75;
    }

    public String getPhoto130() {
        return photo130;
    }

    public String getPhoto604() {
        return photo604;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }
}

