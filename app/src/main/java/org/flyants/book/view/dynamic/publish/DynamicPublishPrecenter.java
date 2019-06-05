package org.flyants.book.view.dynamic.publish;

import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class DynamicPublishPrecenter extends BasePresenter<DynamicPublishView,UIDynamicPublishView> implements UserStore.OnUserInfo {




    public DynamicPublishPrecenter(DynamicPublishView t, UIDynamicPublishView uiDynamicPublishView) {
        super(t, uiDynamicPublishView);
    }

    @Override
    public void onViewInit() {
        UserStore.me.getUserInfo(context,this);
    }

    @Override
    public void OnUserInfo(UserInfo userInfo) {
        uiView.setViewAttrs(userInfo);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
