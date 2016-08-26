package cn.maitian.utils;

import android.content.Intent;

public class IntentUtils {
    public static Intent generageIntent(String action) {
        return new Intent(action);
    }
}