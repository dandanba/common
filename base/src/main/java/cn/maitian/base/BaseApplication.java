package cn.maitian.base;

import android.support.multidex.MultiDexApplication;

/**
 * Created by geng on 2016/7/18.
 */
public class BaseApplication extends MultiDexApplication {
    private static BaseApplication sBaseApplication;

    public static BaseApplication getBaseApplication() {
        return sBaseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApplication = this;
    }
}
