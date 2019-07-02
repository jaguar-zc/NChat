package org.flyants.book.view.area;

import java.util.List;

public class City extends Area {

    private List<Area> areaList;

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
