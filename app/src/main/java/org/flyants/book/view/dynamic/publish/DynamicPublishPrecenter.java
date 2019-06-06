package org.flyants.book.view.dynamic.publish;

import org.flyants.common.store.OnCallback;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class DynamicPublishPrecenter extends BasePresenter<DynamicPublishView,UIDynamicPublishView>  implements OnCallback<UserInfo> {




    public DynamicPublishPrecenter(DynamicPublishView t, UIDynamicPublishView uiDynamicPublishView) {
        super(t, uiDynamicPublishView);
    }

    @Override
    public void onViewInit() {
        UserStore.getInstence().loadObject(context,this);
    }

    @Override
    public void call(UserInfo userInfo) {
        uiView.setViewAttrs(userInfo);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
