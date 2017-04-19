package com.alenbeyond.moon.model.netapi;

import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.model.bean.News;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by AlenBeyond on 2017/4/14.
 */

public interface ServiceApi {
    /**
     * 获取分类Id
     *
     * @return
     */
    @GET("/splash/splash.api")
    Observable<Channel> getChannel();

    /**
     * 获取文章列表
     *
     * @param channel    分类Id
     * @param fromNewsId 上一次最后一条的Id，加载更多
     * @return
     */
    @GET("/news/newsList.api")
    Observable<News> getNewsByChannel(@Query("channel") int channel, @Query("fromNewsId") int fromNewsId);
}
