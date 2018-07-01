package com.ant.app.entity.req;

/**
 * Created by sfb_liuchunlei on 2018/6/23.
 */
public class UserList {
    private Integer pageNum;
    private Integer pageSize;
    private Integer joinTime;

    @Override
    public String toString() {
        return "UserList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", joinTime=" + joinTime +
                '}';
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

    public Integer getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Integer joinTime) {
        this.joinTime = joinTime;
    }
}
