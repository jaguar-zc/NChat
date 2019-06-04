package org.flyants.book.view.setting.accountsecurity;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.view.my.UserInfo;
import org.flyants.book.view.setting.password.PasswordView;
import org.flyants.book.view.setting.privacy.PrivacyView;
import org.flyants.common.mvp.impl.BaseActivity;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class AccountSecurityView  extends BaseActivity<AccountSecurityPresenter> implements UIAccountSecurity  {

    @BindView(R.id.idHeader)  Header idHeader;
    @BindView(R.id.chat_no)  TextView chat_no;
    @BindView(R.id.phone_no)  TextView phone_no;
    @BindView(R.id.setting_item_chat_no) LinearLayout setting_item_chat_no;
    @BindView(R.id.setting_item_phone)  LinearLayout setting_item_phone;
    @BindView(R.id.setting_item_auth)  LinearLayout setting_item_auth;
    @BindView(R.id.setting_item_password)  LinearLayout setting_item_password;
    @BindView(R.id.setting_item_security)  LinearLayout setting_item_security;

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
        idHeader.setHeaderTitle("账号与安全");
    }

    @Override
    public void setViewAttrs(UserInfo userInfo) {
        chat_no.setText(MessageFormat.format("{0}号：{1}",getString(R.string.app_name),userInfo.getPeopleNo()));
        phone_no.setText("手机号："+userInfo.getPhone());
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
    @OnClick(R.id.setting_item_password)
    public void onClickPasswordView(){
        startActivity(new Intent(getActivity(), PasswordView.class));
    }


}
