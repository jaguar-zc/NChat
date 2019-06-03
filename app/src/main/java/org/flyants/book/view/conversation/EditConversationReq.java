package org.flyants.book.view.conversation;

import java.util.List;

public class EditConversationReq {
    private Integer  dontDisturb;
    private String     icon;
    private String      name;
    private List<String> tags;
    private Integer     top;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
