package org.flyants.book.network.image;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.request.target.ImageViewTarget;

public class BackgroundImageViewTarget  extends ImageViewTarget<Bitmap> {

    public BackgroundImageViewTarget(ImageView view) {
        super(view);
    }

    @Override
    protected void setResource(Bitmap resource) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getView().getResources(), resource);
        view.setBackground(roundedBitmapDrawable);
    }
}
