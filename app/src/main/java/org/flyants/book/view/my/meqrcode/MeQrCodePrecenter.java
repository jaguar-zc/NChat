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
    public void onViewDestroy() {

    }
}
