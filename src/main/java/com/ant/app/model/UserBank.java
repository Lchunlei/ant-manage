package com.ant.app.model;

import java.math.BigDecimal;
import java.util.Date;

public class UserBank {
    private Integer bankId;
    private Integer readNum;//阅读总数
    private Integer shareNum;//分享次数
    private Integer sysCoin;//系统积分
    private BigDecimal nowMoney;//当前可提现账户余额(收益账户)
    private Integer czMoney;//可消费金额
    private Integer earnMoney;//历史已经提现金额
    private String aliNum;//支付宝账号
    private String tenNum;//微信收款号
    private Integer userId;//用户ID
    private String nickName;
    private String signDay;//签到天数
    private Integer accId;//当前收益Id
    private Date createTime;
    private Date accTime;

    public Date getAccTime() {
        return accTime;
    }

    public void setAccTime(Date accTime) {
        this.accTime = accTime;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getSignDay() {
        return signDay;
    }

    public void setSignDay(String signDay) {
        this.signDay = signDay;
    }

    public UserBank() {
    }

    public UserBank(Integer userId, String nickName) {
        this.userId = userId;
        this.nickName = nickName;
    }

    public Integer getCzMoney() {
        return czMoney;
    }

    public void setCzMoney(Integer czMoney) {
        this.czMoney = czMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getSysCoin() {
        return sysCoin;
    }

    public void setSysCoin(Integer sysCoin) {
        this.sysCoin = sysCoin;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public BigDecimal getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(BigDecimal nowMoney) {
        this.nowMoney = nowMoney;
    }

    public Integer getEarnMoney() {
        return earnMoney;
    }

    public void setEarnMoney(Integer earnMoney) {
        this.earnMoney = earnMoney;
    }

    public String getAliNum() {
        return aliNum;
    }

    public void setAliNum(String aliNum) {
        this.aliNum = aliNum;
    }

    public String getTenNum() {
        return tenNum;
    }

    public void setTenNum(String tenNum) {
        this.tenNum = tenNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
