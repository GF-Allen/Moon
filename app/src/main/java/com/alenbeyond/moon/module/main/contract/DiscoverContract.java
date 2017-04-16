package com.alenbeyond.moon.module.main.contract;

import com.alenbeyond.moon.base.presenter.IBasePresenter;
import com.alenbeyond.moon.base.view.IBaseView;
import com.alenbeyond.moon.module.main.bean.DiscoverChannel;

/**
 * Created by AlenBeyond on 2017/4/15.
 */

public class DiscoverContract {
    public interface View extends IBaseView {
        void showChannel(DiscoverChannel channel);
    }

    public interface Presenter<V extends IBaseView> extends IBasePresenter<V> {
        void getChannel();
    }
}
