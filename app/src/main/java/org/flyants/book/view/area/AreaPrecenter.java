package org.flyants.book.view.area;

import org.flyants.book.store.AreaStore;
import org.flyants.book.utils.LogUtils;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

import java.util.List;

class AreaPrecenter extends BasePresenter<AreaView,UIAreaView> {

    public AreaPrecenter(AreaView t, UIAreaView uiAreaView) {
        super(t, uiAreaView);
    }

    @Override
    public void onViewInit() {
        AreaStore.me.loadObject(view, new OnCallback<List<Provinces>>() {
            @Override
            public void call(List<Provinces> provinces) {
                LogUtils.d("getAreaStr:"+provinces.size());
                uiView.setPullLoadMoreCompleted(1,provinces);
            }
        });
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
