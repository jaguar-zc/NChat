package org.flyants.book.view.setting.privacy;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class PrivacyPresenter extends BasePresenter<PrivacyView,UIPrivacyView> implements OnCallback<PeopleAppConfig> {


    public PrivacyPresenter(PrivacyView t, UIPrivacyView uiPrivacyView) {
        super(t, uiPrivacyView);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.getInstance().loadObject(context,this);
    }

    @Override
    public void call(PeopleAppConfig appConfig) {
        uiView.setViewAttrs(appConfig.getAddMeVerify(),appConfig.getAllowTomeRecommendedGroup());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setAddMyFriendsVerify(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setAddMeVerify(isChecked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }

    public void setAllowTomeRecommendedGroup(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setAllowTomeRecommendedGroup(isChecked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }
}
