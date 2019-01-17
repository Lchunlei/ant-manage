package com.ant.app.model;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/11/9
 */
public class AppVersion {
    private Integer versionCode;
    private String verisonName;
    private Integer platform;
    private String downloadUrl;
    private String updateMsg;
    private Date createTime;

    @Override
    public String toString() {
        return "AppVersion{" +
                "versionCode=" + versionCode +
                ", verisonName='" + verisonName + '\'' +
                ", platform=" + platform +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", updateMsg='" + updateMsg + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVerisonName() {
        return verisonName;
    }

    public void setVerisonName(String verisonName) {
        this.verisonName = verisonName;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateMsg() {
        return updateMsg;
    }

    public void setUpdateMsg(String updateMsg) {
        this.updateMsg = updateMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
