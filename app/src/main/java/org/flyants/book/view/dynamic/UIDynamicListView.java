package org.flyants.book.view.dynamic;

import java.util.List;

interface UIDynamicListView {
    void setPullLoadMoreCompleted(int i, List<DynamicResp> rows);
}
