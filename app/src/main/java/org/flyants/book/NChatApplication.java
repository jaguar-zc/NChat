package org.flyants.book;

import android.app.Application;

public class NChatApplication extends Application {


    static NChatApplication flyantsApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        flyantsApplication = this;

//        Apis apis = RequestUtils.build(Apis.class);

//        LoginReq loginReq = new LoginReq();
//        loginReq.setUsername("18981063280");
//        loginReq.setPassword("123456");
//        apis.loginByPassword(loginReq).enqueue(new RespCall<LoginResp>() {
//            @Override
//            public void onResp(LoginResp resp) {
//                NChatApplication.token = resp.getToken();
//            }
//        });
    }

    public static NChatApplication getFlyantsApplication() {
        return flyantsApplication;
    }
}
