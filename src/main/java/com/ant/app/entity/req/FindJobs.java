package com.ant.app.entity.req;

public class FindJobs {
    private Integer userId;
    private Integer pageCount;
    private Integer pageNumber;

    @Override
    public String toString() {
        return "FindJobs{" +
                "userId=" + userId +
                ", pageCount=" + pageCount +
                ", pageNumber=" + pageNumber +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
