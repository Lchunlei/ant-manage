package com.ant.app.controller;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.AppMsg;
import com.ant.app.service.AppMsgServiceImpl;
import com.ant.app.systable.SysTable;
import com.ant.app.util.CheckReqUtil;
import com.ant.app.util.StringTool;
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
@RestController
@RequestMapping("/ant/msg")
public class AppMsgController {
    private static final Logger log = LoggerFactory.getLogger(AppMsgController.class);

    @Autowired
    AppMsgServiceImpl appMsgService;

    @RequestMapping(value = "/send",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult sendAppMsg(AppMsg appMsg){
        log.info("消息发布----->"+appMsg);
        WebResult result = new WebResult();
        appMsgService.inseAppMsg(appMsg,result);
        return result;
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult<AppMsg> getBnnerList(LayUiAuToReq layUiAuToReq){
        log.info("-----查看消息列表--------");
        layUiAuToReq.tableSet(SysTable.PUSH_MSG,SysTable.MSG_ID,SysTable.CREAT_TIME,SysTable.TASK_TITAL,SysTable.MSG_ID);
        LayUiResult<AppMsg> result = new LayUiResult();
        appMsgService.getList(layUiAuToReq,result);

        log.info("查看消息列表--------》"+result);
        return result;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult sendAppMsg(String msgids){
        log.info("删除消息----->"+msgids);
        WebResult result = new WebResult();
        appMsgService.delMsgs(msgids,result);
        return result;
    }

}
