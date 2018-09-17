package com.ant.app.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/23
 */
public class NowIncome {
    private Integer accId;//'账单ID'
    private Integer userId;
    private String nickName;
    private Integer bankId;
    private BigDecimal nowIn;//当日总收入
    private BigDecimal readIn;//分享阅读收入
    private BigDecimal buyIn;//分享购收入
    private BigDecimal othIn;//其他收入
    private String ins;//备注
    private Date uTime;
    private Date createTime;

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
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

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public BigDecimal getNowIn() {
        return nowIn;
    }

    public void setNowIn(BigDecimal nowIn) {
        this.nowIn = nowIn;
    }

    public BigDecimal getReadIn() {
        return readIn;
    }

    public void setReadIn(BigDecimal readIn) {
        this.readIn = readIn;
    }

    public BigDecimal getBuyIn() {
        return buyIn;
    }

    public void setBuyIn(BigDecimal buyIn) {
        this.buyIn = buyIn;
    }

    public BigDecimal getOthIn() {
        return othIn;
    }

    public void setOthIn(BigDecimal othIn) {
        this.othIn = othIn;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
