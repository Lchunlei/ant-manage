package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.DrawOrderMapper;
import com.ant.app.mapper.UserBankMapper;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.UserBank;
import com.ant.app.util.StringTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
@Service
public class DrawOrderServiceImpl {
    @Autowired
    DrawOrderMapper drawOrderMapper;
    @Autowired
    UserBankMapper userBankMapper;

    public void getAllList(LayUiAuToReq layUiAuToReq, WebResult<List<DrawOrder>> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = drawOrderMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setWebData(drawOrderMapper.selectByPage(layUiAuToReq));
            result.setTotal(totallNumAll);
        }else{
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }
    }
    @Transactional
    public void updaDrawMapper(DrawOrder drawOrder, WebResult result){
        if(!drawOrder.getDrawStatus().equals(0)){
            DrawOrder order = drawOrderMapper.selectById(drawOrder.getDrawId());
            if(order==null){
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.DATA_NULL);
            }else {
                if(order.getDrawStatus().equals(0)){
                    if(!StringTool.isRealStr(drawOrder.getTradeDes())){
                        drawOrder.setTradeDes(order.getTradeDes());
                    }
                    if(drawOrder.getDrawStatus().equals(2)){
                        drawOrder.setBankStatus(1);
                    }
                    int re = drawOrderMapper.updateDrawOrderStatus(drawOrder);
                    if(re!=1){
                        result.setCode(Constants.ERROR_CODE);
                        result.setMessage(Constants.FILE_MSG);
                    }else {
                        //提现申请失败，账户余额增加
                        if(drawOrder.getDrawStatus().equals(2)){
                            userBankMapper.addNowMoney(order.getAmount(),order.getBankId());
                        }
                    }
                }else {
                    result.setCode(Constants.ERROR_CODE);
                    result.setMessage(Constants.FILE_MSG);
                }
            }
        }

    }

    public void seleById(Integer drawId, WebResult<DrawOrder> result){
        DrawOrder drawOrder = drawOrderMapper.selectById(drawId);
        if(drawOrder==null){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.DATA_NULL);
        }else {
            result.setWebData(drawOrder);
        }
    }


}
