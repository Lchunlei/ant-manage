package com.ant.app.controller;


import com.ant.app.Constants;
import com.ant.app.entity.req.*;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.UserInfo;
import com.ant.app.service.UserServiceImpl;
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
@RequestMapping("/page/ant/manage")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;

//    @Value("${QRPay.url}")
//    private String url;
    private String imgurl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2759510913,362471303&fm=27&gp=0.jpg";
    private String actionUrl = "https://www.baidu.com/";


    @ApiOperation(value = "用户列表", notes = "用户列表",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/user/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult regApp(UserList userList){
        WebResult<List<UserInfo>> appResult = new WebResult();
        log.info("用户列表请求参数--------》"+userList);
        userService.getUserList(userList,appResult);
        log.info("--------》"+appResult.getWebData());
        return appResult;
    }


    @ApiOperation(value = "启用禁用用户", notes = "启用禁用用户",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/user/status",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult regApp(Integer userId,Integer status){
        WebResult result = new WebResult();
        log.info("启用禁用用户请求参数--------》"+userId+"status--->"+status);
        userService.updaUserStatus(status,userId,result);
        log.info("--------》"+result);
        return result;
    }



}
