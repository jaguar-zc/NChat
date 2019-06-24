package org.flyants.book.view.login;

import android.content.Intent;
import android.os.CountDownTimer;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.R;
import org.flyants.book.dto.LoginReq;
import org.flyants.book.dto.LoginResp;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.RespError;
import org.flyants.book.utils.SharedPreferencesHelper;
import org.flyants.book.view.index.Home;
import org.flyants.common.mvp.AppActivityManager;
import org.flyants.common.mvp.impl.BasePresenter;

class LoginCodePresenter extends BasePresenter<LoginCodeView,UILoginCodeView> {


    private String phone;

    public int Max = 60;//60秒重发
    public int reRendSmsCode = 60;//还剩于多少秒重发

    Apis apis;


    public LoginCodePresenter(LoginCodeView t, UILoginCodeView uiLoginCodeView) {
        super(t, uiLoginCodeView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
        phone = view.getIntent().getStringExtra("phone");
    }

    @Override
    public void onViewStart() {
        timer.start();
    }

    @Override
    public void onViewDestroy() {

    }


    public void getSmsCode(){
        String lableText = uiView.getResetLableText();
        if(!StringUtils.equals(lableText,"获取验证码")){
            return;
        }

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
                uiView.setVerifyCode(error.getResp_msg(),R.color.red);
            }
        });
    }



    public void onNext() {
        LoginReq loginReq = new LoginReq();
        loginReq.setMethod(LoginReq.LoginType.PHONE);
        loginReq.setPhone(phone);
        loginReq.setMark(uiView.getInputCode());
        apis.login(loginReq).enqueue(new RespCall<LoginResp>() {
            @Override
            public void onResp(LoginResp resp) {
                SharedPreferencesHelper.$().put("token",resp.getToken());
                view.startActivity(new Intent(view, Home.class));
                AppActivityManager.getInstance().finishActivity(LoginView.class,LoginCodeView.class);
            }
        });
    }


    CountDownTimer timer = new CountDownTimer(reRendSmsCode * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            reRendSmsCode = reRendSmsCode - 1;
            uiView.setVerifyCode(String.format("%s秒后重发", reRendSmsCode), R.color.gray);
        }

        @Override
        public void onFinish() {
            reRendSmsCode = Max;
            uiView.setVerifyCode("获取验证码", R.color.red);
            timer.cancel();
        }
    };
}
