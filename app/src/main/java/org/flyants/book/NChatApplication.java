package org.flyants.book;

import android.app.Application;

import org.flyants.book.dto.LoginReq;
import org.flyants.book.dto.LoginResp;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;

public class NChatApplication extends Application {


    static NChatApplication flyantsApplication;

    public static String token = " f369e37c-e456-4d28-8ce5-cdd6138a142c";


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
