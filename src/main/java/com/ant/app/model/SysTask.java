package com.ant.app.model;

import java.math.BigDecimal;
import java.util.Date;

public class SysTask {

    private Integer taskId;
    private Integer userId;
    private Integer type;//任务类型
    private String title;
    private Integer jobAmount;//投资佣金，单位分
    private BigDecimal readAmount;
    private Date createTime;
    private Integer verifyCode;//0未审核2审核不过1审核通过
    private String verifyMsg;//审核失败原因
    private String jobSeTitle;
    private String jobUrl;//任务链接地址
    private Integer readVol;//阅读数量
    private Integer maxRead;//有赏最大阅读数量

    @Override
    public String toString() {
        return "SysTask{" +
                "taskId=" + taskId +
                ", userId=" + userId +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", jobAmount=" + jobAmount +
                ", readAmount=" + readAmount +
                ", createTime=" + createTime +
                ", verifyCode=" + verifyCode +
                ", verifyMsg='" + verifyMsg + '\'' +
                ", jobSeTitle='" + jobSeTitle + '\'' +
                ", jobUrl='" + jobUrl + '\'' +
                ", readVol=" + readVol +
                ", maxRead=" + maxRead +
                '}';
    }

    public Integer getMaxRead() {
        return maxRead;
    }

    public void setMaxRead(Integer maxRead) {
        this.maxRead = maxRead;
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

    public BigDecimal getReadAmount() {
        return readAmount;
    }

    public void setReadAmount(BigDecimal readAmount) {
        this.readAmount = readAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
}
