package com.alenbeyond.moon.base.view;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.utils.ToastUtils;
import com.alenbeyond.moon.utils.UiUtils;
import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;

/**
 * Created by allen on 2017/4/12.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected Context mContext;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    protected void createView(@LayoutRes int layoutId) {
        setContentView(layoutId);
        StatusBarUtil.setColor(this, ContextCompat.getColor(mContext, R.color.colorPrimary));
        ButterKnife.bind(this);
        UiUtils.getRootView(this).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
            }
        });
    }

    protected void addFragment(int containerViewId, Fragment fragment, String fragmentTag) {
        addFragment(containerViewId, fragment, fragmentTag, false);
    }

    protected void addFragment(int containerViewId, Fragment fragment, String fragmentTag, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(containerViewId, fragment, fragmentTag);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    /**
     * 初始化标题栏
     *
     * @param isBack
     * @param title
     */
    public void initTitleBar(boolean isBack, String title) {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(title);
        ImageButton ivBack = (ImageButton) findViewById(R.id.ib_back);
        if (isBack) {
            ivBack.setVisibility(View.VISIBLE);
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else {
            ivBack.setVisibility(View.GONE);
        }
    }

    /**
     * 自定义左侧按钮
     *
     * @param title
     * @param leftId
     * @param leftClickListener
     */
    public void initTitlrBar(String title, @DrawableRes int leftId, View.OnClickListener leftClickListener) {
        initTitleBar(true, title);
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);
        ll_right.removeAllViews();
        ImageButton ibBack = (ImageButton) findViewById(R.id.ib_back);
        ibBack.setBackgroundResource(leftId);
        if (leftClickListener != null) {
            ibBack.setOnClickListener(leftClickListener);
        }
    }

    /**
     * 初始化标题栏带右侧按钮
     *
     * @param isBack
     * @param title
     * @param rightId
     * @param rightClickListener
     */
    public void initTitleBar(boolean isBack, String title, @DrawableRes int rightId, View.OnClickListener rightClickListener) {
        initTitleBar(isBack, title);
        LinearLayout ll_right = (LinearLayout) findViewById(R.id.ll_right);
        ll_right.removeAllViews();
        ImageView right = new ImageView(this);
        right.setImageResource(rightId);
        ll_right.addView(right, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if (rightClickListener != null) {
            right.setOnClickListener(rightClickListener);
        }
    }

    /**
     * 初始化自定义左右按钮
     *
     * @param title
     * @param leftId
     * @param leftClickListener
     * @param rightId
     * @param rightClickListener
     */
    public void initTitleBar(String title, @DrawableRes int leftId, View.OnClickListener leftClickListener, @DrawableRes int rightId, View.OnClickListener rightClickListener) {
        initTitleBar(true, title, rightId, rightClickListener);
        ImageButton ibBack = (ImageButton) findViewById(R.id.ib_back);
        ibBack.setBackgroundResource(leftId);
        if (leftClickListener != null) {
            ibBack.setOnClickListener(leftClickListener);
        }
    }

    /**
     * 修改标题
     *
     * @param title
     */
    public void changeTitle(String title) {
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(title);
    }

    /**
     * 隐藏TitleBar
     */
    public void hideTitleBar() {
        LinearLayout titleBar = (LinearLayout) findViewById(R.id.title_bar);
        titleBar.setVisibility(View.GONE);
    }

    /**
     * 显示TitleBar
     */
    public void showTitleBar() {
        LinearLayout titleBar = (LinearLayout) findViewById(R.id.title_bar);
        titleBar.setVisibility(View.VISIBLE);
    }


    protected void startActivityNoValue(Context context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    protected ProgressDialog simpleProgeDialog(Context context, String msg) {
        ProgressDialog pd = new ProgressDialog(context);
        pd.setCanceledOnTouchOutside(true);
        pd.setCancelable(true);
        pd.setMessage(msg);
        return pd;
    }

    @Override
    public void showProgressDialog(String title, String message, boolean canCancel, boolean canCancelTouchOustSide) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
        }
        if (!TextUtils.isEmpty(title)) {
            mProgressDialog.setTitle(title);
        }
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
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 获取网络状态
     *
     * @param context
     * @return
     */
    protected boolean getNetworkStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            return true;
        }
        return false;
    }

    protected void showToastMessage(String message) {
        if (!TextUtils.isEmpty(message)) {
            ToastUtils.showShortToast(this, message);
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

    public void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
