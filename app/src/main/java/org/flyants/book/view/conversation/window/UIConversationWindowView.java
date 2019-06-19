package org.flyants.book.view.conversation.window;

import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.book.view.my.UserInfo;
import org.flyants.common.mvp.impl.BaseUiView;

import java.util.List;

interface UIConversationWindowView extends BaseUiView<ConversationResp> {
    void publicMessageSuccess(PublishMessageReq publishMessageReq);

    void setPullLoadMoreCompleted(int i, List<MessageResp> rows);

    void loadUserInfoComplete(UserInfo info);
}
