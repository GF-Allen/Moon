package com.alenbeyond.moon.module.main.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.model.bean.News;
import com.alenbeyond.moon.module.main.adapter.RvChannelAdapter;
import com.alenbeyond.moon.module.main.contract.ChannelContract;
import com.alenbeyond.moon.module.main.presenter.ChannelPresenter;
import com.alenbeyond.moon.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelPager extends LinearLayout implements ChannelContract.View {

    @BindView(R.id.rv_channel)
    RecyclerView mRvChannel;

    private Context mContext;
    private ProgressDialog mProgressDialog;

    private Channel.ChannelListBean.ChannelBeans mChannelBeans;
    private ChannelPresenter mPresenter;
    private RvChannelAdapter mAdapter;

    public ChannelPager(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext, R.layout.pager_channel, this);
        ButterKnife.bind(view);
        mPresenter = new ChannelPresenter();
        mPresenter.attachView(this);
        mRvChannel.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new RvChannelAdapter(mContext);
        mRvChannel.setAdapter(mAdapter);
    }

    public void setChannelBeans(Channel.ChannelListBean.ChannelBeans channelBeans) {
        this.mChannelBeans = channelBeans;
        mPresenter.loadData(channelBeans.getChannel(), -1);
    }

    @Override
    public void showMessage(@NonNull String message) {
        ToastUtils.showShortToast(mContext, message);
    }

    @Override
    public void showMessage(@StringRes int messageId) {
        ToastUtils.showShortToast(mContext, messageId);
    }

    @Override
    public void showProgressDialog(String title, String message) {
        showProgressDialog(title, message, false, false);
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
    public void dismissProgressDialog() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showData(List<News.NewsListBean> newsList) {
        mAdapter.addData(newsList);
    }
}
