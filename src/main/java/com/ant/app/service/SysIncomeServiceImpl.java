package com.ant.app.service;

import com.ant.app.Constants;
import com.ant.app.entity.resp.WebResult;
import com.ant.app.mapper.SysIncomeMapper;
import com.ant.app.mapper.UserBillMapper;
import com.ant.app.model.SysIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/7/12
 */
@Service
public class SysIncomeServiceImpl {
    @Autowired
    SysIncomeMapper sysIncomeMapper;
    @Autowired
    UserBillMapper userBillMapper;

    //查看平台总收入
    public void lookIncome(WebResult result){
        SysIncome income = sysIncomeMapper.selectIncome();
        if(income==null){
            //重新统计所有bill，然后记录
            income = new SysIncome();
            Integer maxId = userBillMapper.getMaxId();
            if(maxId==null){
                income.setIncome(0);
                income.setOutput(0);
                income.setEndId(0);
            }else {
                //包括区间端点值
                int sincome = userBillMapper.countIncome(maxId,1);
                int soutput = userBillMapper.countOutput(maxId,1);
                income.setIncome(sincome);
                income.setOutput(soutput);
                income.setEndId(maxId);
            }
            sysIncomeMapper.insertIncome(income);
            result.setWebData(income);

        }else {
            result.setWebData(income);

        }
    }

    //更新平台收入
    public void updaIncome(WebResult result){
        SysIncome income = sysIncomeMapper.selectIncome();
        Integer maxId = userBillMapper.getMaxId();
        int sincome = userBillMapper.countIncome(maxId,income.getEndId()+1);
        int soutput = userBillMapper.countOutput(maxId,income.getEndId()+1);
        income.setIncome(sincome+income.getIncome());
        income.setOutput(soutput+income.getOutput());
        income.setEndId(maxId);
        Integer i = sysIncomeMapper.updateIncome(income);
        if(i==1){
            income.setUpdateTime(new Date());
            result.setWebData(income);
        }else {
            result.setCode(Constants.ERROR_CODE);
            result.setMessage(Constants.FILE_MSG);
        }

    }

}
