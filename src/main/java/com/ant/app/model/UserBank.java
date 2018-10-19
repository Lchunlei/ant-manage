package com.ant.app.model;

import com.ant.app.util.MoneyUtil;

import java.util.Date;

public class UserBank {
    private Integer bankId;
    private Integer sysCoin;//系统积分
    private Integer nowMoney;//当前可提现账户余额(收益账户)
    private String nowMoneyYuan;
    private Integer czMoney;//可消费金额
    private String czMoneyYuan;
    private Integer earnMoney;//历史已经提现金额
    private String earnMoneyYuan;
    private String aliNum;//支付宝账号
    private String tenNum;//微信收款号
    private Integer userId;//用户ID
    private String nickName;
    private String signDay;//签到天数
    private Integer accId;//当前收益Id
    private Date createTime;
    private Date accTime;

    public String getNowMoneyYuan() {
        return nowMoneyYuan;
    }

    public void setNowMoneyYuan(String nowMoneyYuan) {
        this.nowMoneyYuan = nowMoneyYuan;
    }

    public String getCzMoneyYuan() {
        return czMoneyYuan;
    }

    public void setCzMoneyYuan(String czMoneyYuan) {
        this.czMoneyYuan = czMoneyYuan;
    }

    public String getEarnMoneyYuan() {
        return earnMoneyYuan;
    }

    public void setEarnMoneyYuan(String earnMoneyYuan) {
        this.earnMoneyYuan = earnMoneyYuan;
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

    public Integer getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(Integer nowMoney) {
        this.nowMoneyYuan= MoneyUtil.FenTurnYuan(nowMoney.toString());
        this.nowMoney = nowMoney;
    }

    public Integer getCzMoney() {
        return czMoney;
    }

    public void setCzMoney(Integer czMoney) {
        this.czMoneyYuan= MoneyUtil.FenTurnYuan(czMoney.toString());
        this.czMoney = czMoney;
    }

    public Integer getEarnMoney() {
        return earnMoney;
    }

    public void setEarnMoney(Integer earnMoney) {
        this.earnMoneyYuan= MoneyUtil.FenTurnYuan(earnMoney.toString());
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

    public String getSignDay() {
        return signDay;
    }

    public void setSignDay(String signDay) {
        this.signDay = signDay;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getAccTime() {
        return accTime;
    }

    public void setAccTime(Date accTime) {
        this.accTime = accTime;
    }
}
