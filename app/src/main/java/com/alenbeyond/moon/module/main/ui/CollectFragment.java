package com.alenbeyond.moon.module.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alenbeyond.moon.R;
import com.alenbeyond.moon.base.view.BaseFragment;

/**
 * Created by Allen on 2017/4/17.
 */

public class CollectFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return createView(inflater, container, R.layout.fragment_home);
    }
}
