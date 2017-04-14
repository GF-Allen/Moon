package com.alenbeyond.moon.base.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 *
 * Created by allen on 2017/4/12.
 */

public interface IBaseView {

    void showMessage(@NonNull String message);


    void showMessage(@StringRes int messageId);

    void showProgressDialog(String title, String message);

    void showProgressDialog(String title, String message, boolean canCancel, boolean canCancelTouchOustSide);

    void dismissProgressDialog();

    /**
     * 获得Context
     */
    Context getContext();
}
