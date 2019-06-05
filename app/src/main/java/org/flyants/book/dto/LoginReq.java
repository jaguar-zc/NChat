package org.flyants.book.dto;

public class LoginReq {
    public enum LoginType {
        PHONE, PASSWORD
    }
    private LoginType method;
    private String phone;
    private String mark;

    public LoginType getMethod() {
        return method;
    }

    public void setMethod(LoginType method) {
        this.method = method;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
