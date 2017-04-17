package com.alenbeyond.moon.base.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by allen on 2017/4/11.
 */
public abstract class BaseFragment extends Fragment implements IBaseView {

    private ProgressDialog mProgressDialog;
    private Toast mToast;
    public Context mContext;
    private Unbinder unbinder;

    protected boolean isVisible;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    protected View createView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @LayoutRes int layoutId) {
        final View fragmentView = inflater.inflate(layoutId, container, false);
        unbinder = ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {

    }


    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    @Override
    public void showProgressDialog(String title, String message, boolean canCancel, boolean canCancelTouchOustSide) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
        }
        mProgressDialog.setTitle(title);
        mProgressDialog.setMessage(message);
        mProgressDialog.setCancelable(canCancel);
        mProgressDialog.setCanceledOnTouchOutside(canCancelTouchOustSide);
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void showProgressDialog(String title, String message) {
        showProgressDialog(title, message, false, false);
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    protected void showToastMessage(String message) {
        if (!TextUtils.isEmpty(message)) {
            if (mToast == null) {
                mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
            }
            mToast.setText(message);
            mToast.show();
        }
    }

    protected void showToastMessage(@StringRes int messageId) {
        if (messageId != 0) {
            String message = mContext.getResources().getString(messageId);
            showToastMessage(message);
        }
    }

    @Override
    public void showMessage(@NonNull String message) {
        showToastMessage(message);
    }

    @Override
    public void showMessage(@StringRes int StringRes) {
        showToastMessage(StringRes);
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    protected void changeTitle(String title) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).changeTitle(title);
        }
    }

    protected void changeTitle(@StringRes int title) {
        if (getActivity() instanceof BaseActivity) {
            String string = getActivity().getString(title);
            ((BaseActivity) getActivity()).changeTitle(string);
        }
    }

}
