package com.alenbeyond.moon.module.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.base.view.BaseFragment;
import com.alenbeyond.moon.model.bean.Channel;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2017/4/16.
 */

public class ChannelFragment extends BaseFragment {


    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_id)
    TextView mTvId;

    private Channel.ChannelListBean.ChannelBeans channelBeans;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).showTitleBar();
        return createView(inflater, container, R.layout.fragment_channel);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTvTitle.setText(channelBeans.getChannelName());
        mTvId.setText(channelBeans.getChannel());
    }

    public void setDatas(Channel.ChannelListBean.ChannelBeans channelBeans) {
        this.channelBeans = channelBeans;
    }
}
