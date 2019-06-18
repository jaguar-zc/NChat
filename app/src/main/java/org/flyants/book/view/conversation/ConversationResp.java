package org.flyants.book.view.conversation;

import org.flyants.book.view.conversation.window.MessageResp;

import java.io.Serializable;

public class ConversationResp  implements Serializable {

    private String id;// (string, optional),
    private String type;// (string, optional) = ['SINGLE', 'GROUP']stringEnum:"SINGLE", "GROUP"
    private String  name;// (string, optional),
    private String icon;// (string, optional),
    private String tags;// (string, optional),
    private Integer top;// (integer, optional),
    private Integer dontDisturb  ;//(integer, optional),
    private String  messageUserId ;//(string, optional),
    private MessageResp lastMessage ;//(string, optional),

    public Integer getDontDisturb() {
        return dontDisturb;
    }

    public void setDontDisturb(Integer dontDisturb) {
        this.dontDisturb = dontDisturb;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessageUserId() {
        return messageUserId;
    }

    public void setMessageUserId(String messageUserId) {
        this.messageUserId = messageUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getType() {
        return type;
    }


    public MessageResp getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(MessageResp lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setType(String type) {
        this.type = type;
    }
}
