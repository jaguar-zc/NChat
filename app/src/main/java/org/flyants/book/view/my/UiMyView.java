package org.flyants.book.view.my;

import org.flyants.common.mvp.impl.BaseUiView;

import java.util.List;

public interface UiMyView extends BaseUiView<UserInfo> {
    void setWordsList(List<WorksModel> resp);
}
