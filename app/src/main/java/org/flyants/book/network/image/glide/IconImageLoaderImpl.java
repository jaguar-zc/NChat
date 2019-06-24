package org.flyants.book.network.image.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import org.flyants.book.NChatApplication;
import org.flyants.book.R;
import org.flyants.book.network.image.ImageLoader;

public class IconImageLoaderImpl implements ImageLoader {


    @Override
    public void loader(String url, ImageView imageView) {
        loader(NChatApplication.getFlyantsApplication(),url,imageView);
    }

    @Override
    public void loader(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.u0)
                .error(R.mipmap.u0)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .override(80, 80)//指定图片大小
                .into(imageView);
    }
}
