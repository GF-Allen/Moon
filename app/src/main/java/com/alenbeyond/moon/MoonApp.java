package com.alenbeyond.moon;

import android.app.Application;

import com.alenbeyond.moon.model.AppBaseCache;
import com.alenbeyond.moon.model.InitRetrofit;
import com.socks.library.KLog;

/**
 *
 * Created by allen on 2017/4/11.
 */

public class MoonApp extends Application {

    private static MoonApp sMoonApp;
    public static InitRetrofit initRetrofit;

    public static MoonApp getInstance(){
        return sMoonApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sMoonApp = this;
        getRetrofitClient();

        //日志打印
        KLog.init(BuildConfig.DEBUG, "Moon");
    }

    private static InitRetrofit getRetrofitClient() {
        if (initRetrofit == null) {
            String sessionId = AppBaseCache.getInstance(sMoonApp).getSessionId();
            initRetrofit = new InitRetrofit(sessionId);
        }
        return initRetrofit;
    }
}
