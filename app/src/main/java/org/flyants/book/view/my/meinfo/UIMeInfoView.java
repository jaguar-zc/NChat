package org.flyants.book.view.my.meinfo;

import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.book.view.my.UserInfo;

import java.util.List;

interface UIMeInfoView {
    void setViewAttrs(UserInfo userInfo);

    void setPullLoadMoreCompleted(int page, List<DynamicResp> list);
}
