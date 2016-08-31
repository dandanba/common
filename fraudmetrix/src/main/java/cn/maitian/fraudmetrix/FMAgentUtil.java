package cn.maitian.fraudmetrix;

import android.content.Context;

import cn.fraudmetrix.sdk.FMAgent;

/**
 * Created by geng on 2016/8/31.
 */
public class FMAgentUtil {

    public static void init(Context context, boolean openLog, boolean productionMode) {
        FMAgent.openLog(context, openLog);
        FMAgent.init(context, productionMode);
    }

    //调用接口获取blackBox字段，请确保在onCreate时已经进行init，切勿在onEvent的时候才init
    //将blackBox的值随业务请求发送到你的服务端, 服务端在调用同盾风险决策服务时需要用到这个参数；
    public static String getbBlackBox(Context context) {
        return FMAgent.onEvent(context);
    }
}
