package org.flyants.book.view.my.meinfo;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;

class MeInfoPrecenter  extends BasePresenter<MeInfoView,UIMeInfoView> implements  SpringView.OnFreshListener {

    Apis apis ;

    public MeInfoPrecenter(MeInfoView t, UIMeInfoView uiMeInfoView) {
        super(t, uiMeInfoView);
    }

    @Override
    public void onViewInit() {
        UserStore.me.getUserInfo(context,new UserStore.OnUserInfo(){
            @Override
            public void OnUserInfo(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
            }
        });
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadmore() {

    }
}
