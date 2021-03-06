package com.ant.app.mapper;

import com.ant.app.entity.req.LayUiAuToReq;
import com.ant.app.model.Banner;
import com.ant.app.model.DrawOrder;
import com.ant.app.sql.LayuiAutoPageSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lchunlei
 * @date 2018/7/5
 */
@Repository
public interface BannerMapper {

    @Insert("INSERT INTO sys_banner(`title`, `imgUrl`,`actionUrl`,`channelId`,`createTime`) VALUES (#{title}, #{imgUrl},#{actionUrl},${channelId},NOW())")
    Integer insertBanner(Banner banner);

    @Delete("DELETE FROM sys_banner WHERE bannerId=${bannerId}")
    Integer deleteBanner(@Param("bannerId")Integer bannerId);

    @Update("UPDATE sys_banner SET title=#{title},actionUrl=#{actionUrl},channelId=${channelId},createTime=NOW() WHERE bannerId=${bannerId}")
    int updateBanner(Banner banner);

    @Select("SELECT * FROM sys_banner limit ${startNum},${pageSize}")
    List<Banner> selectBypage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);
    @Select("SELECT COUNT(bannerId) FROM sys_banner")
    int selecttotallNum();

    @Select("SELECT * FROM sys_banner WHERE bannerId=${bannerId}")
    Banner selectById(@Param("bannerId")Integer bannerId);

    @SelectProvider(type=LayuiAutoPageSql.class, method="reqList")
    List<Banner> selectByPage(LayUiAuToReq layUiAuToReq);
    @SelectProvider(type=LayuiAutoPageSql.class, method="reqListTotal")
    Integer selectTotallNum(LayUiAuToReq layUiAuToReq);



}
