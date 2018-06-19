package com.ant.app.entity.req;

public class FindUserInfo {
    private Integer userId;

    @Override
    public String toString() {
        return "FindUserInfo{" +
                "userId=" + userId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
