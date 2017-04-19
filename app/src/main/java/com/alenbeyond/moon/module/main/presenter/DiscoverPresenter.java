package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BasePresenter;
import com.alenbeyond.moon.model.Subscribe.MoonSubscribe;
import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.module.main.contract.DiscoverContract;
import com.alenbeyond.moon.module.main.model.DiscoverModel;

import java.util.List;

import rx.Subscription;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverContract.View> implements DiscoverContract.Presenter {

    @Override
    public void getChannel() {
        Subscription subscribe = DiscoverModel.getInstance().getChannel()
                .subscribe(new MoonSubscribe<List<Channel.ChannelListBean.ChannelBeans>>(mView) {
                    @Override
                    public void _onSuccess(List<Channel.ChannelListBean.ChannelBeans> channels) {
                        if (channels != null && channels.size() > 0) {
                            mView.showChannel(channels);
                        } else {
                            mView.showMessage("获取数据失败");
                        }
                    }
                });
        mSubscriptions.add(subscribe);
    }
}
