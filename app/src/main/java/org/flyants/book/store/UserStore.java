package org.flyants.book.store;

import android.content.Context;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.view.my.UserInfo;

public class UserStore {
    public static UserStore me = new UserStore();

    private UserInfo userInfo;

    public void clean(){
        userInfo = null;
    }



    public void getUserInfo(Context context,OnUserInfo onUserInfo){
        if(userInfo == null){
            Apis build = RequestUtils.build(Apis.class);
            build.userInfo().enqueue(new RespCall<UserInfo>() {
                @Override
                public void onResp(UserInfo resp) {
                    userInfo = resp;
                    onUserInfo.OnUserInfo(userInfo);
                }
            });
        }else{
            onUserInfo.OnUserInfo(userInfo);
        }
    }





    public interface OnUserInfo{
        public void OnUserInfo(UserInfo userInfo);
    }
}
