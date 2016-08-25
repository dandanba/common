package cn.maitian.multidex;

import android.content.Context;

public class MultiDexApplication extends android.support.multidex.MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
