package com.ant.app.service;

import com.ant.app.entity.resp.WebResult;
import com.ant.app.entity.resp.WelcomeInit;
import com.ant.app.mapper.SysIncomeMapper;
import com.ant.app.mapper.TaskMapper;
import com.ant.app.mapper.UserBillMapper;
import com.ant.app.mapper.UserMapper;
import com.ant.app.model.SysIncome;
import com.ant.app.util.MoneyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lchunlei
 * @date 2018/10/19
 */
@Service
public class WebInitServiceImpl {
    private static WelcomeInit init = new WelcomeInit();
    @Autowired
    SysIncomeMapper sysIncomeMapper;
    @Autowired
    UserBillMapper userBillMapper;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserMapper userMapper;

    public void initWeb(WebResult<WelcomeInit> result){
        result.setWebData(init);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = format.format(new Date());
        if(!nowTime.equals(init.getuTime())){
            //数据已经过期，更新数据
            init.setTotalIncome(MoneyUtil.FenTurnYuan(userBillMapper.countAllIncome()+""));

            String yetTime = format.format(new Date().getTime()-24*60*60*1000);
            String sTime = yetTime+" 00:00:00";
            String eTime = yetTime+" 23:59:59";
            init.setNewTaskNum(taskMapper.findNewTaskNum(sTime,eTime));
            init.setNewUserNum(userMapper.selectNewUserNum(sTime,eTime));
            init.setYestIncome(MoneyUtil.FenTurnYuan(userBillMapper.countYetIncome(sTime,eTime)+""));
            init.setuTime(nowTime);
        }
    }

}
