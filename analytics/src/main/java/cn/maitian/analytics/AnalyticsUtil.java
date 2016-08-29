package cn.maitian.analytics;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

import java.util.Map;

/**
 * Created by geng on 2016/8/29.
 */
public class AnalyticsUtil {
    public static void onResume(Context context) {
        MobclickAgent.onResume(context);
    }


    public static void onPause(Context context) {
        MobclickAgent.onPause(context);
    }

    public static void onProfileSignIn(String provider, String id) {
        MobclickAgent.onProfileSignIn(provider, id);
    }

    public static void onPageStart(String pageName) {
        MobclickAgent.onPageStart(pageName);
    }

    public static void onPageEnd(String pageName) {
        MobclickAgent.onPageEnd(pageName);
    }

    public static void onEvent(Context context, String eventId) {
        MobclickAgent.onEvent(context, eventId);
    }

    public static void onEvent(Context context, String eventId, Map<String, String> map) {
        MobclickAgent.onEvent(context, eventId, map);
    }
}
