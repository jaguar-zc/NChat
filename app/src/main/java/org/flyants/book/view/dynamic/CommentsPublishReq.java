package org.flyants.book.view.dynamic;

public class CommentsPublishReq {

    private String  commentsId;// (string, optional),
    private String commentsType;// (string, optional) = ['DYNAMIC']stringEnum:"DYNAMIC",
    private String  resourceId;
    private String text ;

    public String getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
    }

    public String getCommentsType() {
        return commentsType;
    }

    public void setCommentsType(String commentsType) {
        this.commentsType = commentsType;
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
