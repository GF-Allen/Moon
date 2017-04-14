package com.alenbeyond.moon.model;

import android.content.Context;
import android.text.TextUtils;

/**
 * 基本参数缓存
 * Created by allen on 2017/4/12.
 */

public class AppBaseCache {

    private final String USER_ID = "USER_ID";
    private final String USER_NAME = "USER_NAME";
    private final String SESSION_ID = "SESSION_ID";

    private static AppBaseCache sAppBaseCache;
    private SPFHelper spfHelper;

    private String userId;
    private String userName;
    private String sessionId;

    private AppBaseCache(Context context) {
        spfHelper = new SPFHelper(context, null);
    }

    public static synchronized AppBaseCache getInstance(Context context){
        if (sAppBaseCache == null) {
            sAppBaseCache = new AppBaseCache(context);
        }
        return sAppBaseCache;
    }

    /**
     * 清空AppBaseCache
     * @param context
     */
    public static void resetAppBaseCache(Context context) {
        sAppBaseCache = new AppBaseCache(context);
    }

    /**
     * 更改preference的操作对象，替换成指定名字的
     *
     * @param context
     * @param preferenceName
     */
    public void ChoicePreference(Context context, String preferenceName) {
        synchronized (this) {
            spfHelper = new SPFHelper(context, preferenceName);
        }
    }

    public String getUserId() {
        if (TextUtils.isEmpty(userId)) {
            return spfHelper.getString(USER_ID, null);
        }
        return userId;
    }

    public void setUserId(String userId) {
        if (spfHelper.putString(USER_ID, userId)) {
            this.userId = userId;
        }
    }

    public String getUserName() {
        if (TextUtils.isEmpty(userName)) {
            return spfHelper.getString(USER_NAME, null);
        }
        return userName;
    }

    public void setUserName(String userName) {
        if (spfHelper.putString(USER_NAME, userName)) {
            this.userName = userName;
        }
    }

    public String getSessionId() {
        if (TextUtils.isEmpty(sessionId)) {
            return spfHelper.getString(SESSION_ID, null);
        }
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        if (spfHelper.putString(SESSION_ID, sessionId)) {
            this.sessionId = sessionId;
        }
    }
}
