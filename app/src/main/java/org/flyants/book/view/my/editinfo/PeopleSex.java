package org.flyants.book.view.my.editinfo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum PeopleSex {
    UNKNOWN("UNKNOWN","保密"),MAIL("MAIL","男"),FMAIL("FMAIL","女");


    private String value;
    private String name;

    PeopleSex(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static PeopleSex valueOfPeopleSex(String value){
        for (PeopleSex sex : values()) {
            if(StringUtils.equals(sex.value,value)){
                return sex;
            }
        }
        return null;
    }

    public static PeopleSex nameOfPeopleSex(String name){
        for (PeopleSex sex : values()) {
            if(StringUtils.equals(sex.getName(),name)){
                return sex;
            }
        }
        return null;
    }

    public static List<String> listNames(){
        List<String> names = new ArrayList<>();
        for (PeopleSex value : values()) {
            names.add(value.name);
        }
        return names;
    }
}
