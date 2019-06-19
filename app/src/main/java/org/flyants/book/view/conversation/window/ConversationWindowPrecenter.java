package org.flyants.book.view.conversation.window;

import org.apache.commons.lang3.StringUtils;
import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.Apis;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.store.UserStore;
import org.flyants.book.utils.Page;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BasePresenter;
import org.flyants.common.store.OnCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.ResponseBody;

class ConversationWindowPrecenter extends BasePresenter<ConversationWindowView,UIConversationWindowView> {

    ConversationApis conversationApis;
    ConversationResp conversationResp;
    UserInfo userInfo;
    public ConversationWindowPrecenter(ConversationWindowView t, UIConversationWindowView uiConversationWindowView) {
        super(t, uiConversationWindowView);
    }
    @Override
    public void onViewInit() {
        conversationApis = RequestUtils.build(ConversationApis.class);
        conversationResp = (ConversationResp)view.getIntent().getSerializableExtra(ConversationWindowView.PARAM_NAME);
        uiView.setVeiwAttrs(conversationResp);
        UserStore.getInstence().loadObject(context, new OnCallback<UserInfo>() {
            @Override
            public void call(UserInfo info) {
                userInfo = info;
                uiView.loadUserInfoComplete(info);
                conversationApis.getMessageList(conversationResp.getId(),1,20).enqueue(new RespCall<Page<MessageResp>>() {
                    @Override
                    public void onResp(Page<MessageResp> resp) {
                        List<MessageResp> respRows = resp.getRows();
                        Collections.reverse(respRows);
                        uiView.setPullLoadMoreCompleted(0,respRows);
                    }
                });
            }
        });
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }

    public void sendMessage(String content) {
        if(StringUtils.isEmpty(content)){
            return;
        }

        PublishMessageReq publishMessageReq = new PublishMessageReq();
        publishMessageReq.setBody(content);
        publishMessageReq.setConversationId(conversationResp.getId());
        publishMessageReq.setMessageType(PublishMessageReq.Type.TEXT.name());
        conversationApis.publishMessage(publishMessageReq).enqueue(new RespCall<ResponseBody>() {
            @Override
            public void onResp(ResponseBody resp) {
                uiView.publicMessageSuccess(publishMessageReq);
            }
        });


    }
}
