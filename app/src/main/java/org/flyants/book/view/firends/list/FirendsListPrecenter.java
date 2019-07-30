package org.flyants.book.view.firends.list;

import com.liaoinstan.springview.widget.SpringView;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.conversation.CreateSingleConversationReq;
import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;

class FirendsListPrecenter extends BasePresenter<FirendsListView,UIFirendsListView> implements SpringView.OnFreshListener{


    Apis apis;
    ConversationApis conversationApis;

//    List<MessageUserSimpleInfo> messageUserSimpleInfoList = new ArrayList<>();

    public FirendsListPrecenter(FirendsListView t, UIFirendsListView uiFirendsListView) {
        super(t, uiFirendsListView);
    }

    @Override
    public void onViewInit() {
        apis = RequestUtils.build(Apis.class);
        conversationApis = RequestUtils.build(ConversationApis.class);
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

    public void toConversationWindow(String messageUserId) {
        CreateSingleConversationReq conversationReq = new CreateSingleConversationReq();
        conversationReq.setFirendsMessageUserId(messageUserId);
        conversationApis.createSingleConversation(conversationReq).enqueue(new RespCall<Map<String,Object>>() {
            @Override
            public void onResp(Map<String,Object> resp) {
                String conversationId = resp.get("value").toString();
                conversationApis.getConversation(conversationId).enqueue(new RespCall<ConversationResp>() {
                    @Override
                    public void onResp(ConversationResp resp) {
                        view.openConversationWindow(resp);
                    }
                });
            }
        });
    }
}
