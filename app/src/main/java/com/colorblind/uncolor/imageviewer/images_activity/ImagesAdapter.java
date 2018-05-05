package com.colorblind.uncolor.imageviewer.images_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.colorblind.uncolor.imageviewer.image_slider_activity.SwipeImagesActivity;
import com.colorblind.uncolor.imageviewer.images_activity.interfaces.OnLoadMoreListener;
import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.application.App;
import com.colorblind.uncolor.imageviewer.models.ImageItem;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by uncolor on 01.05.2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_LOADING = 1;

    private OnLoadMoreListener onLoadMoreListener;
    private boolean loading;
    private int visibleThreshold = 1;
    private int lastVisibleItem, totalItemCount;
    private GridLayoutManager gridLayoutManager;
    private Context context;
    private ArrayList<ImageItem> images = new ArrayList<>();

    public ImagesAdapter(GridLayoutManager gridLayoutManager, Context context) {
        this.gridLayoutManager = gridLayoutManager;
        this.context = context;
    }

    private View.OnClickListener getOnClickListener(final int position){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(SwipeImagesActivity.newInstance(context, images, position));
            }
        };
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case TYPE_ITEM:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,
                        parent, false);
                return new ImageViewHolder(view);
            case TYPE_LOADING:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_item,
                        parent, false);
                return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageViewHolder){
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            imageViewHolder.bind(images.get(position));
            imageViewHolder.setOnClickListener(getOnClickListener(position));
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private void removeLoadingItem(){
        if(this.images.size() != 0 && this.images.get(this.images.size() - 1) == null){
            this.images.remove(this.images.size() - 1);
            notifyItemRemoved(this.images.size() - 1);
        }
    }

    private void addLoadingItem(int imagesSize){
        if(imagesSize != 0) {
            this.images.add(null);
        }
    }

    public void addListToEnd(ImageItem[] images){
        removeLoadingItem();
        this.images.addAll(Arrays.asList(images));
        addLoadingItem(images.length);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(images.get(position) == null){
            return TYPE_LOADING;
        }
        return TYPE_ITEM;
    }

    public void clear(){
        this.images.clear();
        notifyDataSetChanged();
    }

    public int getImagesCount(){
        int counter = 0;
        for (int i = 0; i < images.size(); i++) {
            if(images.get(i) != null){
                counter++;
            }
        }
        return counter;
    }

    public void setLoaded() {
        loading = false;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public RecyclerView.OnScrollListener getOnScrollMoreListener(){
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                App.Log("dx: " + Integer.toString(dx));
                App.Log("dy: " + Integer.toString(dy));

                if (dy > 0) {
                    totalItemCount = gridLayoutManager.getItemCount();
                    lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
                    if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        loading = true;
                    }
                }
            }
        };
    }
}
