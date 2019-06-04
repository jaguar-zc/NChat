package org.flyants.book.view.conversation;

import org.flyants.book.view.conversation.ConversationResp;
import org.flyants.common.mvp.impl.BaseUiView;

import java.util.List;

interface UIConversationView extends BaseUiView<ConversationResp> {
    void setPullLoadMoreCompleted(int page, List<ConversationResp> list);
}
