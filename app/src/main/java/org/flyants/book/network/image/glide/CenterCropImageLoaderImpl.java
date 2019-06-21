package org.flyants.book.network.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import org.flyants.book.R;
import org.flyants.book.network.image.BackgroundImageViewTarget;
import org.flyants.book.network.image.ImageLoader;

public class CenterCropImageLoaderImpl implements ImageLoader {
    @Override
    public void loader(String url, ImageView imageView) {
//        Picasso.with(imageView.getContext()).load(url).into(imageView);
        Glide.with(imageView.getContext())
                .load(url)
                .thumbnail(0.2f)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .placeholder(R.mipmap.u0)
                .error(R.mipmap.u0)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(120, 120)//指定图片大小
                .into(imageView );
    }
}
