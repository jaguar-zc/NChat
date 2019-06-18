package org.flyants.book.network.image;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

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
