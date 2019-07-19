package org.flyants.component.gallery;

import java.util.List;

public interface OnGallerylistener {
    void close();
    void selected(List<MediaBean> mediaBean);

}
