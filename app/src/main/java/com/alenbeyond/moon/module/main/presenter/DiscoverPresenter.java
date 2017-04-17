package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BasePresenter;
import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.module.main.contract.DiscoverContract;
import com.alenbeyond.moon.module.main.model.DiscoverModel;

import java.util.List;

import rx.Subscriber;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverContract.View> implements DiscoverContract.Presenter<DiscoverContract.View> {

    @Override
    public void getChannel() {
        DiscoverModel.getInstance().getChannel()
                .subscribe(new Subscriber<List<Channel.ChannelListBean.ChannelBeans>>() {

                    @Override
                    public void onStart() {
                        mView.showProgressDialog(null, "加载中");
                    }

                    @Override
                    public void onCompleted() {
                        mView.dismissProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.dismissProgressDialog();
                        mView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Channel.ChannelListBean.ChannelBeans> channels) {
                        mView.showChannel(channels);
                    }
                });
    }
}
