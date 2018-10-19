package com.ant.app.model;

import com.ant.app.util.MoneyUtil;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
public class DrawOrder {
    private Integer drawId;
    private Integer userId;
    private Integer bankId;
    private String nickName;
    private String tradeNoTo;//提现订单号
    private Integer getType;//1微信2支付宝
    private Integer drawStatus;//1返现成功2失败0处理中
    private String aliAcc;//支付宝标识
    private String openId;//微信标识
    private Integer amount;//'金额分'
    private String amountYuan;//'金额元'
    private Integer bankStatus;//1已冲正2未冲正，默认为2
    private String tradeDes;
    private String createIp;
    private Date paymentTime;//'微信方支付完成时间'
    private Date cTime;

    @Override
    public String toString() {
        return "DrawOrder{" +
                "drawId=" + drawId +
                ", userId=" + userId +
                ", bankId=" + bankId +
                ", nickName='" + nickName + '\'' +
                ", tradeNoTo='" + tradeNoTo + '\'' +
                ", getType=" + getType +
                ", drawStatus=" + drawStatus +
                ", aliAcc='" + aliAcc + '\'' +
                ", openId='" + openId + '\'' +
                ", amount=" + amount +
                ", amountYuan='" + amountYuan + '\'' +
                ", bankStatus=" + bankStatus +
                ", tradeDes='" + tradeDes + '\'' +
                ", createIp='" + createIp + '\'' +
                ", paymentTime=" + paymentTime +
                ", cTime=" + cTime +
                '}';
    }

    public Integer getDrawId() {
        return drawId;
    }

    public void setDrawId(Integer drawId) {
        this.drawId = drawId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTradeNoTo() {
        return tradeNoTo;
    }

    public void setTradeNoTo(String tradeNoTo) {
        this.tradeNoTo = tradeNoTo;
    }

    public Integer getGetType() {
        return getType;
    }

    public void setGetType(Integer getType) {
        this.getType = getType;
    }

    public Integer getDrawStatus() {
        return drawStatus;
    }

    public void setDrawStatus(Integer drawStatus) {
        this.drawStatus = drawStatus;
    }

    public String getAliAcc() {
        return aliAcc;
    }

    public void setAliAcc(String aliAcc) {
        this.aliAcc = aliAcc;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amountYuan= MoneyUtil.FenTurnYuan(amount.toString());
        this.amount = amount;
    }

    public String getAmountYuan() {
        return amountYuan;
    }

    public void setAmountYuan(String amountYuan) {
        this.amountYuan = amountYuan;
    }

    public Integer getBankStatus() {
        return bankStatus;
    }

    public void setBankStatus(Integer bankStatus) {
        this.bankStatus = bankStatus;
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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
