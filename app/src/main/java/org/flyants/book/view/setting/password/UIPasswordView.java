package org.flyants.book.view.setting.password;

interface UIPasswordView {
    void setVerifyCode(String format, int mqr);

    String getInputCode();

    String getNewPassword();

    void updatePwdComplete();

    void setViewAttrs(String phone);
}
