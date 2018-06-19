package com.ant.app.controller;


import com.ant.app.Constants;
import com.ant.app.entity.req.*;
import com.ant.app.entity.resp.AppResult;
import com.ant.app.model.Banner;
import com.ant.app.model.AppJob;
import com.ant.app.model.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sfb_liuchunlei on 2018/5/9.
 */

@Api(value = "UserInfo",description = "用户基本信息操作")
@RestController
@RequestMapping("/ant/manage")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
//    @Value("${QRPay.url}")
//    private String url;
    private String imgurl = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2759510913,362471303&fm=27&gp=0.jpg";
    private String actionUrl = "https://www.baidu.com/";
//    @Autowired
//    MsgMapperImpl userServiceImp;

    @ApiOperation(value = "注册用户", notes = "注册用户",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/reg",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public AppResult regApp(@RequestBody AppUserForRegist appUserForRegist){
        AppResult appResult = new AppResult();
        log.info("---------注册用户--------");
        log.info("请求参数--------》"+appUserForRegist);

        return appResult;
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/login",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public AppResult loginApp(LoginApp loginApp, HttpSession session){
        AppResult appResult = new AppResult();
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

    @ApiOperation(value = "查看轮播图", notes = "查看轮播图",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/getBanners",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public AppResult getBanners(@RequestBody FindBanner findBanner){
        AppResult appResult = new AppResult();
        log.info("---------查看轮播图--------");
        log.info("查看轮播图请求参数--------》"+findBanner);
        List list = new ArrayList();

        Banner banner1 = new Banner();
        banner1.setTitle("我的大中国");
        banner1.setImgUrl(imgurl);
        banner1.setActionUrl(actionUrl);
        Banner banner2 = new Banner();
        banner2.setTitle("再爱大北京");
        banner2.setImgUrl(imgurl);
        banner2.setActionUrl(actionUrl);

        list.add(banner1);
        list.add(banner2);

        appResult.setData(list);
        return appResult;

    }

    @ApiOperation(value = "任务列表查询", notes = "任务列表查询",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/getJobs",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public AppResult getJobs(@RequestBody FindJobs findJobs){
        AppResult appResult = new AppResult();
        log.info("---------任务列表查询--------");
        log.info("任务列表查询请求参数--------》"+findJobs);
        List list = new ArrayList();

        AppJob appJob1 = new AppJob("中国故宫","古代帝王寝宫","付费","4.00",actionUrl);
        AppJob appJob2 = new AppJob("中国长城","古代王朝的军事防御","付费","3.00",actionUrl);

        list.add(appJob1);
        list.add(appJob2);

        appResult.setData(list);
        return appResult;

    }

    @ApiOperation(value = "查看用户信息", notes = "查看用户信息",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/userInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public AppResult getUserInfo(@RequestBody FindUserInfo findUserInfo){
        AppResult appResult = new AppResult();
        log.info("---------查看用户信息--------");
        log.info("查看用户信息请求参数--------》"+findUserInfo);

        UserInfo user = new UserInfo();
        user.setPhonenum("13213855985");
        user.setUserId(1);
        user.setNickName("喜刷刷");
        user.setRealName(true);
        user.setUserIconUrl(actionUrl);

        appResult.setOneData(user);
        return appResult;
    }


}
