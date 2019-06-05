package org.flyants.book.view.setting.privacy;

import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;

class PrivacyPresenter extends BasePresenter<PrivacyView,UIPrivacyView> implements AppConfigStrore.OnAppConfigStrore  {


    public PrivacyPresenter(PrivacyView t, UIPrivacyView uiPrivacyView) {
        super(t, uiPrivacyView);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.me.loaderAppConfig(context,this);
    }

    @Override
    public void OnAppConfigStrore(AppConfigStrore appConfigStrore) {
        uiView.setViewAttrs(appConfigStrore.getAddMeVerify(),appConfigStrore.getAllowTomeRecommendedGroup());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setAddMyFriendsVerify(boolean isChecked) {
        AppConfigStrore.me.setAddMeVerify(isChecked?1:0);
    }

    public void setAllowTomeRecommendedGroup(boolean isChecked) {
        AppConfigStrore.me.setAllowTomeRecommendedGroup(isChecked?1:0);
    }
}
