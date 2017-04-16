package com.alenbeyond.moon.module.main.bean;

import com.alenbeyond.moon.model.bean.Channel;

import java.util.List;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverChannel {
    private String[] titles;

    private List<Channel.ChannelListBean.ChannelBeans> channels;

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public List<Channel.ChannelListBean.ChannelBeans> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel.ChannelListBean.ChannelBeans> channels) {
        this.channels = channels;
    }
}
