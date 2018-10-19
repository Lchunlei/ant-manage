package com.ant.app.mapper;

import com.ant.app.model.Banner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/5
 */
@Repository
public interface UserBankMapper {

    @Update("UPDATE user_bank SET nowMoney=nowMoney+${nowMoney},uTime=NOW() WHERE bankId=${bankId}")
    int addNowMoney(@Param("nowMoney")Integer nowMoney,@Param("bankId")Integer bankId);


}
