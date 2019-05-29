package org.flyants.book.view.experience;

import org.flyants.common.mvp.impl.BaseUiView;

import java.util.List;

interface UIExperienceView extends BaseUiView<FoundDto> {
    void setPullLoadMoreCompleted(int page, List<FoundDto> list);
}
