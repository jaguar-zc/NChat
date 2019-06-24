package org.flyants.book.network.image.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.flyants.book.NChatApplication;
import org.flyants.book.network.image.ImageLoader;

public class ImageLoaderImpl implements ImageLoader {


    @Override
    public void loader(String url, ImageView imageView) {
        loader(NChatApplication.getFlyantsApplication(),url,imageView);
    }

    @Override
    public void loader(Context context, String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
