package com.ant.app.controller;

import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.AppMsg;
import com.ant.app.service.AppMsgServiceImpl;
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

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Api(value = "APP消息",description = "APP消息")
@RestController
@RequestMapping("/page/ant/msg")
public class AppMsgController {
    private static final Logger log = LoggerFactory.getLogger(AppMsgController.class);

    @Autowired
    AppMsgServiceImpl appMsgService;

    @ApiOperation(value = "消息发布", notes = "消息发布",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/send",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult sendAppMsg(@RequestBody AppMsg appMsg){
        log.info("消息发布----->"+appMsg);
        WebResult result = new WebResult();
        appMsgService.inseAppMsg(appMsg,result);
        return result;
    }

}
