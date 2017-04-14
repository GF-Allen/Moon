package com.alenbeyond.moon.base.presenter;

import com.alenbeyond.moon.base.view.IBaseView;

/**
 *
 * Created by allen on 2017/4/11.
 */
public interface IBasePresenter<V extends IBaseView> {
    void attachView(V view);

    void detachView();

    void showErrorMessage(String error);
}
