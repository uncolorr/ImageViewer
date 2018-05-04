package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.custom_views.TouchImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Uncolor on 02.05.2018.
 */

@EFragment(R.layout.fragment_image)
public class ImageFragment extends Fragment {

    public static final String ARG_IMAGE_URL = "imageUrl";
    @ViewById
    TouchImageView imageView;

    private String imageUrl;

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        this.imageUrl = args.getString(ARG_IMAGE_URL);

    }

    @AfterViews
    void init(){
        Glide
                .with(this)
                .load(imageUrl)
                .into(imageView);
    }

}
