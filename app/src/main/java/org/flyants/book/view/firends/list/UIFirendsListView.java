package org.flyants.book.view.firends.list;

import org.flyants.book.view.conversation.user.MessageUserSimpleInfo;

import java.util.List;

interface UIFirendsListView {
    void setPullLoadMoreCompleted(int i, List<MessageUserSimpleInfo> resp);

    void toConversationWindow(MessageUserSimpleInfo item);
}
