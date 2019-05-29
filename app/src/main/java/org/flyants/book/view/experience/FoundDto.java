package org.flyants.book.view.experience;

import org.flyants.book.utils.JsonUtils;
import org.flyants.book.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class FoundDto {
    private String id;
    private String accountLogo;
    private String accountName;
    private String time;
    private String url;
    private String title;
    private String tags;
    private Integer show;
    private Integer like;
    private Boolean isMyLike = false;
    private Integer commonts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountLogo() {
        return accountLogo;
    }

    public void setAccountLogo(String accountLogo) {
        this.accountLogo = accountLogo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getCommonts() {
        return commonts;
    }

    public void setCommonts(Integer commonts) {
        this.commonts = commonts;
    }

    public Boolean getMyLike() {
        return isMyLike;
    }

    public void setMyLike(Boolean myLike) {
        isMyLike = myLike;
    }
}
