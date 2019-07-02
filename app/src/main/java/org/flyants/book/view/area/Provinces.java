package org.flyants.book.view.area;

import java.util.List;

public class Provinces extends Area {

    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
