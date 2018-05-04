package com.colorblind.uncolor.imageviewer.image_slider_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.models.ImageItem;
import com.colorblind.uncolor.imageviewer.utils.LabelFormatter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;


@EActivity(R.layout.activity_swipe_images)
public class SwipeImagesActivity extends AppCompatActivity {

    private static final String ARG_POSITION = "position";
    private static final String ARG_IMAGES = "images";

    @ViewById
    ViewPager viewPager;

    private ImagePagerAdapter adapter;

    public static Intent newInstance(Context context, ArrayList<ImageItem> images , int position) {
        Intent intent = new Intent(context, SwipeImagesActivity_.class);
        intent.putExtra(ARG_POSITION, position);
        intent.putParcelableArrayListExtra(ARG_IMAGES, images);
        return intent;
    }

    @AfterViews
    void init(){
        int position = getIntent().getIntExtra(ARG_POSITION, 0);
        ArrayList<ImageItem> images = getIntent().getParcelableArrayListExtra(ARG_IMAGES);
        initViewPager(images, position);
        setTitle(LabelFormatter.getImageSliderCountLabel(position, adapter.getCount()));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initViewPager(ArrayList<ImageItem> images, int position){
        adapter = new ImagePagerAdapter(getSupportFragmentManager(), images);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(getOnPageChangeListener());
    }

    private ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setTitle(LabelFormatter.getImageSliderCountLabel(position, adapter.getCount()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
