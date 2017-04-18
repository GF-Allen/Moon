package com.alenbeyond.moon.module.main.contract;

import com.alenbeyond.moon.base.presenter.IBasePresenter;
import com.alenbeyond.moon.base.view.IBaseView;
import com.alenbeyond.moon.model.bean.Channel;

import java.util.List;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverContract {
    public interface View extends IBaseView {
        void showChannel(List<Channel.ChannelListBean.ChannelBeans> channels);
    }

    public interface Presenter extends IBasePresenter<View> {
        void getChannel();
    }
}
