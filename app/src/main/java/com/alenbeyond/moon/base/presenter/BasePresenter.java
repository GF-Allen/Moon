package com.alenbeyond.moon.base.presenter;

import android.support.annotation.NonNull;

import com.alenbeyond.moon.base.view.IBaseView;

import rx.subscriptions.CompositeSubscription;

/**
 * 在此写用途
 * 辅助presenter类，实现一些通用的方法（不涉及加载数据）
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;
    protected CompositeSubscription mSubscriptions;//包装所有的订阅者，便于做生命周期的管理

    protected BasePresenter() {
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void attachView(@NonNull V view) {
        this.mView = view;
    }

    @Override
    public void showErrorMessage(String error) {
        mView.showMessage(error);
    }

    @Override
    public void detachView() {
        unSubscribe();
        this.mView = null;
    }

    public void unSubscribe() {
        mSubscriptions.unsubscribe();
    }
}
