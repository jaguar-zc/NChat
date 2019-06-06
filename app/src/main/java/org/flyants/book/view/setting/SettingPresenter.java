package org.flyants.book.view.setting;

import android.content.Intent;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.book.utils.RespError;
import org.flyants.book.utils.SharedPreferencesHelper;
import org.flyants.book.view.login.LoginView;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.utils.APKVersionCodeUtils;

public class SettingPresenter extends BasePresenter<SettingView,UISettingView> {

    Apis apis;

    public SettingPresenter(SettingView t, UISettingView uiSettingView) {
        super(t, uiSettingView);
    }


    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {
        VersionResp versionResp = new VersionResp();
        versionResp.setRemake("体验新版本");
        versionResp.setVersionCode( APKVersionCodeUtils.getVersionCode(context));
        versionResp.setVersionName( APKVersionCodeUtils.getVerName(context));
        uiView.setVersionView(versionResp);
//        apis.getVersion().enqueue(new RespCall<VersionResp>() {
//            @Override
//            public void onResp(VersionResp resp) {
//                uiView.setVersionView(resp);
//            }
//        });
    }

    @Override
    public void onViewDestroy() {

    }

    public void logout() {
        apis.logout().enqueue(new RespEmptyCall(){
            @Override
            public void onSuccess() {
                super.onSuccess();
                UserStore.getInstence().clean();
                SharedPreferencesHelper.$().clear();
                UserStore.getInstence().login(view);
            }

            @Override
            public void onFail(RespError error) {
                super.onFail(error);
                UserStore.getInstence().clean();
                SharedPreferencesHelper.$().clear();
                UserStore.getInstence().login(view);
            }
        });
    }
}
