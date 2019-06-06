package org.flyants.book.view.setting.addmetype;

import org.flyants.book.dto.PeopleAppConfig;
import org.flyants.book.view.my.UserInfo;

interface UIAddMeMethodView {
    void setViewAttrsConfig(PeopleAppConfig appConfig);

    void setViewAttrsUserInfo(UserInfo userInfo);
}
