package org.flyants.book.view.conversation.window;

public class PublishMessageReq {
    public enum Type{
        TEXT, IMAGE, AUDIO
    }


    private String   body;
    private String   conversationId;
    private String   messageType;//['FRIENDS_APPLY', 'TEXT', 'IMAGE', 'AUDIO']stringEnum:"FRIENDS_APPLY", "TEXT", "IMAGE", "AUDIO"

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
