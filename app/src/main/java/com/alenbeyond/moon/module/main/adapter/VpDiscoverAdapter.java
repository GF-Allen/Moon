package com.alenbeyond.moon.module.main.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.moon.model.bean.Channel;
import com.alenbeyond.moon.module.main.ui.ChannelPager;

import java.util.List;

/**
 * Created by Allen on 2017/4/17.
 */

public class VpDiscoverAdapter extends PagerAdapter {

    private Context mContext;
    private List<Channel.ChannelListBean.ChannelBeans> mDatas;

    public VpDiscoverAdapter(Context mContext, List<Channel.ChannelListBean.ChannelBeans> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Channel.ChannelListBean.ChannelBeans channelBeans = mDatas.get(position);
        ChannelPager channelPager = new ChannelPager(mContext);
        channelPager.setChannelBeans(channelBeans);
        container.addView(channelPager);
        return channelPager;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position).getChannelName();
    }
}
