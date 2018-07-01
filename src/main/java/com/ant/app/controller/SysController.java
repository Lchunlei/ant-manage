package com.ant.app.controller;

import com.ant.app.Constants;
import com.ant.app.entity.req.LoginApp;
import com.ant.app.entity.resp.WebResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @ApiOperation(value = "用户登陆", notes = "用户登陆",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult loginApp(LoginApp loginApp, HttpSession session){
        WebResult appResult = new WebResult();
        log.info("---------用户登陆--------");
        log.info("用户登陆请求参数--------》"+loginApp);
        if("124".equals(loginApp.getAlias())&&"123456".equals(loginApp.getPassWord())){
            session.setAttribute(Constants.USER_TOLE,Constants.USER_TOLE_A);
        }else if ("125".equals(loginApp.getAlias())&&"123456".equals(loginApp.getPassWord())){
            session.setAttribute(Constants.USER_TOLE,Constants.USER_TOLE_B);
        }else{
            appResult.setCode(Constants.LOGIN_ERROR_CODE);
            appResult.setMessage(Constants.LOGIN_ERROR);
        }

        return appResult;
    }

}
