package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.model.DrawOrder;
import com.ant.app.model.SysOrder;
import com.ant.app.sql.LayuiAutoPageSql;
import com.ant.app.sql.ReqListSql;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/9/17
 */
@Repository
public interface SysOrderMapper {

    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<SysOrder> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);

    @Select("SELECT SUM(totalFee) FROM sys_order WHERE tradeStatus=0 AND buyType=1")
    Integer countAllIncome();

    @Select("SELECT SUM(totalFee) FROM sys_order WHERE tradeStatus=0 AND buyType=1 AND cTime>#{sTime} AND cTime<#{eTime}")
    Integer countYetIncome(@Param("sTime")String sTime, @Param("eTime")String eTime);

}
