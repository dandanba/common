package cn.maitian.secure_pref_manager;

import android.content.Context;

import com.prashantsolanki.secureprefmanager.SecurePrefManager;
import com.prashantsolanki.secureprefmanager.SecurePrefManagerInit;

/**
 * Created by geng on 2016/8/19.
 */
public class SecurePrefUtils {
    public static void initialize(Context context) {
        new SecurePrefManagerInit.Initializer(context).useEncryption(true).initialize();
    }

    public static void setValue(Context context, String name, String value) {
        getSetter(context, name).value(value).go();
    }

    public static void setValue(Context context, String name, long value) {
        getSetter(context, name).value(value).go();
    }

    public static void setValue(Context context, String name, float value) {
        getSetter(context, name).value(value).go();
    }

    public static void setValue(Context context, String name, int value) {
        getSetter(context, name).value(value).go();
    }

    public static void setValue(Context context, String name, boolean value) {
        getSetter(context, name).value(value).go();
    }

    public static String getValue(Context context, String name, String defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static long getValue(Context context, String name, long defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static float getValue(Context context, String name, float defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static int getValue(Context context, String name, int defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static boolean getValue(Context context, String name, boolean defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    private static SecurePrefManager.Setter getSetter(Context context, String name) {
        return SecurePrefManager.with(context).set(name);
    }

    private static SecurePrefManager.Getter getGetter(Context context, String name) {
        return SecurePrefManager.with(context).get(name);
    }
}
