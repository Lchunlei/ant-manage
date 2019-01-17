package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.model.AppVersion;
import com.ant.app.sql.LayuiAutoPageSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/11/9
 */
@Repository
public interface VersionMapper {

    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<AppVersion> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);

    @Insert("INSERT INTO app_version(`verisonName`, `platform`,`downloadUrl`,`updateMsg`,`createTime`) VALUES (#{verisonName},${platform},#{downloadUrl},#{updateMsg},NOW())")
    Integer insertAppVer(AppVersion appVersion);

    @Select("SELECT * FROM app_version WHERE verisonName=#{verisonName}")
    AppVersion selectAppver(@Param("verisonName")String verisonName);


}
