package com.alenbeyond.moon.constants;

import android.os.Environment;

import java.io.File;

/**
 * Created by allen on 2017/4/12.
 */

public class Constants {

    //路径
    public static final String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator + "Moon" + File.separator;

    public static final String NET_CATCH_DIR = BASE_PATH + File.separator + ".netcatch";

    //数字常量把值包含在名字之中
    public static final int NET_TIMEOUT_30 = 30;
    public static final int NET_TIMEOUT_120 = 120;
    public static final int NET_TIMEOUT_600 = 600;

    public static final int NET_CATCH_SIZE_52428800 = 52428800;

    //常量
    public static final String APP_ID = "App-Id";
    public static final String API_VERSION = "Api-Version";
    public static final String USER_AGENT = "User-Agent";

}
