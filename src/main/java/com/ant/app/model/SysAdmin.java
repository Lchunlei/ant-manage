package com.ant.app.model;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/9/27
 */
public class SysAdmin {
    private Integer id;
    private String adminAlias;
    private String passWord;
    private String realName;
    private String phoneNum;
    private Integer role;
    private Date creatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminAlias() {
        return adminAlias;
    }

    public void setAdminAlias(String adminAlias) {
        this.adminAlias = adminAlias;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
