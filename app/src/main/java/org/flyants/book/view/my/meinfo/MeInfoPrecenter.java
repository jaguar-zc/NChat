package org.flyants.book.view.my.meinfo;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespEmptyCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.resources.DynamicApis;
import org.flyants.book.store.UserStore;
import org.flyants.book.utils.Page;
import org.flyants.book.view.base.BasePagePresenter;
import org.flyants.book.view.dynamic.DynamicResp;
import org.flyants.book.view.my.UserInfo;

import java.util.List;

import retrofit2.Call;

class MeInfoPrecenter  extends BasePagePresenter<MeInfoView,UIMeInfoView, DynamicResp> implements  SpringView.OnFreshListener {

    Apis apis ;
    DynamicApis dynamicApis ;

    public MeInfoPrecenter(MeInfoView t, UIMeInfoView uiMeInfoView) {
        super(t, uiMeInfoView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
        dynamicApis = RequestUtils.build(DynamicApis.class);
        UserStore.me.getUserInfo(context,new UserStore.OnUserInfo(){
            @Override
            public void OnUserInfo(UserInfo userInfo) {
                uiView.setViewAttrs(userInfo);
            }
        });

    }

    @Override
    public Call<Page<DynamicResp>> getPageProvider() {
        return dynamicApis.getDynamicListBySelf(page);
    }

    @Override
    public void onNextPage(int page, List<DynamicResp> list) {
        uiView.setPullLoadMoreCompleted(page,list);
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void peopleAssist() {
        UserStore.me.getUserInfo(context,new UserStore.OnUserInfo(){
            @Override
            public void OnUserInfo(UserInfo userInfo) {
                apis.assistPeople(userInfo.getId()).enqueue(new RespEmptyCall(){
                    @Override
                    public void onSuccess() {
                        super.onSuccess();
                        UserStore.me.clean();
                        onViewInit();
                    }
                });
            }
        });

    }
}
