package cn.maitian.utils.os;

import android.os.Handler;
import android.os.Message;

public class LogHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }

    public void removeCallbacksAndMessages() {
        removeCallbacksAndMessages(null);
    }
}