package com.alenbeyond.moon.module.main.contract;

import com.alenbeyond.moon.base.presenter.IBasePresenter;
import com.alenbeyond.moon.base.view.IBaseView;
import com.alenbeyond.moon.model.bean.News;

import java.util.List;

/**
 * Created by Allen on 2017/4/17.
 */

public class ChannelContract {
    public interface View extends IBaseView {
        void showData(List<News.NewsListBean> newsList);
    }

    public interface Presenter extends IBasePresenter<View> {
        void loadData(int channel, int fromNewsId);
    }
}
