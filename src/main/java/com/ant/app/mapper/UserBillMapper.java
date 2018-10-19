package com.ant.app.mapper;

import com.ant.app.entity.req.ReqList;
import com.ant.app.model.SysTask;
import com.ant.app.model.UserBill;
import com.ant.app.sql.ReqListSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
@Repository
public interface UserBillMapper {

    @SelectProvider(type=ReqListSql.class, method="reqList")
    List<UserBill> selectBypage(ReqList reqList);
    @SelectProvider(type=ReqListSql.class, method="reqListTotal")
    int selecttotallNum(ReqList reqList);

    @Select("SELECT SUM(amount) FROM user_bill WHERE billStatus=0 AND billType=1 AND billid BETWEEN ${starId} AND ${endId}")
    int countIncome(@Param("endId")Integer endId,@Param("starId")Integer starId);

    @Select("SELECT SUM(amount) FROM user_bill WHERE billStatus=0 AND billType=1")
    Integer countAllIncome();

    @Select("SELECT SUM(amount) FROM user_bill WHERE billStatus=0 AND billType=2 AND billid BETWEEN ${starId} AND ${endId}")
    int countOutput(@Param("endId")Integer endId,@Param("starId")Integer starId);

    @Select("SELECT SUM(amount) FROM user_bill WHERE billStatus=0 AND billType=2 AND createTime>#{sTime} AND createTime<#{eTime}")
    Integer countYetIncome(@Param("sTime")String sTime, @Param("eTime")String eTime);

    @Select("SELECT MAX(billid) FROM user_bill")
    Integer getMaxId();

    //查询提现申请列表
    @Select("SELECT * FROM user_bill WHERE billStatus=1 AND billType=2 limit ${startNum},${pageSize}")
    List<UserBill> selectTXBypage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);
    @Select("SELECT COUNT(billid) FROM user_bill WHERE billStatus=1 AND billType=2")
    int selectTXtotallNum();


}
