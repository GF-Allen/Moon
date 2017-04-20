package com.alenbeyond.moon.module.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.base.view.BaseFragment;
import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.module.main.adapter.VpDiscoverAdapter;
import com.alenbeyond.moon.module.main.contract.DiscoverContract;
import com.alenbeyond.moon.module.main.presenter.DiscoverPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverFragment extends BaseFragment implements DiscoverContract.View {

    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp_discover)
    ViewPager mVpDiscover;

    private DiscoverPresenter mDiscoverPresenter;
    private VpDiscoverAdapter mAdapter;

    private boolean isFirst = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = createView(inflater, container, R.layout.fragment_discover);
        mDiscoverPresenter = new DiscoverPresenter();
        mDiscoverPresenter.attachView(this);
        initView();
        return view;
    }

    private void initView() {
        mVpDiscover.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Channel.ChannelListBean.ChannelBeans item = mAdapter.getItem(position);
                ChannelPager pager = (ChannelPager) mVpDiscover.getChildAt(position);
                pager.loadData(item);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void onVisible() {
        if (isFirst) {
            mDiscoverPresenter.getChannel();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mDiscoverPresenter.detachView();
    }

    @Override
    public void showChannel(List<Channel.ChannelListBean.ChannelBeans> channels) {
        isFirst = false;
        mAdapter = new VpDiscoverAdapter(mActivity, channels);
        mVpDiscover.setOffscreenPageLimit(channels.size());
        mVpDiscover.setAdapter(mAdapter);
        mTab.setupWithViewPager(mVpDiscover);
        ((ChannelPager) mVpDiscover.getChildAt(0)).loadData(channels.get(0));
    }

}
