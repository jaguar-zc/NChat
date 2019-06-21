package org.flyants.book.network.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.flyants.book.network.image.ImageLoader;

public class ImageLoaderImpl implements ImageLoader {
    @Override
    public void loader(String url, ImageView imageView) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
//        Glide.with(imageView.getContext())
//                .load(url)
//                .into(imageView);
    }
}
