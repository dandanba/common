package cn.maitian.leancloud;

import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.feedback.FeedbackAgent;

/**
 * Created by geng on 2016/9/1.
 */
public class LeanCloudUtil {

    public static void init(Context context, boolean useAVCloudUS) {
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(context, "{{appid}}", "{{appkey}}");
        if (useAVCloudUS) {
            // 启用北美节点
            AVOSCloud.useAVCloudUS();
        }
    }

    public static void startDefaultThreadActivity(Context context) {
        FeedbackAgent agent = new FeedbackAgent(context);
        agent.sync();
        agent.startDefaultThreadActivity();
    }
}

