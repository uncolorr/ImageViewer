package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.colorblind.uncolor.imageviewer.models.ImageItem;

import java.util.ArrayList;

/**
 * Created by Uncolor on 02.05.2018.
 */

public class ImagePagerAdapter extends FragmentPagerAdapter{

    private ArrayList<ImageItem> images;

    public ImagePagerAdapter(FragmentManager fm, ArrayList<ImageItem> images) {
        super(fm);
        this.images = removeNullableItem(images);
    }

    private ArrayList<ImageItem> removeNullableItem(ArrayList<ImageItem> images){
        images.remove(null);
        return images;
    }

    @Override
    public Fragment getItem(int position) {
        ImageFragment fragment = ImageFragment_.builder().build();
        Bundle args = new Bundle();
        args.putString(ImageFragment.ARG_IMAGE_URL, images.get(position).getPhoto604());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return images.size();
    }

}
