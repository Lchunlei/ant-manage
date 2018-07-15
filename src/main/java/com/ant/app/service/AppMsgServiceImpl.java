package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.AppMsgMapper;
import com.ant.app.model.AppMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Service
public class AppMsgServiceImpl {

    @Autowired
    AppMsgMapper appMsgMapper;

    public void inseAppMsg(AppMsg appMsg, WebResult result){
        int i = appMsgMapper.insertAppMsg(appMsg);
        if(i!=1){
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }
    }


}
