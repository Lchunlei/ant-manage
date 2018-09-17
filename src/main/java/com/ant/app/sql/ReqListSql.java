package com.ant.app.sql;

import com.ant.app.entity.req.ReqList;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author lchunlei
 * @date 2018/7/11
 */
public class ReqListSql {

    public String reqList(ReqList reqList){
        return new SQL() {
            {
                SELECT("*");
                FROM(reqList.getTableName());
                if(reqList.getSeleTime()!=null) {
                    WHERE("createTime>#{stime}");
                }
                if(reqList.getReqId()!=null) {
                    WHERE(reqList.getColumnId()+"=#{reqId}");
                }
                if(reqList.getReqName()!=null) {
                    WHERE(reqList.getColumnName()+" LIKE CONCAT('%', #{reqName},'%')");
                }
            }
        }.toString()+ " ORDER BY "+reqList.getColumnSort()+" DESC"+" limit" + " #{startNum},#{pageSize}";
    }

    public String reqListTotal(ReqList reqList){
        return new SQL() {
            {
                SELECT("COUNT("+reqList.getTableKey()+")");
                FROM(reqList.getTableName());
                if(reqList.getStime()!=null) {
                    WHERE("createTime>#{stime}");
                }
                if(reqList.getReqId()!=null) {
                    WHERE(reqList.getColumnId()+"=#{reqId}");
                }
                if(reqList.getReqName()!=null) {
                    WHERE(reqList.getColumnName()+" LIKE CONCAT('%', #{reqName},'%')");
                }
            }
        }.toString();
    }
}
