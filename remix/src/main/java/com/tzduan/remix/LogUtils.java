package com.tzduan.remix;

import android.util.Log;

/**
 * Created by tzduan on 17/12/12.
 */

public class LogUtils {

    public static void infoLog(String message){
        Log.println(Log.INFO, StaticField.LOG_TAG, message);
    }

    public static void errorLog(String message){
        Log.println(Log.ERROR, StaticField.LOG_TAG, message);
    }
}
