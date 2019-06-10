package org.flyants.book.view.conversation.window;

import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.mvp.impl.BasePresenter;

class ConversationWindowPrecenter extends BasePresenter<ConversationWindowView,UIConversationWindowView> {

    public ConversationWindowPrecenter(ConversationWindowView t, UIConversationWindowView uiConversationWindowView) {
        super(t, uiConversationWindowView);
    }

    @Override
    public void onViewInit() {
        ConversationResp conversationResp = (ConversationResp)view.getIntent().getSerializableExtra(ConversationWindowView.PARAM_NAME);
        uiView.setVeiwAttrs(conversationResp);
    }

    @Override
    public void onViewStart() {

    }

    @Override
    public void onViewDestroy() {

    }
}
