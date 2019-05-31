package org.flyants.book.view.my.meinfo;

import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class MeInfoPrecenter  extends BasePresenter<MeInfoView,UIMeInfoView> {

    Apis apis ;

    public MeInfoPrecenter(MeInfoView t, UIMeInfoView uiMeInfoView) {
        super(t, uiMeInfoView);
    }

    @Override
    public void onViewInit() {
        if(UserStore.getUserInfo() == null){
            apis.userInfo().enqueue(new RespCall<UserInfo>() {
                @Override
                public void onResp(UserInfo resp) {
                    UserStore.setUserInfo(resp);
                    uiView.setViewAttrs(UserStore.getUserInfo());
                }
            });
        }else {
            uiView.setViewAttrs(UserStore.getUserInfo());
        }
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
