package com.alenbeyond.moon.model;

import com.alenbeyond.moon.base.presenter.BaseLoadDataPresenter;
import com.alenbeyond.moon.base.view.ILoadDataView;

import rx.Subscriber;

/**
 * Created by Allen on 2017/4/18.
 */

public abstract class LoadDataSubscribe<T> extends Subscriber<T> {
    private BaseLoadDataPresenter mPresenter;
    private ILoadDataView mView;

    public LoadDataSubscribe(BaseLoadDataPresenter presenter, ILoadDataView view) {
        this.mView = view;
        this.mPresenter = presenter;
    }

    @Override
    public void onStart() {
        mView.showLoading();
    }

    @Override
    public void onCompleted() {
        mView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
        mView.showMessage(e.getMessage());
        mView.hideLoading();
    }

    @Override
    public void onNext(T result) {
        mPresenter.mRefreshTime = System.currentTimeMillis();
        onJesNext(result);
    }

    public abstract void onJesNext(T t);
}
