package com.ant.app.controller;

import com.ant.app.Constants;
import com.ant.app.entity.req.LoginApp;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.service.SysAdminServiceImpl;
import com.ndktools.javamd5.core.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

/**
 * Created by sfb_liuchunlei on 2018/6/24.
 */
@Api(value = "管理员",description = "管理员")
@RestController
@RequestMapping("/ant/manage")
public class SysController {
    private static final Logger log = LoggerFactory.getLogger(SysController.class);
    @Autowired
    SysAdminServiceImpl sysAdminService;

    @ApiOperation(value = "用户登陆", notes = "用户登陆",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult loginApp(LoginApp loginApp, HttpSession session){
        WebResult appResult = new WebResult();
        MD5 md5 = new MD5();
        String pwd = md5.getMD5ofStr(loginApp.getPassWord()+Constants.PWD_SALT);
        loginApp.setPassWord(pwd);
        log.info("---------用户登陆--------");
        log.info("用户登陆请求参数--------》"+loginApp);
        sysAdminService.adminLogin(loginApp,appResult);
        return appResult;
    }

}
