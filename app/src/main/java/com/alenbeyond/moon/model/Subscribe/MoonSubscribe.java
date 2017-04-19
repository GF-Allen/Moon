package com.alenbeyond.moon.model.Subscribe;

import com.alenbeyond.moon.base.view.IBaseView;

import rx.Subscriber;

/**
 * Created by Allen on 2017/4/14.
 */

public abstract class MoonSubscribe<T> extends Subscriber<T> {

    private IBaseView mView;

    public MoonSubscribe(IBaseView view) {
        this.mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        mView.showMessage(e.getMessage());
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
