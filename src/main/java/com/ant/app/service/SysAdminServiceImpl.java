package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LoginApp;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.AdminMapper;
import com.ant.app.model.SysAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lchunlei
 * @date 2018/9/27
 */
@Service
public class SysAdminServiceImpl {
    @Autowired
    AdminMapper adminMapper;

    public void adminLogin(LoginApp loginApp, WebResult result){
        SysAdmin admin = adminMapper.selectLogin(loginApp.getPassWord(),loginApp.getAlias());
        if(admin==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.LOGIN_ERROR);
        }
    }

}
