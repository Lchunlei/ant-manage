package com.ant.app.controller;

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

/**
 * @author lchunlei
 * @date 2018/7/16
 */
@Api(value = "系统积分",description = "系统积分")
@RestController
@RequestMapping("/page/ant/coin")
public class SysCoinController {
    private static final Logger log = LoggerFactory.getLogger(SysCoinController.class);


    @ApiOperation(value = "用户资金", notes = "用户资金",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/user/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult getlist(){

        double i = 1*0.1;
        WebResult result = new WebResult();

        return result;
    }

}
