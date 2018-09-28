package com.ant.app.model;

import com.ant.app.util.StringTool;

import java.util.Date;

public class SysTask {
    private Integer taskId;
    private Integer userId;
    private String nickName;
    private Integer type;//任务类型
    private String title;
    private Integer jobAmount;//投资佣金，单位分
    private String jobAmountYuan;
    private Integer balance;//余额
    private String balanceYuan;
    private Integer serviceCharge;//手续费
    private Integer readAmount;//阅读赏金
    private Integer verifyCode;//0未审核2审核不过1审核通过
    private String verifyMsg;//审核失败原因
    private String jobSeTitle;
    private String jobUrl;//任务链接地址
    private Integer readVol;//阅读数量
    private Integer moneyRead;//有赏阅读量
    private Integer getVol;//领取数
    private String startTime;
    private String endTime;
    private Date createTime;
    private String seTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if(StringTool.isRealStr(this.endTime)){
            this.seTime=startTime.split(" ")[0]+"/"+this.endTime.split(" ")[0];
        }
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        if(StringTool.isRealStr(this.startTime)){
            this.seTime=this.startTime.split(" ")[0]+"/"+endTime.split(" ")[0];
        }
        this.endTime = endTime;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getJobAmount() {
        return jobAmount;
    }

    public void setJobAmount(Integer jobAmount) {
        this.jobAmount = jobAmount;
    }

    public String getJobAmountYuan() {
        return jobAmountYuan;
    }

    public void setJobAmountYuan(String jobAmountYuan) {
        this.jobAmountYuan = jobAmountYuan;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getBalanceYuan() {
        return balanceYuan;
    }

    public void setBalanceYuan(String balanceYuan) {
        this.balanceYuan = balanceYuan;
    }

    public Integer getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Integer serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Integer getReadAmount() {
        return readAmount;
    }

    public void setReadAmount(Integer readAmount) {
        this.readAmount = readAmount;
    }

    public Integer getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Integer verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyMsg() {
        return verifyMsg;
    }

    public void setVerifyMsg(String verifyMsg) {
        this.verifyMsg = verifyMsg;
    }

    public String getJobSeTitle() {
        return jobSeTitle;
    }

    public void setJobSeTitle(String jobSeTitle) {
        this.jobSeTitle = jobSeTitle;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public Integer getReadVol() {
        return readVol;
    }

    public void setReadVol(Integer readVol) {
        this.readVol = readVol;
    }

    public Integer getMoneyRead() {
        return moneyRead;
    }

    public void setMoneyRead(Integer moneyRead) {
        this.moneyRead = moneyRead;
    }

    public Integer getGetVol() {
        return getVol;
    }

    public void setGetVol(Integer getVol) {
        this.getVol = getVol;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSeTime() {
        return seTime;
    }

    public void setSeTime(String seTime) {
        this.seTime = seTime;
    }
}
