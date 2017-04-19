package com.alenbeyond.moon.module.main.contract;

import com.alenbeyond.moon.base.presenter.ILoadDataPresenter;
import com.alenbeyond.moon.base.view.ILoadDataView;
import com.alenbeyond.moon.model.bean.News;

import java.util.List;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelContract {
    public interface View extends ILoadDataView {
        void showData(List<News.NewsListBean> newsList, boolean isLoadMore);

        void showEmptyData();

        void showRefreshData(List<News.NewsListBean> newsList);
    }

    public interface Presenter extends ILoadDataPresenter<View> {
        void loadData(boolean loadMore, int channel, int fromNewsId);

        void handRefreshData(List<News.NewsListBean> newsList, int firstId);
    }
}
