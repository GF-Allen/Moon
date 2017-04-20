package com.alenbeyond.moon.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.alenbeyond.moon.MoonApp;

/**
 * Toast工具类
 * Created by Allen on 2017/4/14.
 */

public class ToastUtils {

    private static Toast sToast;
    private static MoonApp sMoonApp;

    public static void showShortToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    public static void showShortToast(@StringRes int msg) {
        showShortToast(sMoonApp.getString(msg));
    }

    public static void showLongToast(String msg) {
        showToast(msg, Toast.LENGTH_LONG);
    }

    public static void showLongToast(@StringRes int msg) {
        showShortToast(sMoonApp.getString(msg));
    }

    private static void showToast(String msg, int duration) {
        if (sToast == null) {
            sMoonApp = MoonApp.getInstance();
            sToast = Toast.makeText(sMoonApp, msg, duration);
        } else {
            sToast.setText(msg);
        }
        sToast.show();
    }
}
