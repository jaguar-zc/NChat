package org.flyants.book.view.dynamic.publish;

import org.flyants.book.view.dynamic.DynamicVisibility;
import org.flyants.book.view.my.UserInfo;

import java.util.List;

interface UIDynamicPublishView {
    void setViewAttrs(UserInfo userInfo);

    String getContent();

    List<String> getImageList();

    DynamicVisibility getDynamicVisibility();

    String getLocation();
}
