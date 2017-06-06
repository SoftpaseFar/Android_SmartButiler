package com.goo1e.smartbutiler.utils;
import android.util.Log;
/**
 * LOG的封装类
 * Created by SoftpaseFar on 2017/3/30.
 * */

public class L {
    //开关
    private static final boolean DEBUG =true;
    //TAG
    private static final String TAG = "Smartbutiler";
    //五个等级 DIWEF

    public static void d(String text) {
        if(DEBUG) {
                Log.d(TAG,text);
        }
    }

    public static void i(String text) {
        if(DEBUG) {
            Log.i(TAG,text);
        }
    }


    public static void w(String text) {
        if(DEBUG) {
            Log.w(TAG,text);
        }
    }


    public static void e(String text) {
        if(DEBUG) {
            Log.e(TAG,text);
        }
    }


}
