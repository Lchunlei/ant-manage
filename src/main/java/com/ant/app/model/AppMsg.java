package com.ant.app.model;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
public class AppMsg {
    private Integer msgId;
    private String title;
    private String content;
    private Date pushtime;
    private String pTimer;
    private Integer msgType;//0系统消息1个人消息
    private Integer userId;//个人ID
    private String nickName;
    private String createTime;

    @Override
    public String toString() {
        return "AppMsg{" +
                "msgId=" + msgId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pushtime=" + pushtime +
                ", pTimer='" + pTimer + '\'' +
                ", msgType=" + msgType +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public String getpTimer() {
        return pTimer;
    }

    public void setpTimer(String pTimer) {
        this.pTimer = pTimer;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPushtime() {
        return pushtime;
    }

    public void setPushtime(Date pushtime) {
        this.pushtime = pushtime;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
