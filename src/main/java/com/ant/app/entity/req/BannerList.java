package com.ant.app.entity.req;

/**
 * @author lchunlei
 * @date 2018/7/6
 */
public class BannerList {
    private Integer pageNum;
    private Integer pageSize;
    private Integer channelId;//轮播图位置

    @Override
    public String toString() {
        return "BannerList{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", channelId=" + channelId +
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

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }
}
