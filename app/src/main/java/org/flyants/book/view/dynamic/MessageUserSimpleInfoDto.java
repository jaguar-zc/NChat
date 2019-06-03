package org.flyants.book.view.dynamic;

public class MessageUserSimpleInfoDto {
    private String   id;
    private String  encodedPrincipal ;
    private String  nickName ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncodedPrincipal() {
        return encodedPrincipal;
    }

    public void setEncodedPrincipal(String encodedPrincipal) {
        this.encodedPrincipal = encodedPrincipal;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
