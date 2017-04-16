package com.alenbeyond.moon.module.main.model;

import com.alenbeyond.moon.MoonApp;
import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.module.main.bean.DiscoverChannel;

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

    public Observable<DiscoverChannel> getChannel() {
        return MoonApp.getRetrofitClient().getServiceApi().getChannel()
                .flatMap(new Func1<Response<Channel>, Observable<Channel>>() {
                    @Override
                    public Observable<Channel> call(Response<Channel> response) {
                        if (response.code() == 200) {
                            return Observable.just(response.body());
                        }
                        return null;
                    }
                })
                .map(new Func1<Channel, DiscoverChannel>() {
                    @Override
                    public DiscoverChannel call(Channel channel) {
                        DiscoverChannel discoverChannel = new DiscoverChannel();
                        List<Channel.ChannelListBean.ChannelBeans> list = channel.getChannelListBean().getChannelBeans();
                        String[] titles = new String[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            titles[i] = list.get(i).getChannelName();
                        }
                        discoverChannel.setChannels(list);
                        discoverChannel.setTitles(titles);
                        return discoverChannel;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
