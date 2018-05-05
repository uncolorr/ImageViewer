package com.colorblind.uncolor.imageviewer.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ImageItem extends RealmObject implements Parcelable{

    @SerializedName("id")
    private long id;

    @SerializedName("album_id")
    private long albumId;

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

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @Nullable
    @SerializedName("text")
    private String text;

    @SerializedName("date")
    private long date;

    public ImageItem(){

    }

    protected ImageItem(Parcel in) {
        id = in.readLong();
        albumId = in.readLong();
        ownerId = in.readLong();
        photo75 = in.readString();
        photo130 = in.readString();
        photo604 = in.readString();
        width = in.readInt();
        height = in.readInt();
        text = in.readString();
        date = in.readLong();
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel in) {
            return new ImageItem(in);
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeLong(albumId);
        parcel.writeLong(ownerId);
        parcel.writeString(photo75);
        parcel.writeString(photo130);
        parcel.writeString(photo604);
        parcel.writeInt(width);
        parcel.writeInt(height);
        parcel.writeString(text);
        parcel.writeLong(date);
    }
}

