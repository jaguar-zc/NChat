package org.flyants.book.view.setting.password;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.utils.ToastUtils;
import org.flyants.common.mvp.impl.BaseActivity;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class PasswordView extends BaseActivity<PasswordPrecenter> implements UIPasswordView {

    @BindView(R.id.idHeader)  Header idHeader;
    @BindView(R.id.send_phone) TextView send_phone;
    @BindView(R.id.get_sms_code) TextView get_sms_code;
    @BindView(R.id.sms_code)  EditText sms_code;
    @BindView(R.id.input_new_pwd)  EditText input_new_pwd;
    @BindView(R.id.input_new_pwd_face)  ImageView input_new_pwd_face;

    @BindView(R.id.complete) TextView complete;

    @Override
    public PasswordPrecenter buildPresenter() {
        return new PasswordPrecenter(this,this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.password;
    }

    @Override
    public void setVerifyCode(String text, int color) {
        get_sms_code.setText(text);
        get_sms_code.setTextColor(color);
    }

    @Override
    public String getInputCode() {
        return sms_code.getText().toString();
    }

    @Override
    public String getNewPassword() {
        return input_new_pwd.getText().toString();
    }

    @OnClick(R.id.get_sms_code)
    public void onClickSendVerifyCode(){
        getPresenter().onClickSendVerifyCode();
    }

    @OnClick(R.id.complete)
    public void onCommit(){
        getPresenter().commit();
    }

    @Override
    public void updatePwdComplete() {
        ToastUtils.show("修改成功");
        onBackPressed();
    }

    @Override
    public void setViewAttrs(String phone) {
        send_phone.setText(MessageFormat.format("验证码将发送至 {0} ",phone));
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("");
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
