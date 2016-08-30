package cn.maitian.customactivityoncrash;

import android.content.Context;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;

/**
 * Created by geng on 2016/8/30.
 */
public class CustomCrashUtil {

    public static void install(Context context) {
        //Install CustomActivityOnCrash
        CustomActivityOnCrash.install(context);
    }
}
