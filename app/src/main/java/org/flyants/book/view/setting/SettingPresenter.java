package org.flyants.book.view.setting;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
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
}
