package org.flyants.book.view.login;

import android.widget.EditText;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.common.mvp.impl.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginView extends BaseActivity<LoginPresenter> implements UILoginView {

//    @BindView(R.id.idHeader) Header idHeader;
    @BindView(R.id.login_phone) EditText login_phone;
    @BindView(R.id.get_sms_code)  TextView get_sms_code;
    @BindView(R.id.error_msg)  TextView error_msg;

    @Override
    public LoginPresenter buildPresenter() {
        return new LoginPresenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.login;
    }

    @Override
    public void onViewInit() {
    }

    @Override
    public void onBackPressed() {

    }

    @OnClick(R.id.get_sms_code)
    public void onClickget_sms_code(){
        getPresenter().getCode();
    }

    @Override
    public String getPhone() {
        return login_phone.getText().toString();
    }

    @Override
    public void submitError(String error) {
        error_msg.setText(error);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
