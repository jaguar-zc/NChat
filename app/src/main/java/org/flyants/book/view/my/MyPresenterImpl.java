package org.flyants.book.view.my;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.ArrayList;
import java.util.List;


public class MyPresenterImpl  extends BasePresenter<MyView,UiMyView> {

    Apis apis ;

    public MyPresenterImpl(MyView t, UiMyView uiMyView) {
        super(t, uiMyView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {
        UserStore.me.getUserInfo(context,new UserStore.OnUserInfo(){
            @Override
            public void OnUserInfo(UserInfo userInfo) {
                uiView.setVeiwAttrs(userInfo);
            }
        });
    }

    @Override
    public void onViewDestroy() {

    }

    public List<WorksModel> listWorks() {
        List<WorksModel> worksModels = new ArrayList<>();
        worksModels.add(new WorksModel("1","Bmoji-子弹的","http://icooding.oss-cn-shenzhen.aliyuncs.com/common/temp_work_2.png"));
        worksModels.add(new WorksModel("1","Bmoji-子弹的","http://icooding.oss-cn-shenzhen.aliyuncs.com/common/temp_works.png"));
        worksModels.add(new WorksModel("1","Bmoji-子弹的","http://icooding.oss-cn-shenzhen.aliyuncs.com/common/temp_works_3.png"));
        return worksModels;
    }
}
