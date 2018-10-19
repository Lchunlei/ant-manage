package com.ant.app.controller;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.SysOrder;
import com.ant.app.service.SysOrderServiceImpl;
import com.ant.app.systable.SysTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lchunlei
 * @date 2018/10/17
 */
@RestController
@RequestMapping("/ant/sys/order")
public class SysOrderController {
    private static final Logger log = LoggerFactory.getLogger(SysOrderController.class);

    @Autowired
    SysOrderServiceImpl sysOrderService;

    @RequestMapping(value = "/list",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult getAlllist(LayUiAuToReq layUiAuToReq){
        layUiAuToReq.tableSet(SysTable.SYS_ORDER,SysTable.ORDER_ID,SysTable.C_TIME,SysTable.SYS_USER_NAME,SysTable.ORDER_ID);
        LayUiResult<SysOrder> layUiResult = new LayUiResult();
        sysOrderService.getAllList(layUiAuToReq,layUiResult);
        log.info("--------》"+layUiResult);
        return layUiResult;
    }




}
