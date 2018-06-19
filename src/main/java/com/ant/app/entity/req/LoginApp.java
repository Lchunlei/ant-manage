package com.ant.app.entity.req;

public class LoginApp {
    private String phonenum;
    private String alias;
    private String passWord;
    private String platForm;
    private String deviceId;
    private String pkg;

    @Override
    public String toString() {
        return "LoginApp{" +
                "phonenum='" + phonenum + '\'' +
                ", alias='" + alias + '\'' +
                ", passWord='" + passWord + '\'' +
                ", platForm='" + platForm + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", pkg='" + pkg + '\'' +
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPlatForm() {
        return platForm;
    }

    public void setPlatForm(String platForm) {
        this.platForm = platForm;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }
}
