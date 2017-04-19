package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BaseLoadDataPresenter;
import com.alenbeyond.moon.model.Subscribe.LoadDataSubscribe;
import com.alenbeyond.moon.model.bean.News;
import com.alenbeyond.moon.module.main.contract.ChannelContract;
import com.alenbeyond.moon.module.main.model.NewsMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelPresenter extends BaseLoadDataPresenter<ChannelContract.View> implements ChannelContract.Presenter {

    @Override
    public void loadData(final boolean isLoadMore, int channel, int fromNewsId) {

        Subscription subscribe = NewsMode.getInstance().getNewsByChannel(channel, fromNewsId)
                .map(new Func1<News, List<News.NewsListBean>>() {
                    @Override
                    public List<News.NewsListBean> call(News news) {
                        return news.getNewsList();
                    }
                })
                .delay(500, TimeUnit.MICROSECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new LoadDataSubscribe<List<News.NewsListBean>>(mView) {
                    @Override
                    public void _onSuccess(List<News.NewsListBean> newsList) {
                        if (newsList == null || newsList.size() == 0) {
                            mView.showEmptyData();
                        } else {
                            mView.showData(newsList, isLoadMore);
                        }
                    }
                });
        mSubscriptions.add(subscribe);
    }

    @Override
    public void handRefreshData(List<News.NewsListBean> newsList, int firstId) {
        List<News.NewsListBean> results = new ArrayList<>();
        if (newsList.get(0).getNewsBean().getId() == firstId) {
            return;
        }
        for (News.NewsListBean newsListBean : newsList) {
            if (newsListBean.getNewsBean().getId() != firstId) {
                results.add(newsListBean);
            } else {
                mView.showRefreshData(results);
                return;
            }
        }
        mView.showRefreshData(results);
    }

    @Override
    public void halfwayStop() {
        unSubscribe();
    }
}
