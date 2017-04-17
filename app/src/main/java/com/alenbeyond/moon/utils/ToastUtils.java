package com.alenbeyond.moon.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by Allen on 2017/4/14.
 */

public class ToastUtils {

    private static Toast sToast;

    public static void showShortToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showShortToast(Context context, @StringRes int msg) {
        showShortToast(context, context.getString(msg));
    }

    public static void showLongToast(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }

    public static void showLongToast(Context context, @StringRes int msg) {
        showShortToast(context, context.getString(msg));
    }

    private static void showToast(Context context, String msg, int duration) {
        if (sToast == null) {
            sToast = Toast.makeText(context, msg, duration);
        } else {
            sToast.setText(msg);
        }
        sToast.show();
    }
}
