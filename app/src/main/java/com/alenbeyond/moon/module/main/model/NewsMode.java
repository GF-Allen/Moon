package com.alenbeyond.moon.module.main.model;

import com.alenbeyond.moon.MoonApp;
import com.alenbeyond.moon.model.bean.News;

import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
        return MoonApp.getRetrofitClient().getServiceApi().getNewsByChannel(channel, fromNewsId)
                .flatMap(new Func1<Response<News>, Observable<News>>() {
                    @Override
                    public Observable<News> call(Response<News> response) {
                        if (response.isSuccessful()) {
                            return Observable.just(response.body());
                        }
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
