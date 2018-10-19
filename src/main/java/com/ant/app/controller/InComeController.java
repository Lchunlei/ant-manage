package com.ant.app.controller;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.entity.resp.WelcomeInit;
import com.ant.app.model.NowIncome;
import com.ant.app.model.SysIncome;
import com.ant.app.model.SysTask;
import com.ant.app.model.UserBank;
import com.ant.app.service.SysIncomeServiceImpl;
import com.ant.app.service.UserIncomeServiceImpl;
import com.ant.app.service.WebInitServiceImpl;
import com.ant.app.systable.SysTable;
import com.ant.app.util.MoneyUtil;
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

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Api(value = "收入统计",description = "收入统计")
@RestController
@RequestMapping("/ant/income")
public class InComeController {
    private static final Logger log = LoggerFactory.getLogger(InComeController.class);

    @Autowired
    UserIncomeServiceImpl userIncomeService;
    @Autowired
    SysIncomeServiceImpl sysIncomeService;
    @Autowired
    WebInitServiceImpl webInitService;

    @ApiOperation(value = "用户资金", notes = "用户资金",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/acc/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult getlist(LayUiAuToReq layUiAuToReq){
        WebResult<List<UserBank>> result = new WebResult();
        layUiAuToReq.tableSet(SysTable.USER_BANK,SysTable.BANK_ID,SysTable.CREAT_TIME,SysTable.SYS_USER_NAME,SysTable.BANK_ID);
        userIncomeService.getUbList(layUiAuToReq,result);

        LayUiResult<UserBank> layUiResult = new LayUiResult();
        layUiResult.setCode(0);
        layUiResult.setMsg("成功");
        layUiResult.setCount(result.getTotal());
        layUiResult.setData(result.getWebData());
        log.info("--------》"+result);
        return layUiResult;
    }

    @ApiOperation(value = "昨日收入排行", notes = "昨日收入排行",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/yester/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult getYesterlist(ReqList reqList){
        WebResult<List<NowIncome>> result = new WebResult();
        reqList.setTable(SysTable.NOW_INCOME,SysTable.NOW_INCOME_KEY,SysTable.NOW_INCOME_KEY,SysTable.SYS_USER_NAME,SysTable.NOW_IN);
        userIncomeService.getNowList(reqList,result);
        return result;
    }

    @RequestMapping(value = "/welcome/init",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult getWelcomeInit(){
        log.info("首页数据初始化--------");
        WebResult<WelcomeInit> result = new WebResult();
        webInitService.initWeb(result);
        log.info("首页数据初始化响应--------》"+result.getWebData());
        return result;
    }


}
