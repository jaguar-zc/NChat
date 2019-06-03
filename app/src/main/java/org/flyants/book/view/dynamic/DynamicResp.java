package org.flyants.book.view.dynamic;

import java.util.List;

public class DynamicResp  {

    private List<MessageUserSimpleInfoDto> assistPeopleList;
    private Integer commentsCount;
    private String createTime;
    private String encodedPrincipal;
    private String id;
    private List<String> images;
    private String location;
    private String nickName;
    private String peopleId;
    private String  text;
    private DynamicVisibility visibility ;//(string, optional) = ['ALL', 'FIRENDS', 'PRIVATE']stringEnum:"ALL", "FIRENDS", "PRIVATE"

    public List<MessageUserSimpleInfoDto> getAssistPeopleList() {
        return assistPeopleList;
    }

    public void setAssistPeopleList(List<MessageUserSimpleInfoDto> assistPeopleList) {
        this.assistPeopleList = assistPeopleList;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DynamicVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(DynamicVisibility visibility) {
        this.visibility = visibility;
    }
}
