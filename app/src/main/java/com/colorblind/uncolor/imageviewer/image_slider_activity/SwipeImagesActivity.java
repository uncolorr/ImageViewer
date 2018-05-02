package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.colorblind.uncolor.imageviewer.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_swipe_images)
public class SwipeImagesActivity extends AppCompatActivity {

    private static final String ARG_IMAGE_COUNT = "imageCount";

    @ViewById
    ViewPager viewPager;

    private ImagePagerAdapter adapter;

    public static Intent newInstance(Context context, int imagesCount) {
        Intent intent = new Intent(context, SwipeImagesActivity_.class);
        intent.putExtra(ARG_IMAGE_COUNT, imagesCount);
        return intent;
    }

    @AfterViews
    void init(){
        int imageCount = getIntent().getIntExtra(ARG_IMAGE_COUNT, 0);
        adapter = new ImagePagerAdapter(getSupportFragmentManager(), imageCount);
        viewPager.setAdapter(adapter);
    }
}
