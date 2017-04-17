package com.alenbeyond.moon.module.main.model;

import com.alenbeyond.moon.MoonApp;
import com.alenbeyond.moon.model.bean.Channel;

import java.util.List;

import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by AlenBeyond on 2017/4/14.
 */

public class DiscoverModel {

    private static DiscoverModel sDiscoverModel;

    public static DiscoverModel getInstance() {
        if (sDiscoverModel == null) {
            sDiscoverModel = new DiscoverModel();
        }
        return sDiscoverModel;
    }

    public Observable<List<Channel.ChannelListBean.ChannelBeans>> getChannel() {
        return MoonApp.getRetrofitClient().getServiceApi().getChannel()
                .flatMap(new Func1<Response<Channel>, Observable<Channel>>() {
                    @Override
                    public Observable<Channel> call(Response<Channel> response) {
                        if (response.isSuccessful()) {
                            return Observable.just(response.body());
                        }
                        return null;
                    }
                })
                .map(new Func1<Channel, List<Channel.ChannelListBean.ChannelBeans>>() {
                    @Override
                    public List<Channel.ChannelListBean.ChannelBeans> call(Channel channel) {
                        return channel.getChannelListBean().getChannelBeans();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
