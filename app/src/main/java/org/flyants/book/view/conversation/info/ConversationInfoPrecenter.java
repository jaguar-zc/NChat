package org.flyants.book.view.conversation.info;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.conversation.EditConversationReq;
import org.flyants.book.view.conversation.window.ConversationWindowView;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.Map;

import okhttp3.ResponseBody;

class ConversationInfoPrecenter  extends BasePresenter<ConversationInfoView,UIConversationInfoView> {

    ConversationApis conversationApis;
    String conversationId;

    public ConversationInfoPrecenter(ConversationInfoView t, UIConversationInfoView uiConversationInfoView) {
        super(t, uiConversationInfoView);
    }

    @Override
    public void onViewInit() {
        conversationId = view.getIntent().getStringExtra(ConversationWindowView.PARAM_NAME);
        conversationApis = RequestUtils.build(ConversationApis.class);
    }

    @Override
    public void onViewStart() {
        conversationApis.getConversation(conversationId).enqueue(new RespCall<ConversationResp>() {
            @Override
            public void onResp(ConversationResp resp) {
                uiView.setVeiwAttrs(resp);
            }
        });
    }

    @Override
    public void onViewDestroy() {

    }

    public void setMessageTop(boolean isChecked) {
        EditConversationReq editConversationReq = new EditConversationReq();
        editConversationReq.setTop(isChecked?1:0);
        conversationApis.editConversation(conversationId,editConversationReq).enqueue(new RespCall<ResponseBody>() {
            @Override
            public void onResp(ResponseBody resp) {
            }
        });
    }

    public void setDontDisturb(boolean isChecked) {
        EditConversationReq editConversationReq = new EditConversationReq();
        editConversationReq.setDontDisturb(isChecked?1:0);
        conversationApis.editConversation(conversationId,editConversationReq).enqueue(new RespCall<ResponseBody>() {
            @Override
            public void onResp(ResponseBody resp) {
            }
        });
    }
}
