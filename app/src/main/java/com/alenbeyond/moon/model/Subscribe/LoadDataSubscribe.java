package com.alenbeyond.moon.model.Subscribe;

import com.alenbeyond.moon.base.view.ILoadDataView;

import rx.Subscriber;

/**
 * Created by Allen on 2017/4/18.
 */

public abstract class LoadDataSubscribe<T> extends Subscriber<T> {
    private ILoadDataView mView;

    public LoadDataSubscribe(ILoadDataView view) {
        this.mView = view;
    }

    @Override
    public void onStart() {
//        mView.showLoading();
    }

    @Override
    public void onCompleted() {
        mView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        mView.showMessage(e.getMessage());
        mView.hideLoading();
        _onError(e);
    }

    @Override
    public void onNext(T result) {
        _onSuccess(result);
    }

    public abstract void _onSuccess(T t);

    public void _onError(Throwable e) {

    }
}
