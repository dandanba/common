package cn.maitian.leakcanary_android;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by geng on 2016/8/2.
 */
public class LeakCanaryUtil {
    public static RefWatcher install(Application application) {
        return LeakCanary.install(application);
    }

    public static void watch(RefWatcher watcher, Object watched) {
        watcher.watch(watched);
    }
}
