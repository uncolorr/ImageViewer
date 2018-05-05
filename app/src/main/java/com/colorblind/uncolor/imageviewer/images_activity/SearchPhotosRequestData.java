package com.colorblind.uncolor.imageviewer.images_activity;

import com.colorblind.uncolor.imageviewer.R;
import com.colorblind.uncolor.imageviewer.application.App;

/**
 * Created by uncolor on 02.05.2018.
 */

public class SearchPhotosRequestData {

    private int offset;
    private int count;
    private String version;

    public SearchPhotosRequestData() {
        offset = 0;
        count = 50;
        version = App.getContext().getString(R.string.vk_api_version);
    }

    public void incOffset(){
        count++;
    }

    public void resetOffset(){
        offset = 0;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public String getVersion() {
        return version;
    }
}
