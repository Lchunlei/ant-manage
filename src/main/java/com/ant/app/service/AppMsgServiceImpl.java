package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.resp.LayUiResult;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.AppMsgMapper;
import com.ant.app.mapper.UserMapper;
import com.ant.app.model.AppMsg;
import com.ant.app.model.UserInfo;
import com.ant.app.util.CheckReqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Service
public class AppMsgServiceImpl {

    @Autowired
    AppMsgMapper appMsgMapper;
    @Autowired
    UserMapper userMapper;

    public void inseAppMsg(AppMsg appMsg, WebResult result){
        if(appMsg.getMsgType().equals(1)){
            if(CheckReqUtil.isNumber(appMsg.getUserId().toString())){
                UserInfo userInfo = userMapper.selectByiD(appMsg.getUserId());
                if(userInfo==null){
                    result.setCode(Constants.ERROR_CODE);
                    result.setMessage(Constants.DATA_NULL);
                    return;
                }else {
                    appMsg.setNickName(userInfo.getNickName());
                }
            }else {
                result.setCode(Constants.ERROR_CODE);
                result.setMessage(Constants.PARAM_ERROR);
                return;
            }
        }else {
            appMsg.setUserId(null);
            appMsg.setNickName(null);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(appMsg.getpTimer());
            appMsg.setPushtime(date);
        } catch (ParseException e) {
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.PARAM_ERROR);
            return;
        }
        int i = appMsgMapper.insertAppMsg(appMsg);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }

    public void getList(LayUiAuToReq layUiAuToReq, LayUiResult<AppMsg> result){
        layUiAuToReq.setStartNum((layUiAuToReq.getPage()-1)*10);
        Integer totallNumAll = appMsgMapper.selectTotallNum(layUiAuToReq);
        if(totallNumAll>0){
            result.setData(appMsgMapper.selectByPage(layUiAuToReq));
            result.setCount(totallNumAll);
            result.setMsg(Constants.SUCCESS_MSG);
            result.setCode(Constants.PAGE_OK_CODE);
        }else{
            result.setMsg(Constants.NOT_MORE_INFO);
            result.setCode(Constants.PAGE_ERROR_CODE);
        }
    }

}
