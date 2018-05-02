package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Uncolor on 02.05.2018.
 */

public class ImagePagerAdapter extends FragmentPagerAdapter {

    private int count = 0;

    public ImagePagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment_.builder().build();
    }

    @Override
    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }
}
