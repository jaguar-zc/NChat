package org.flyants.component.spi;

import org.flyants.component.imageloader.ImageLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoadeerUtils {

    public static ImageLoader loaderImageLoader(){
        ServiceLoader<ImageLoader> loader = ServiceLoader.load(ImageLoader.class);
        Iterator<ImageLoader> mIterator = loader.iterator();
        ImageLoader imageLoader = null;
        while (mIterator.hasNext()){
            imageLoader =  mIterator.next();
        }
        return imageLoader;
    }
}
