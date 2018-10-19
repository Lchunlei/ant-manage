package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.UserIncomeMapper;
import com.ant.app.model.NowIncome;
import com.ant.app.model.UserBank;
import com.ant.app.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/23
 */
@Service
public class UserIncomeServiceImpl {
    @Autowired
    UserIncomeMapper userIncomeMapper;


    public void getUbList(LayUiAuToReq layUiAuToReq, WebResult result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        List<UserBank> userBanks = userIncomeMapper.selectByPage(layUiAuToReq);
        if(userBanks.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userBanks);
            result.setTotal(userIncomeMapper.selectTotallNum(layUiAuToReq));
        }
    }

    public void getNowList(ReqList reqList, WebResult result){
        List<NowIncome> userBanks = userIncomeMapper.selectBypageNow(reqList);
        if(userBanks.size()==0){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.NOT_MORE_INFO);
        }else{
            result.setWebData(userBanks);
            result.setTotal(userIncomeMapper.selecttotallNumNow(reqList));
        }
    }



}
