package org.flyants.book.view.login;

interface UILoginCodeView {
    void setVerifyCode(String format, int red);

    void setInputCode(char[] inputCode);

    String getInputCode();

    String getResetLableText();
}
