package org.flyants.book.view.conversation.info;

import org.flyants.book.network.RequestUtils;
import org.flyants.book.network.okhttp.RespCall;
import org.flyants.book.resources.ConversationApis;
import org.flyants.common.mvp.impl.BasePresenter;

import java.util.Map;

class ConversationInfoPrecenter  extends BasePresenter<ConversationInfoView,UIConversationInfoView> {


    public ConversationInfoPrecenter(ConversationInfoView t, UIConversationInfoView uiConversationInfoView) {
        super(t, uiConversationInfoView);
    }

    @Override
    public void onViewInit() {
        String conversationId = view.getIntent().getStringExtra("conversationId");

        ConversationApis conversationApis = RequestUtils.build(ConversationApis.class);
        conversationApis.getConversation(conversationId).enqueue(new RespCall<Map<String, Object>>() {
            @Override
            public void onResp(Map<String, Object> resp) {
                uiView.setVeiwAttrs(resp);
            }
        });



    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
