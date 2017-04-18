package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BaseLoadDataPresenter;
import com.alenbeyond.moon.model.LoadDataSubsrcibe;
import com.alenbeyond.moon.model.bean.News;
import com.alenbeyond.moon.module.main.contract.ChannelContract;
import com.alenbeyond.moon.module.main.model.NewsMode;

import java.util.List;

import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelPresenter extends BaseLoadDataPresenter<ChannelContract.View> implements ChannelContract.Presenter {

    @Override
    public void loadData(final boolean isLoadMore, int channel, int fromNewsId) {

        if (!isNeedLoadData(isLoadMore)){
            return;
        }
        Subscription subscribe = NewsMode.getInstance().getNewsByChannel(channel, fromNewsId)
                .map(new Func1<News, List<News.NewsListBean>>() {
                    @Override
                    public List<News.NewsListBean> call(News news) {
                        return news.getNewsList();
                    }
                })
                .subscribe(new LoadDataSubsrcibe<List<News.NewsListBean>>(this, mView) {
                    @Override
                    public void onJesNext(List<News.NewsListBean> newsList) {
                        mView.showData(newsList, isLoadMore);
                    }
                });
        mSubscriptions.add(subscribe);
    }

    @Override
    public void halfwayStop() {
        unSubscribe();
    }
}
