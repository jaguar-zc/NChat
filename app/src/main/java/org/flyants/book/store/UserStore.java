package org.flyants.book.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.NChatApplication;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.SharedPreferencesHelper;
import org.flyants.book.view.index.Home;
import org.flyants.book.view.login.LoginView;
import org.flyants.book.view.my.UserInfo;

public class UserStore {
    public static UserStore me = new UserStore();

    private UserInfo userInfo;

    public void clean() {
        userInfo = null;
    }


    public void getUserInfo(Context context, OnUserInfo onUserInfo) {
        if (userInfo == null) {
            Apis build = RequestUtils.build(Apis.class);
            build.userInfo().enqueue(new RespCall<UserInfo>() {
                @Override
                public void onResp(UserInfo resp) {
                    userInfo = resp;
                    onUserInfo.OnUserInfo(userInfo);
                }
            });
        } else {
            onUserInfo.OnUserInfo(userInfo);
        }
    }

    public void login(Activity activity) {
        if (StringUtils.isEmpty(SharedPreferencesHelper.$().getSharedPreference("token","").toString())) {
            activity.startActivity(new Intent(activity, LoginView.class));
        }
    }


    public interface OnUserInfo {
        public void OnUserInfo(UserInfo userInfo);
    }
}
