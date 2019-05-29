package org.flyants.book.network.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import org.flyants.book.network.image.BackgroundImageViewTarget;
import org.flyants.book.network.image.ImageLoader;

public class CenterCropImageLoaderImpl implements ImageLoader {
    @Override
    public void loader(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView );
    }
}
