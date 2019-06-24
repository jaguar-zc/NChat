package org.flyants.book.network.image;

import android.content.Context;
import android.widget.ImageView;

public interface ImageLoader {
    public void loader(Context context, String url, ImageView imageView);
    public void loader(String url, ImageView imageView);
}
