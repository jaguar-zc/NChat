package org.flyants.book.view.setting.accountsecurity;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

public class AccountSecurityView  extends BaseActivity<AccountSecurityPresenter> implements UIAccountSecurity  {


    @Override
    public AccountSecurityPresenter buildPresenter() {
        return new AccountSecurityPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.account_security;
    }

    @Override
    public void onViewInit() {

    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
