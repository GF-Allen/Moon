package com.alenbeyond.moon.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by allen on 2017/4/12.
 */

public class UiUtils {
    /**
     * 获取状态栏的高度
     *
     * @param context 上下文对象
     * @return 状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            throw new NullPointerException();
        }
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取Activity的根布局的View
     *
     * @param context 当前Activity
     * @return 返回根布局的View
     */
    public static View getRootView(Activity context) {
        return ((ViewGroup) (context.findViewById(android.R.id.content))).getChildAt(0);
    }

    public static ViewGroup.LayoutParams getViewHeight(Context context, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = getStatusBarHeight(context);
        return layoutParams;
    }
}
