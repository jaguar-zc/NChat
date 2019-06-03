package org.flyants.book.view.conversation;

import java.util.List;

public class CreateGroupConversationReq {
    private List<String> messageUserIds;

    public List<String> getMessageUserIds() {
        return messageUserIds;
    }

    public void setMessageUserIds(List<String> messageUserIds) {
        this.messageUserIds = messageUserIds;
    }
}
