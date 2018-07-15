package com.ant.app.mapper;

import com.ant.app.model.SysIncome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author lchunlei
 * @date 2018/7/12
 */
@Repository
public interface SysIncomeMapper {

    @Insert("INSERT INTO sys_income(`incomeId`, `income`,`output`,`endId`,`updateTime`) VALUES (1,${income},${output},${endId},NOW())")
    Integer insertIncome(SysIncome sysIncome);

    @Select("SELECT * FROM sys_income WHERE incomeId=1")
    SysIncome selectIncome();

    @Update("UPDATE sys_income SET income=${income},output=${output},endId=${endId},updateTime=NOW() WHERE incomeId=1")
    int updateIncome(SysIncome sysIncome);


}
