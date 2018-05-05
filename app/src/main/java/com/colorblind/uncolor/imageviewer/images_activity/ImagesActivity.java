package com.colorblind.uncolor.imageviewer.images_activity;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.colorblind.uncolor.imageviewer.BuildConfig;
import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.api.Api;
import com.colorblind.uncolor.imageviewer.application.App;
import com.colorblind.uncolor.imageviewer.images_activity.interfaces.OnLoadMoreListener;
import com.colorblind.uncolor.imageviewer.models.ImageItem;
import com.colorblind.uncolor.imageviewer.models.ResponseModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@EActivity(R.layout.activity_images)
public class ImagesActivity extends AppCompatActivity {

    private static final int FEED_COLUMN_COUNT = 2;

    @ViewById
    RecyclerView recyclerViewImages;

    @ViewById
    ProgressBar progressBar;

    @ViewById
    SwipeRefreshLayout swipeRefreshLayout;

    private SearchPhotosRequestData searchPhotosRequestData;

    private ImagesAdapter adapter;

    @AfterViews
    void init(){
        searchPhotosRequestData = new SearchPhotosRequestData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, FEED_COLUMN_COUNT);
        recyclerViewImages.setLayoutManager(gridLayoutManager);
        adapter = new ImagesAdapter(gridLayoutManager, this);
        adapter.setOnLoadMoreListener(getOnLoadMoreListener());
        recyclerViewImages.setAdapter(adapter);
        recyclerViewImages.addOnScrollListener(adapter.getOnScrollMoreListener());
        recyclerViewImages.addItemDecoration(new SpaceItemDecoration(2));
        swipeRefreshLayout.setOnRefreshListener(getOnRefreshListener());
        loadImages(false);
    }

    private OnLoadMoreListener getOnLoadMoreListener() {
        return new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                loadImages(false);
            }
        };
    }

    private SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadImages(true);
            }
        };
    }

    private void loadImages(boolean isRefreshing){
        searchPhotosRequestData.setOffset(adapter.getImagesCount());
        if(isRefreshing){
            searchPhotosRequestData.resetOffset();
        }
        Api.getSource().searchPhotos(
                BuildConfig.ACCESS_TOKEN,
                searchPhotosRequestData.getCount(),
                searchPhotosRequestData.getOffset(),
                searchPhotosRequestData.getVersion())
                .enqueue(getLoadImagesCallback(isRefreshing));
    }

    private void showLastSavedResponse(){
        if(adapter.getImagesCount() == 0) {
            Realm realm = Realm.getDefaultInstance();
            RealmResults<ResponseModel> results = realm.where(ResponseModel.class).findAll();
            if (results.size() != 0) {
                ResponseModel responseModel = results.get(0);
                updateAdapter(responseModel);
            }
        }
    }

    private void updateAdapter(ResponseModel responseModel){
        List<ImageItem> items = responseModel.getResponse().getImageItems();
        adapter.addListToEnd(items);
        adapter.setLoaded();
    }

    private void saveResponse(ResponseModel responseModel){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        clearRealm(realm);
        realm.copyToRealm(responseModel);
        realm.commitTransaction();
    }

    private void clearRealm(Realm realm){
        if(realm != null) {
            RealmResults<ResponseModel> results = realm.where(ResponseModel.class).findAll();
            results.deleteAllFromRealm();
        }
    }

    private Callback<ResponseModel> getLoadImagesCallback(final boolean isRefreshing) {
        return new Callback<ResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<ResponseModel> call,
                                   @NonNull Response<ResponseModel> response) {

                swipeRefreshLayout.setRefreshing(false);
                progressBar.setVisibility(View.INVISIBLE);
                if(response.body().getError() != null){
                    Toast.makeText(
                            ImagesActivity.this,
                            ImagesActivity.this.getString(R.string.msg_images_not_loaded),
                            Toast.LENGTH_LONG)
                            .show();
                    showLastSavedResponse();
                }
                else {
                    if(isRefreshing){
                        adapter.clear();
                    }
                    updateAdapter(response.body());
                    saveResponse(response.body());

                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseModel> call,
                                  @NonNull Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                swipeRefreshLayout.setRefreshing(false);
                App.Log(t.toString());
                App.Log(t.getMessage());
                Toast.makeText(ImagesActivity.this,
                        ImagesActivity.this.getString(R.string.msg_unspecified_error),
                        Toast.LENGTH_LONG)
                        .show();
                showLastSavedResponse();
            }
        };
    }


}
