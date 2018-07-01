package com.ant.app.model;

import java.util.Date;

/**
 * Created by sfb_liuchunlei on 2017/1/20.
 */
public class UserInfo {
    private String phoneNum;//用户手机号
    private Integer userId;
    private String antNick;//平台昵称
    private String userIconUrl;
    private Boolean isRealName;
    private String alias;//可用于登陆
    private String passWord;
    private int sex;//0男1女
    private int age;
    private String birthday;
    private int job;
    private String address;
    private int bankId;
    private Integer status;//用户状态0启用1禁用
    private Integer inviterId;//邀请人ID
    private Date createTime;
    private String uId;//微信openid
    private String nickName;//微信昵称
    private String iconUrl; //微信头像
    private String plantForm;
    private String deviceId;
    private String pkg;
    private Integer verifyStatus;//0审核通过1失败
    private String verifyMsg;
    private Date verifyTime;


    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", antNick='" + antNick + '\'' +
                ", isRealName=" + isRealName +
                ", alias='" + alias + '\'' +
                ", uId='" + uId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", status='" + status + '\'' +
                ", verifyStatus=" + verifyStatus +
                ", verifyMsg='" + verifyMsg + '\'' +
                ", verifyTime=" + verifyTime +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAntNick() {
        return antNick;
    }

    public void setAntNick(String antNick) {
        this.antNick = antNick;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public Boolean getRealName() {
        return isRealName;
    }

    public void setRealName(Boolean realName) {
        isRealName = realName;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getPlantForm() {
        return plantForm;
    }

    public void setPlantForm(String plantForm) {
        this.plantForm = plantForm;
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

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getVerifyMsg() {
        return verifyMsg;
    }

    public void setVerifyMsg(String verifyMsg) {
        this.verifyMsg = verifyMsg;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }
}
