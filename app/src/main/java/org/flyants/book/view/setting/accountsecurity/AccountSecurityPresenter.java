package org.flyants.book.view.setting.accountsecurity;

import org.flyants.common.store.OnCallback;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class AccountSecurityPresenter extends BasePresenter<AccountSecurityView,UIAccountSecurity> {

    public AccountSecurityPresenter(AccountSecurityView t, UIAccountSecurity uiAccountSecurity) {
        super(t, uiAccountSecurity);
    }


    @Override
    public void onViewInit() {

        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
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
