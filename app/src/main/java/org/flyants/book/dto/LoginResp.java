package org.flyants.book.dto;

import org.flyants.book.utils.RespError;

public class LoginResp extends RespError {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
