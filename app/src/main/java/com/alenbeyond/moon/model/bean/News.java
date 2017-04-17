package com.alenbeyond.moon.model.bean;

import java.util.List;

/**
 * Created by Allen on 2017/4/17.
 */

public class News {

    private List<NewsListBean> newsList;

    public List<NewsListBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListBean> newsList) {
        this.newsList = newsList;
    }

    public static class NewsListBean {

        private AuthorBeanBean authorBean;
        private NewsBeanBean newsBean;

        public AuthorBeanBean getAuthorBean() {
            return authorBean;
        }

        public void setAuthorBean(AuthorBeanBean authorBean) {
            this.authorBean = authorBean;
        }

        public NewsBeanBean getNewsBean() {
            return newsBean;
        }

        public void setNewsBean(NewsBeanBean newsBean) {
            this.newsBean = newsBean;
        }

        public static class AuthorBeanBean {

            private int allNum;
            private String authInfo;
            private String authorUrl;
            private int channel;
            private String channelName;
            private String headUrl;
            private int id;
            private String name;
            private int newNum;
            private int postTime;
            private int readAll;
            private String summary;
            private boolean vip;
            private String wxhao;
            private int zhanAll;

            public int getAllNum() {
                return allNum;
            }

            public void setAllNum(int allNum) {
                this.allNum = allNum;
            }

            public String getAuthInfo() {
                return authInfo;
            }

            public void setAuthInfo(String authInfo) {
                this.authInfo = authInfo;
            }

            public String getAuthorUrl() {
                return authorUrl;
            }

            public void setAuthorUrl(String authorUrl) {
                this.authorUrl = authorUrl;
            }

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

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNewNum() {
                return newNum;
            }

            public void setNewNum(int newNum) {
                this.newNum = newNum;
            }

            public int getPostTime() {
                return postTime;
            }

            public void setPostTime(int postTime) {
                this.postTime = postTime;
            }

            public int getReadAll() {
                return readAll;
            }

            public void setReadAll(int readAll) {
                this.readAll = readAll;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public boolean isVip() {
                return vip;
            }

            public void setVip(boolean vip) {
                this.vip = vip;
            }

            public String getWxhao() {
                return wxhao;
            }

            public void setWxhao(String wxhao) {
                this.wxhao = wxhao;
            }

            public int getZhanAll() {
                return zhanAll;
            }

            public void setZhanAll(int zhanAll) {
                this.zhanAll = zhanAll;
            }
        }

        public static class NewsBeanBean {
            /**
             * authorId : 542
             * channel : 263
             * channelName : 团队号
             * coverUrl : http://mmbiz.qpic.cn/mmbiz_png/No0P3jZ7icBxwNGPRgfibe97WpVA1yMHoushUP0WFSZOurILOpIwRTTtgI9vh7TZg4dv5c2HbmnmZXbaNSA49sJA/0?wx_fmt=png
             * digest : 自二维码支付的地位得到央行首肯以来，银联大力拓展二维码支付领域，……
             * id : 477586
             * idx : 1
             * postTime : 1492002112
             * readNum : 29
             * shareUrl : http://www.10tiao.com/html/542/201704/2650920639/1.html
             * state : 1
             * title : 支持“银联二维码”应用名单列表（收藏）
             * type : 1
             * url : http://mp.weixin.qq.com/s?__biz=MjM5ODMxNzY0MA==&mid=2650920639&idx=1&sn=d7ae6c568b2279b973e111f0c8aada4c&chksm=bd39ed988a4e648ec3a78ccca508faebaf1b43765d6979e19d8ec3a62ccd5b04175061c363e1&scene=27#wechat_redirect
             * zanNum : 0
             */

            private int authorId;
            private int channel;
            private String channelName;
            private String coverUrl;
            private String digest;
            private int id;
            private int idx;
            private int postTime;
            private int readNum;
            private String shareUrl;
            private int state;
            private String title;
            private int type;
            private String url;
            private int zanNum;

            public int getAuthorId() {
                return authorId;
            }

            public void setAuthorId(int authorId) {
                this.authorId = authorId;
            }

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

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getDigest() {
                return digest;
            }

            public void setDigest(String digest) {
                this.digest = digest;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public int getPostTime() {
                return postTime;
            }

            public void setPostTime(int postTime) {
                this.postTime = postTime;
            }

            public int getReadNum() {
                return readNum;
            }

            public void setReadNum(int readNum) {
                this.readNum = readNum;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getZanNum() {
                return zanNum;
            }

            public void setZanNum(int zanNum) {
                this.zanNum = zanNum;
            }
        }
    }
}
