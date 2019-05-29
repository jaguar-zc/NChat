package org.flyants.book.utils;

import android.util.Log;

public class LogUtils {

    public static final String TAG = "LOG_UTILS";

    public static void d(String tag,String log){
        Log.d(tag,log);
    }
    public static void d(Object log){
        d(TAG,String.valueOf(log));
    }
}
