package org.flyants.book.view.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.flyants.book.R;
import org.flyants.book.custom.Header;
import org.flyants.book.utils.LogUtils;
import org.flyants.common.mvp.impl.BaseActivity;

import java.text.MessageFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginCodeView extends BaseActivity<LoginCodePresenter> implements UILoginCodeView, TextWatcher {

    @BindView(R.id.idHeader)
    Header idHeader;
    @BindView(R.id.view_phone)
    TextView view_phone;


    @BindView(R.id.input_number)
    EditText input_number;
    @BindView(R.id.sms_code_1)
    TextView sms_code_1;
    @BindView(R.id.sms_code_2)
    TextView sms_code_2;
    @BindView(R.id.sms_code_3)
    TextView sms_code_3;
    @BindView(R.id.sms_code_4)
    TextView sms_code_4;
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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        LogUtils.d("beforeTextChanged:" + s);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        LogUtils.d("onTextChanged:" + s);
        setInputCode(s.toString().toCharArray());
    }

    @Override
    public void afterTextChanged(Editable s) {
        LogUtils.d("onTextChanged:" + s.toString());
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
    public void setInputCode(char[] inputCode) {
        sms_code_1.setText(inputCode.length > 0 ? inputCode[0] + "" : "");
        sms_code_2.setText(inputCode.length > 1 ? inputCode[1] + "" : "");
        sms_code_3.setText(inputCode.length > 2 ? inputCode[2] + "" : "");
        sms_code_4.setText(inputCode.length > 3 ? inputCode[3] + "" : "");
        if(inputCode.length == 4){
            complete.setVisibility(View.VISIBLE);
        }else{
            complete.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void onViewInit() {
        idHeader.setHeaderTitle("验证码");
        String phone = getIntent().getStringExtra("phone");
        complete.setVisibility(View.INVISIBLE);
        view_phone.setText(MessageFormat.format("短信验证码已发送至 {0}", phone));
        input_number.addTextChangedListener(this);
        input_number.setCursorVisible(false);//不显示光标
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
