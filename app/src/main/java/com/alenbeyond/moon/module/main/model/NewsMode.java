package com.alenbeyond.moon.module.main.model;

import com.alenbeyond.moon.MoonApp;
import com.alenbeyond.moon.model.bean.News;

import rx.Observable;

/**
 * Created by Allen on 2017/4/17.
 */

public class NewsMode {
    private static NewsMode sNewsModel;

    public static NewsMode getInstance() {
        if (sNewsModel == null) {
            sNewsModel = new NewsMode();
        }
        return sNewsModel;
    }

    public Observable<News> getNewsByChannel(int channel, int fromNewsId) {
        return MoonApp.getRetrofitClient().getServiceApi().getNewsByChannel(channel, fromNewsId);
    }
}
