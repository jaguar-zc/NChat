package org.flyants.book.view.my.medynamic;

import org.flyants.book.view.dynamic.DynamicResp;

import java.util.List;

interface UIMeDynamicView {
    void setPullLoadMoreCompleted(int page, List<DynamicResp> list);
}
