package org.flyants.book.view.login;

import android.widget.EditText;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.common.mvp.impl.BaseActivity;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginCodeView extends BaseActivity<LoginCodePresenter> implements UILoginCodeView {

    @BindView(R.id.idHeader)
    Header idHeader;
    @BindView(R.id.view_phone)
    TextView view_phone;
    @BindView(R.id.sms_code_1)
    EditText sms_code_1;
    @BindView(R.id.sms_code_2)
    EditText sms_code_2;
    @BindView(R.id.sms_code_3)
    EditText sms_code_3;
    @BindView(R.id.sms_code_4)
    EditText sms_code_4;
    @BindView(R.id.view_phone_reset)
    TextView view_phone_reset;
    @BindView(R.id.complete)
    TextView complete;

    @Override
    public LoginCodePresenter buildPresenter() {
        return new LoginCodePresenter(this, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_code;
    }

    @Override
    public void setVerifyCode(String format, int res) {
        view_phone_reset.setText(format);
        view_phone_reset.setTextColor(res);
    }

    @Override
    public String getResetLableText() {
        return view_phone_reset.getText().toString();
    }

    @OnClick(R.id.view_phone_reset)
    public void onClickget_sms_code() {
        getPresenter().getSmsCode();
    }

    @OnClick(R.id.complete)
    public void onNext() {
        getPresenter().onNext();
    }


    @Override
    public String getInputCode() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sms_code_1.getText().toString());
        stringBuffer.append(sms_code_2.getText().toString());
        stringBuffer.append(sms_code_3.getText().toString());
        stringBuffer.append(sms_code_4.getText().toString());
        return stringBuffer.toString();
    }

    @Override
    public void setInputCode(String[] inputCode) {
//        sms_code_1.setText(inputCode[0] != null ? inputCode[0] : "");
//        sms_code_2.setText(inputCode[1] != null ? inputCode[1] : "");
//        sms_code_3.setText(inputCode[2] != null ? inputCode[2] : "");
//        sms_code_4.setText(inputCode[3] != null ? inputCode[3] : "");
    }

    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("验证码");
        String phone = getIntent().getStringExtra("phone");
        view_phone.setText(MessageFormat.format("短信验证码已发送至 {0}", phone));
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
