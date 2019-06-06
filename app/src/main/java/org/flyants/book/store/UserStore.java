package org.flyants.book.store;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.utils.SharedPreferencesHelper;
import org.flyants.book.view.login.LoginView;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.store.IStore;
import org.flyants.common.store.OnCallback;

public class UserStore implements IStore<UserInfo> {
    private static UserStore me = new UserStore();

    private UserInfo userInfo;

    public static UserStore getInstence(){
        return me;
    }

    @Override
    public void clean() {
        userInfo = null;
    }

    @Override
    public void loadObject(Context context, OnCallback<UserInfo> callback) {
        if (userInfo == null) {
            Apis build = RequestUtils.build(Apis.class);
            build.userInfo().enqueue(new RespCall<UserInfo>() {
                @Override
                public void onResp(UserInfo resp) {
                    userInfo = resp;
                    callback.call(userInfo);
                }
            });
        } else {
            callback.call(userInfo);
        }
    }

    public void login(Activity activity) {
        if (StringUtils.isEmpty(SharedPreferencesHelper.$().getSharedPreference("token","").toString())) {
            activity.startActivity(new Intent(activity, LoginView.class));
        }
    }

}
