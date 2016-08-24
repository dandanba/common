package cn.maitian.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by geng on 2016/7/18.
 */
public class EventUtil {
    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void postEvent(Object event) {
        EventBus.getDefault().post(event);
    }
}
