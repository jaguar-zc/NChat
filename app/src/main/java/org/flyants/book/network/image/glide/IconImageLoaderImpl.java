package org.flyants.book.network.image.glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;

public class IconImageLoaderImpl implements ImageLoader {
    @Override
    public void loader(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.u0)
                .error(R.mipmap.u0)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(80, 80)//指定图片大小
                .into(imageView);
    }
}
