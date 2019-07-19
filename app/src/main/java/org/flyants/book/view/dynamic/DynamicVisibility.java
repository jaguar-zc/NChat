package org.flyants.book.view.dynamic;

import org.apache.commons.lang3.StringUtils;

public enum  DynamicVisibility {
    ALL("所有人可见","所有可能认识的人都有机会看到"),
    FIRENDS("好友可见","仅互为好友可见"),
    PRIVATE("私密","仅自己可见");
    String value;
    String desc;

    DynamicVisibility(String value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static DynamicVisibility valueOfByValue(String value) {
        for (DynamicVisibility dynamicVisibility : values()) {
            if(StringUtils.equals(value,dynamicVisibility.value)){
                return dynamicVisibility;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
