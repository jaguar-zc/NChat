package org.flyants.book.view.setting.addmetype;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.store.AppConfigStrore;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class AddMeMethodPrecenter extends BasePresenter<AddMeMethodView,UIAddMeMethodView> {

    public AddMeMethodPrecenter(AddMeMethodView t, UIAddMeMethodView uiAddMeMethodView) {
        super(t, uiAddMeMethodView);
    }

    @Override
    public void onViewInit() {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                uiView.setViewAttrsConfig(appConfig);
            }
        });
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                uiView.setViewAttrsUserInfo(userInfo);
            }
        });

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void setChangePhone(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setUsePhonePlusMe(isChecked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }

    public void setChangeChatNo(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setUseChatNoPlusMe(isChecked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }

    public void setChangeQrCode(boolean isChecked) {
        AppConfigStrore.getInstance().loadObject(context, new OnCallback<PeopleAppConfig>() {
            @Override
            public void call(PeopleAppConfig appConfig) {
                appConfig.setUseQrCodePlusMe(isChecked?1:0);
                AppConfigStrore.getInstance().update(appConfig);
            }
        });
    }
}
