package com.colorblind.uncolor.imageviewer.utils;

/**
 * Created by uncolor on 04.05.2018.
 */

public class LabelFormatter {

    public static String getImageSliderCountLabel(int position, int count){
        return Integer.toString(position + 1) + " из " + Integer.toString(count);
    }
}
