package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.model.NowIncome;
import com.ant.app.model.SysTask;
import com.ant.app.model.UserBank;
import com.ant.app.sql.LayuiAutoPageSql;
import com.ant.app.sql.ReqListSql;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/23
 */
@Repository
public interface UserIncomeMapper {

    //用户个人账户列表
    @SelectProvider(type=ReqListSql.class, method="reqList")
    List<UserBank> selectBypageUB(ReqList reqList);
    @SelectProvider(type=ReqListSql.class, method="reqListTotal")
    int selecttotallNumUB(ReqList reqList);

    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<UserBank> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);

    //用户个人账户列表
    @SelectProvider(type=ReqListSql.class, method="reqList")
    List<NowIncome> selectBypageNow(ReqList reqList);
    @SelectProvider(type=ReqListSql.class, method="reqListTotal")
    int selecttotallNumNow(ReqList reqList);


}
