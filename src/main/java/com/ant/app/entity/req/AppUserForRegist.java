package com.ant.app.entity.req;

import java.io.Serializable;

public class AppUserForRegist implements Serializable{
    private String phonenum;
    private String alias;//可用于登陆的别名
    private String smsCode;
    private String passWord;

    @Override
    public String toString() {
        return "AppUserForRegist{" +
                "phonenum='" + phonenum + '\'' +
                ", alias='" + alias + '\'' +
                ", smsCode='" + smsCode + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
