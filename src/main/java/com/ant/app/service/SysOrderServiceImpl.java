package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.DrawOrderMapper;
import com.ant.app.mapper.SysOrderMapper;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.SysOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
@Service
public class SysOrderServiceImpl {
    @Autowired
    SysOrderMapper sysOrderMapper;

    public void getAllList(LayUiAuToReq layUiAuToReq, LayUiResult<SysOrder> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = sysOrderMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setCode(0);
            result.setMsg("成功");
            result.setCount(totallNumAll);
            result.setData(sysOrderMapper.selectByPage(layUiAuToReq));
        }else{
            result.setCode(Constants.PAGE_ERROR_CODE);
            result.setMsg(Constants.NOT_MORE_INFO);
        }
    }




}
