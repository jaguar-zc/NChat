package org.flyants.book.view.my.meqrcode;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class MeQrCodePrecenter  extends BasePresenter<MeQrCodeView,UIMeQrCodeView> {

    Apis apis ;

    public MeQrCodePrecenter(MeQrCodeView t, UIMeQrCodeView uiMeQrCodeView) {
        super(t, uiMeQrCodeView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {
        UserStore.me.getUserInfo(context,new UserStore.OnUserInfo(){
            @Override
            public void OnUserInfo(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
            }
        });
    }

    @Override
    public void onViewDestroy() {

    }
}
