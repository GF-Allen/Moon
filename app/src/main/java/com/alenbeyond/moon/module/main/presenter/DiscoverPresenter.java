package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BasePresenter;
import com.alenbeyond.moon.module.main.bean.DiscoverChannel;
import com.alenbeyond.moon.module.main.contract.DiscoverContract;
import com.alenbeyond.moon.module.main.model.DiscoverModel;

import rx.Subscriber;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverContract.View> implements DiscoverContract.Presenter<DiscoverContract.View> {

    @Override
    public void unSubscribe() {
        mSubscriptions.unsubscribe();
    }

    @Override
    public void getChannel() {
        DiscoverModel.getInstance().getChannel()
                .subscribe(new Subscriber<DiscoverChannel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DiscoverChannel channel) {
                        mView.showChannel(channel);
                    }
                });
    }
}
