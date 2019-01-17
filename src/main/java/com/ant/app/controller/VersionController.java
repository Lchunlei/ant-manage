package com.ant.app.controller;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.model.AppMsg;
import com.ant.app.model.AppVersion;
import com.ant.app.service.AppMsgServiceImpl;
import com.ant.app.service.VersionServiceImpl;
import com.ant.app.systable.SysTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lchunlei
 * @date 2018/11/9
 */
@RestController
@RequestMapping("/ant/app/version")
public class VersionController {
    private static final Logger log = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    VersionServiceImpl versionService;

    @RequestMapping(value = "/publish",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public WebResult publishApp(AppVersion appVersion){
        log.info("版本发布----->"+appVersion);
        WebResult result = new WebResult();
        versionService.inseAppVer(appVersion,result);
        return result;
    }

    @RequestMapping(value = "/verlist",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public LayUiResult<AppVersion> verlist(LayUiAuToReq layUiAuToReq){
        log.info("-----版本列表--------");
        layUiAuToReq.tableSet(SysTable.APP_VERSION,SysTable.VER_CODE,SysTable.CREAT_TIME,SysTable.VER_NAME,SysTable.VER_CODE);
        LayUiResult<AppVersion> result = new LayUiResult();
        versionService.getList(layUiAuToReq,result);
        return result;
    }


}
