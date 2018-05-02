package com.colorblind.uncolor.imageviewer.images_activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.custom_views.SquareImageView;
import com.colorblind.uncolor.imageviewer.image_slider_activity.SwipeImagesActivity;
import com.colorblind.uncolor.imageviewer.models.ImageItem;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private SquareImageView imageView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
    }

    public void bind(ImageItem imageItem){
        //...
        setOnClickListener(imageItem);
        Glide
                .with(itemView.getContext())
                .load(imageItem.getPhoto604())
                .into(imageView);

    }

    private void setOnClickListener(ImageItem imageItem){
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity(SwipeImagesActivity.newInstance(itemView.getContext(), 5));
            }
        });
    }
}
