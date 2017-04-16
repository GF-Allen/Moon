package com.alenbeyond.moon.model.bean;

import java.util.List;

/**
 * Created by AlenBeyond on 2017/4/14.
 */

public class Channel {

    private ChannelListBean channelListBean;


    public ChannelListBean getChannelListBean() {
        return channelListBean;
    }

    public void setChannelListBean(ChannelListBean channelListBean) {
        this.channelListBean = channelListBean;
    }

    public static class ChannelListBean {
        private List<ChannelBeans> channelBeans;

        public List<ChannelBeans> getChannelBeans() {
            return channelBeans;
        }

        public void setChannelBeans(List<ChannelBeans> channelBeans) {
            this.channelBeans = channelBeans;
        }

        public static class ChannelBeans {

            private int channel;
            private String channelName;
            private String simpleName;

            public int getChannel() {
                return channel;
            }

            public void setChannel(int channel) {
                this.channel = channel;
            }

            public String getChannelName() {
                return channelName;
            }

            public void setChannelName(String channelName) {
                this.channelName = channelName;
            }

            public String getSimpleName() {
                return simpleName;
            }

            public void setSimpleName(String simpleName) {
                this.simpleName = simpleName;
            }
        }
    }
}
