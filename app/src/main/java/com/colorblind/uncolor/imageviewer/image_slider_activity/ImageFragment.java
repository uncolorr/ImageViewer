package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.support.v4.app.Fragment;

import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.custom_views.TouchImageView;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Uncolor on 02.05.2018.
 */

@EFragment(R.layout.fragment_image)
public class ImageFragment extends Fragment {

    @ViewById
    TouchImageView imageView;

}
