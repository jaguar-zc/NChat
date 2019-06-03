package org.flyants.book.view.dynamic;

public class CommentsSimpleResp {

    private String id;
    private Long createTime;
    private String encodedPrincipal;
    private Integer level;
    private String  nickName;
    private String replyNickName;
    private String  resourceId;
    private String  text;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getEncodedPrincipal() {
        return encodedPrincipal;
    }

    public void setEncodedPrincipal(String encodedPrincipal) {
        this.encodedPrincipal = encodedPrincipal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReplyNickName() {
        return replyNickName;
    }

    public void setReplyNickName(String replyNickName) {
        this.replyNickName = replyNickName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
