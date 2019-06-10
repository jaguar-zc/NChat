package org.flyants.book.view.conversation.window;

public class MessageResp {

    private String   id ;
    private String   body;
    private String   conversationId ;
    private String   messageType;// (string, optional) = ['FRIENDS_APPLY', 'TEXT', 'IMAGE', 'AUDIO']stringEnum:"FRIENDS_APPLY", "TEXT", "IMAGE", "AUDIO",
    private String   messageUserId ;
    private String   sendTime ;
    private String   view ;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(String messageUserId) {
        this.messageUserId = messageUserId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
