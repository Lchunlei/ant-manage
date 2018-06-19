package com.ant.app.entity.req;

public class FindBanner {
    private String channelId;

    @Override
    public String toString() {
        return "FindBanner{" +
                "channelId='" + channelId + '\'' +
                '}';
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
