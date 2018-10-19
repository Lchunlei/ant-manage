package com.ant.app.controller;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.SysOrder;
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
@RequestMapping("/ant/draw")
public class DrawController {
    private static final Logger log = LoggerFactory.getLogger(DrawController.class);
    @Autowired
    DrawOrderServiceImpl drawOrderService;

    @ApiOperation(value = "提现列表", notes = "提现列表",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult getAlllist(LayUiAuToReq layUiAuToReq){
        WebResult<List<DrawOrder>> result = new WebResult();
        layUiAuToReq.tableSet(SysTable.DRAW_ORDER,SysTable.DRAW_ID,SysTable.C_TIME,SysTable.SYS_USER_NAME,SysTable.DRAW_ID);
        drawOrderService.getAllList(layUiAuToReq,result);
        LayUiResult<DrawOrder> layUiResult = new LayUiResult();
        layUiResult.setCode(0);
        layUiResult.setMsg("成功");
        layUiResult.setCount(result.getTotal());
        layUiResult.setData(result.getWebData());
        log.info("--------》"+layUiResult);
        return layUiResult;
    }

    @ApiOperation(value = "修改提现状态", notes = "修改提现状态",response=String.class)
    @ApiResponses({@ApiResponse(code = 201, message = "申请成功时返回成功信息")})
    @RequestMapping(value = "/update/status",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult updateStatus(DrawOrder drawOrder){
        log.info("---drawOrder-----》"+drawOrder);
        WebResult result = new WebResult();
        drawOrderService.updaDrawMapper(drawOrder,result);
        return result;
    }

    @RequestMapping(value = "/byId",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public WebResult getdOrderById(Integer drawId){
        log.info("---byId-----》"+drawId);
        WebResult<DrawOrder> result = new WebResult();
        drawOrderService.seleById(drawId,result);
        log.info("--------》"+result);
        return result;
    }

}
