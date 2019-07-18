package org.flyants.book.view.displaystore;

import java.io.Serializable;

public class Display implements Serializable {

    private static final long serialVersionUID = -7443398568111238043L;
    public int img;
    private String name;
    private String desc;
    private int selected;

    public Display(int img, String name, String desc, int selected) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.selected = selected;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
