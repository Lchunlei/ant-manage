package com.ant.app.model;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
public class UserBill {
    private Integer billid;
    private Integer userId;
    private Integer coinType;//0积分1人民币
    private Integer amount;//交易量
    private Integer billType;//1充值2体现3收益
    private Integer billStatus;//0成功1失败
    private String explain;//交易简述
    private Date createTime;

    @Override
    public String toString() {
        return "UserBill{" +
                "billid=" + billid +
                ", userId=" + userId +
                ", coinType=" + coinType +
                ", amount=" + amount +
                ", billType=" + billType +
                ", billStatus=" + billStatus +
                ", explain='" + explain + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getBillid() {
        return billid;
    }

    public void setBillid(Integer billid) {
        this.billid = billid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCoinType() {
        return coinType;
    }

    public void setCoinType(Integer coinType) {
        this.coinType = coinType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
