package com.ant.app.controller;


import com.ant.app.Constants;
import com.ant.app.entity.req.*;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.SysOrder;
import com.ant.app.model.UserInfo;
import com.ant.app.service.UserServiceImpl;
import com.ant.app.systable.SysTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by sfb_liuchunlei on 2018/5/9.
 */

@Api(value = "用户信息",description = "用户信息")
@RestController
@RequestMapping("/ant/manage")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/users",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult getUsers(LayUiAuToReq layUiAuToReq){
        log.info("users请求--------》"+layUiAuToReq);
        layUiAuToReq.tableSet(SysTable.SYS_USER,SysTable.SYS_USER_KEY,SysTable.CREAT_TIME,SysTable.SYS_USER_NAME,SysTable.SYS_USER_KEY);
        LayUiResult<UserInfo> layUiResult = new LayUiResult();
        userService.getUserList(layUiAuToReq,layUiResult);
        log.info("users--------》"+layUiResult);
        return layUiResult;
    }

    @ApiOperation(value = "启用禁用用户", notes = "启用禁用用户",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/user/status",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult regApp(Integer userId){
        WebResult result = new WebResult();
        log.info("启用禁用用户请求参数--------》"+userId);
        userService.updaUserStatus(userId,result);
        log.info("--------》"+result);
        return result;
    }



}
