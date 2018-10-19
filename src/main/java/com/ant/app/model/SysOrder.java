package com.ant.app.model;

import com.ant.app.util.MoneyUtil;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/10/17
 */
public class SysOrder {
    private Integer orderId;
    private Integer userId;
    private String nickName;
    private Integer bankId;
    private String body;
    private String tradeNo;
    private Integer totalFee;
    private String totalFeeYuan;
    private String tradeDes;
    private String createIp;
    private String expireTime;
    //1充值2购买商品
    private Integer buyType;
    //0支付成功1未支付2支付失败
    private Integer tradeStatus;
    private String  tradeType;
    private Date uTime;
    private Date cTime;

    public String getTotalFeeYuan() {
        return totalFeeYuan;
    }

    public void setTotalFeeYuan(String totalFeeYuan) {
        this.totalFeeYuan = totalFeeYuan;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFeeYuan = MoneyUtil.FenTurnYuan(totalFee.toString());
        this.totalFee = totalFee;
    }

    public String getTradeDes() {
        return tradeDes;
    }

    public void setTradeDes(String tradeDes) {
        this.tradeDes = tradeDes;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getBuyType() {
        return buyType;
    }

    public void setBuyType(Integer buyType) {
        this.buyType = buyType;
    }

    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
