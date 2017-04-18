package com.alenbeyond.moon.base.presenter;

import android.support.annotation.NonNull;

import com.alenbeyond.moon.base.view.IBaseView;
import com.alenbeyond.moon.constants.Constants;

import rx.subscriptions.CompositeSubscription;

/**
 * 在此写用途
 * 辅助presenter类，实现一些通用的方法（不涉及加载数据）
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    //上一次刷新时间
    public long mRefreshTime;

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

    /**
     * 是否需要加载数据
     *
     * @param loadMore 加载更多
     * @return
     */
    protected boolean isNeedLoadData( boolean loadMore) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!loadMore && (currentTimeMillis - mRefreshTime) < Constants.EXPIRATION_2) {
            return false;
        }
        return true;
    }

    public void unSubscribe() {
        mSubscriptions.unsubscribe();
    }
}
