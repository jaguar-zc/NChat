package org.flyants.book.view.experience;

import org.flyants.book.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class ConversationDto {

    private String id;
    private String icon;
    private String username;
    private String timeStr;
    private String lastMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }


    public static void main(String[] args) {


        List<ConversationDto> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ConversationDto conversation = new ConversationDto();
            conversation.setId(i+"");
            conversation.setIcon("https://icooding.oss-cn-shenzhen.aliyuncs.com/common/firend.png");
            conversation.setLastMsg("大神，可以加你的好友吗?");
            conversation.setTimeStr("8:2"+i);
            conversation.setUsername("熊出没");
            list.add(conversation);
        }

        System.out.println(JsonUtils.convertObjectToJSON(list));

    }
}
