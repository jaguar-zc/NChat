package org.flyants.book.view.dynamic;

import java.util.List;

public class PublishReq {


    private List<String> images;
    private String  location ;
    private String  text;
    private DynamicVisibility visibility;


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
