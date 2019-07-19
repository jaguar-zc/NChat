package org.flyants.book.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import org.flyants.book.network.image.glide.ImageLoaderImpl;
import org.flyants.component.imageloader.ImageLoader;

import java.util.ArrayList;

public class NineGridDynamicImageListLayout extends NineGridLayout {

    protected static final int MAX_W_H_RATIO = 3;

    ImageLoader imageLoader = new ImageLoaderImpl();

    public NineGridDynamicImageListLayout(Context context) {
        super(context);
    }

    public NineGridDynamicImageListLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected boolean displayOneImage(ImageView imageView, String url, int parentWidth) {
        imageLoader.loader(url,imageView);
        return false;
    }

    @Override
    protected void displayImage(ImageView imageView, String url) {
        imageLoader.loader(url+"!small",imageView);
    }

    @Override
    protected void onClickImage(int position, String url, ArrayList<String> urlList) {
        Toast.makeText(mContext, "点击了图片" + url, Toast.LENGTH_SHORT).show();
    }
}
