package com.ant.app.entity.resp;

import com.ant.app.model.UserInfo;

public class RespLogin extends AppResult{
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
