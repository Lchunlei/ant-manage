package com.ant.app.controller;

import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.DrawOrder;
import com.ant.app.service.DrawOrderServiceImpl;
import com.ant.app.systable.SysTable;
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
 * @date 2018/9/17
 */
@Api(value = "用户提现",description = "用户提现")
@RestController
@RequestMapping("/page/ant/draw")
public class DrawController {
    private static final Logger log = LoggerFactory.getLogger(DrawController.class);
    @Autowired
    DrawOrderServiceImpl drawOrderService;

    @ApiOperation(value = "提现列表", notes = "提现列表",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult getAlllist(ReqList reqList){
        WebResult<List<DrawOrder>> result = new WebResult();
        reqList.setTable(SysTable.DRAW_ORDER,SysTable.DRAW_ID,SysTable.SYS_USER_KEY,SysTable.SYS_USER_NAME,SysTable.DRAW_ID);
        drawOrderService.getAllList(reqList,result);
        return result;
    }

    @ApiOperation(value = "修改提现状态", notes = "修改提现状态",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/update/status",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult updateStatus(DrawOrder drawOrder){
        WebResult result = new WebResult();
        drawOrderService.updaDrawMapper(drawOrder,result);
        return result;
    }


}
