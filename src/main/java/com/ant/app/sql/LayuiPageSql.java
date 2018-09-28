package com.ant.app.sql;

import com.ant.app.entity.req.LayuiPageReq;
import com.ant.app.entity.req.ReqList;
import com.ant.app.util.StringTool;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lchunlei
 * @date 2018/9/27
 */
public class LayuiPageSql {

    public String reqList(LayuiPageReq reqList){
        return new SQL() {
            {
                SELECT("*");
                FROM(reqList.getTableName());
                if(StringTool.isRealStr(reqList.getSearchValue())) {
                    WHERE(reqList.getSeleName()+" LIKE CONCAT('%', #{searchValue},'%')");
                }
                if(StringTool.isRealStr(reqList.getsDate())&&StringTool.isRealStr(reqList.geteDate())) {
                    WHERE(reqList.getSeleTime()+">#{sDate} AND "+reqList.getSeleTime()+"<#{eDate}");
                }
            }
        }.toString()+ " ORDER BY "+reqList.getTableSort()+" DESC"+" limit" + " #{startNum},10";
    }

    public String reqListTotal(LayuiPageReq reqList){
        return new SQL() {
            {
                SELECT("COUNT("+reqList.getTableKey()+")");
                FROM(reqList.getTableName());
                if(StringTool.isRealStr(reqList.getSearchValue())) {
                    WHERE(reqList.getSeleName()+" LIKE CONCAT('%', #{searchValue},'%')");
                }
                if(StringTool.isRealStr(reqList.getsDate())&&StringTool.isRealStr(reqList.geteDate())) {
                    WHERE(reqList.getSeleTime()+">#{sDate} AND "+reqList.getSeleTime()+"<#{eDate}");
                }
            }
        }.toString();
    }

}
