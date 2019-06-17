package org.flyants.book.view.my.extinfo;

import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class ExtInfoPrecenter extends BasePresenter<ExtInfoView,UIExtInfoView> {



    public ExtInfoPrecenter(ExtInfoView t, UIExtInfoView uiExtInfoView) {
        super(t, uiExtInfoView);
    }

    @Override
    public void onViewInit() {
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                uiView.setVeiwAttrs(userInfo);
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
