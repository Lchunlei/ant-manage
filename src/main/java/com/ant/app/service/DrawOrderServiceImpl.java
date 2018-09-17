package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.DrawOrderMapper;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.UserBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
@Service
public class DrawOrderServiceImpl {
    @Autowired
    DrawOrderMapper drawOrderMapper;

    public void getAllList(ReqList reqList, WebResult<List<DrawOrder>> result){
        Integer totallNumAll = drawOrderMapper.selectTotallNumAll(reqList);
        if(totallNumAll>0){
            result.setWebData(drawOrderMapper.selectBypageAll(reqList));
            result.setTotal(totallNumAll);
        }else{
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }
    }

    public void updaDrawMapper(DrawOrder drawOrder, WebResult result){
        int re = drawOrderMapper.updateDrawOrderStatus(drawOrder);
        if(re!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }


}
