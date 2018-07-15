package com.ant.app.entity.req;

/**
 * Created by liuchunlei on 2018/6/23.
 */
public class UserList {
    private Integer pageNum;
    private Integer pageSize;
    private Integer seleTime;//过滤时间段
    private String nameOrId;//按名称和ID查询

    @Override
    public String toString() {
        return "UserList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", seleTime='" + seleTime + '\'' +
                ", nameOrId='" + nameOrId + '\'' +
                '}';
    }

    public Integer getSeleTime() {
        return seleTime;
    }

    public void setSeleTime(Integer seleTime) {
        this.seleTime = seleTime;
    }

    public String getNameOrId() {
        return nameOrId;
    }

    public void setNameOrId(String nameOrId) {
        this.nameOrId = nameOrId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
