package com.alenbeyond.moon.module.main.presenter;

import com.alenbeyond.moon.base.presenter.BasePresenter;
import com.alenbeyond.moon.model.MoonSubscribe;
import com.alenbeyond.moon.model.bean.News;
import com.alenbeyond.moon.module.main.contract.ChannelContract;
import com.alenbeyond.moon.module.main.model.NewsMode;

import java.util.List;

import rx.functions.Func1;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelPresenter extends BasePresenter<ChannelContract.View> implements ChannelContract.Presenter {

    @Override
    public void loadData(int channel, int fromNewsId) {
        NewsMode.getInstance().getNewsByChannel(channel, fromNewsId)
                .map(new Func1<News, List<News.NewsListBean>>() {
                    @Override
                    public List<News.NewsListBean> call(News news) {
                        return news.getNewsList();
                    }
                })
                .subscribe(new MoonSubscribe<List<News.NewsListBean>>(mView) {
                    @Override
                    public void onJesNext(List<News.NewsListBean> newsList) {
                        mView.showData(newsList);
                    }
                });
    }
}
