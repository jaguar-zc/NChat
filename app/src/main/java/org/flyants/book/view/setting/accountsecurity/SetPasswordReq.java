package org.flyants.book.view.setting.accountsecurity;

public class SetPasswordReq {
    private String password;
    private String smsCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
