package com.alenbeyond.moon.model.netadpi;

import com.alenbeyond.moon.model.bean.Channel;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by AlenBeyond on 2017/4/14.
 */

public interface ServiceApi {
    @GET("/splash/splash.api")
    Observable<Response<Channel>> getChannel();
}
