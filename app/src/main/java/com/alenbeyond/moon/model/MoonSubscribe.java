package com.alenbeyond.moon.model;

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
        mView.showProgressDialog(null, "");
    }

    @Override
    public void onCompleted() {
        mView.dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        mView.showMessage(e.getMessage());
        mView.dismissProgressDialog();
    }

    @Override
    public void onNext(T result) {
        onJesNext(result);
//        if (result.getCode() == 10000) {
//            onJesNext(result.getT());
//        } else {
//            KLog.d(result.getMsg());
//            onError(new Throwable(result.getMsg()));
//        }
    }

    public abstract void onJesNext(T t);

}
