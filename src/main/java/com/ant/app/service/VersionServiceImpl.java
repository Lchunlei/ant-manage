package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.VersionMapper;
import com.ant.app.model.AppVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lchunlei
 * @date 2018/11/9
 */
@Service
public class VersionServiceImpl {
    @Autowired
    VersionMapper versionMapper;

    public void inseAppVer(AppVersion appVersion, WebResult result){
        AppVersion oldVer = versionMapper.selectAppver(appVersion.getVerisonName());
        if(oldVer==null){
            versionMapper.insertAppVer(appVersion);
        }else {
            result.setMessage(Constants.DATA_REPEAT);
            result.setCode(Constants.ERROR_CODE);
        }
    }

    public void getList(LayUiAuToReq layUiAuToReq, LayUiResult<AppVersion> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = versionMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setData(versionMapper.selectByPage(layUiAuToReq));
            result.setCount(totallNumAll);
            result.setMsg(Constants.SUCCESS_MSG);
            result.setCode(Constants.PAGE_OK_CODE);
        }else{
            result.setMsg(Constants.NOT_MORE_INFO);
            result.setCode(Constants.PAGE_ERROR_CODE);
        }
    }

}
