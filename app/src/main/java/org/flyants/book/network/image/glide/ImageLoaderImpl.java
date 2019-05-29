package org.flyants.book.network.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.flyants.book.network.image.ImageLoader;

public class ImageLoaderImpl implements ImageLoader {
    @Override
    public void loader(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
