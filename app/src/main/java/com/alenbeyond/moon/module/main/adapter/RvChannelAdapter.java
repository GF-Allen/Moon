package com.alenbeyond.moon.module.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.base.adapter.MoonBaseRecyclerViewAdapter;
import com.alenbeyond.moon.model.bean.News;
import com.alenbeyond.moon.utils.glide.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Allen on 2017/4/17.
 */

public class RvChannelAdapter extends MoonBaseRecyclerViewAdapter<News.NewsListBean, RvChannelAdapter.ViewHolder> {
    public RvChannelAdapter(Context context) {
        super(context);
    }

    @Override
    protected ViewHolder doOnCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_channel, null);
        return new ViewHolder(view);
    }

    @Override
    protected void doOnBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(objectList.get(position).getNewsBean().getTitle());
        holder.tvDes.setText(objectList.get(position).getNewsBean().getDigest());
        holder.tvOwner.setText(objectList.get(position).getAuthorBean().getName());
        GlideUtils.getInstance().loadCircleImage(mContext, holder.ivOwner, objectList.get(position).getAuthorBean().getHeadUrl());
        GlideUtils.getInstance().loadImage(mContext, holder.ivPic, objectList.get(position).getNewsBean().getCoverUrl(), true);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_des)
        TextView tvDes;
        @BindView(R.id.tv_owner)
        TextView tvOwner;
        @BindView(R.id.iv_owner)
        ImageView ivOwner;
        @BindView(R.id.iv_pic)
        ImageView ivPic;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
