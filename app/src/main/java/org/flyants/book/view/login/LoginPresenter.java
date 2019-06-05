package org.flyants.book.view.login;

import android.content.Intent;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.RespError;
import org.flyants.book.view.setting.password.SendSmsCodeReq;
import org.flyants.common.mvp.impl.BasePresenter;

class LoginPresenter extends BasePresenter<LoginView,UILoginView> {

    Apis apis;

    public LoginPresenter(LoginView t, UILoginView uiLoginView) {
        super(t, uiLoginView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void getCode() {
        String phone = uiView.getPhone();
        if(StringUtils.isEmpty(phone)){
            uiView.submitError("请输入手机号");
            return;
        }

        if(StringUtils.length(phone) != 11){
            uiView.submitError("请输入正确的手机号");
            return;
        }
        uiView.submitError("");
        apis.sendSmsCode(phone).enqueue(new RespEmptyCall(){
            @Override
            public void onSuccess() {
                super.onSuccess();
                Intent intent = new Intent(view, LoginCodeView.class);
                intent.putExtra("phone",phone);
                view.startActivity(intent);
            }

            @Override
            public void onFail(RespError error) {
                super.onFail(error);
                uiView.submitError(error.getResp_msg());
            }
        });

    }
}
