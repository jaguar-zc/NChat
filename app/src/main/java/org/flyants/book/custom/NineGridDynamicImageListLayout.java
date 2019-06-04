package org.flyants.book.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

public class NineGridDynamicImageListLayout extends NineGridLayout {

    protected static final int MAX_W_H_RATIO = 3;

    public NineGridDynamicImageListLayout(Context context) {
        super(context);
    }

    public NineGridDynamicImageListLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected boolean displayOneImage(ImageView imageView, String url, int parentWidth) {
        return false;
    }

    @Override
    protected void displayImage(ImageView imageView, String url) {

    }

    @Override
    protected void onClickImage(int position, String url, ArrayList<String> urlList) {

    }
}
