package org.flyants.book.store;

import org.flyants.book.view.my.UserInfo;

public class UserStore {
    public static UserStore me = new UserStore();

    private UserInfo userInfo;

    public static UserInfo getUserInfo(){
        return me.userInfo;
    }

    public static void setUserInfo(UserInfo userInfo){
        me.userInfo = userInfo;
    }


}
