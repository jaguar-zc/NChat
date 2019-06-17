package org.flyants.book.view.my.meinfo;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.store.UserStore;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

class MeInfoPrecenter  extends BasePresenter<MeInfoView,UIMeInfoView> {

    Apis apis ;


    public MeInfoPrecenter(MeInfoView t, UIMeInfoView uiMeInfoView) {
        super(t, uiMeInfoView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
            }
        });
    }

    @Override
    public void onViewDestroy() {

    }

    public void peopleAssist() {
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {
                apis.assistPeople(userInfo.getId()).enqueue(new RespEmptyCall(){
                    @Override
                    public void onSuccess() {
                        super.onSuccess();
                        UserStore.getInstence().clean();
                        onViewInit();
                    }
                });
            }
        });

    }
}
