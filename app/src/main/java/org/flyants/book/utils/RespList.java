package org.flyants.book.utils;

import java.util.ArrayList;

public class RespList<T> extends ArrayList<T> {
    private Integer resp_code;
    private String resp_msg;

    public Integer getResp_code() {
        return resp_code;
    }

    public void setResp_code(Integer resp_code) {
        this.resp_code = resp_code;
    }

    public String getResp_msg() {
        return resp_msg;
    }

    public void setResp_msg(String resp_msg) {
        this.resp_msg = resp_msg;
    }
}
