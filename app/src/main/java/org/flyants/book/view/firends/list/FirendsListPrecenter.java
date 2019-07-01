package org.flyants.book.view.firends.list;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.ArrayList;
import java.util.List;

class FirendsListPrecenter extends BasePresenter<FirendsListView,UIFirendsListView> implements SpringView.OnFreshListener{


    Apis apis;

//    List<MessageUserSimpleInfo> messageUserSimpleInfoList = new ArrayList<>();

    public FirendsListPrecenter(FirendsListView t, UIFirendsListView uiFirendsListView) {
        super(t, uiFirendsListView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onRefresh() {
        apis.getFriendsList().enqueue(new RespCall<List<MessageUserSimpleInfo>>() {
            @Override
            public void onResp(List<MessageUserSimpleInfo> resp) {
                uiView.setPullLoadMoreCompleted(0,resp);
            }
        });
    }

    @Override
    public void onLoadmore() {

    }

    @Override
    public void onViewDestroy() {

    }
}
