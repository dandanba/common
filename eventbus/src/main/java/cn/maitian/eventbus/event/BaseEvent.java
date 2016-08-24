package cn.maitian.eventbus.event;

/**
 * Created by geng on 2016/7/16.
 */
public class BaseEvent {
    private Object mSender;
    private String mTag;

    public Object getSender() {
        return mSender;
    }

    public void setSender(Object sender) {
        this.mSender = sender;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        this.mTag = tag;
    }
}
