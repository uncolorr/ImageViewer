package com.colorblind.uncolor.imageviewer.api;

import com.colorblind.uncolor.imageviewer.models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by uncolor on 01.05.2018.
 */

public interface ApiSource {
    @FormUrlEncoded
    @POST("photos.search")
    Call<ResponseModel> searchPhotos(
            @Field("access_token") String token,
            @Field("count") int count,
            @Field("offset") int offset,
            @Field("v") String version);
}
