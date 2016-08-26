package cn.maitian.secure_pref_manager;

import android.content.Context;

import com.prashantsolanki.secureprefmanager.SecurePrefManager;
import com.prashantsolanki.secureprefmanager.SecurePrefManagerInit;

import java.util.HashMap;

/**
 * Created by geng on 2016/8/19.
 */
public class SecurePrefUtils {
    private static final HashMap<String, String> sStringMap = new HashMap<>();
    private static final HashMap<String, Integer> sIntegerMap = new HashMap<>();
    private static final HashMap<String, Boolean> sBooleanMap = new HashMap<>();


    public static void initialize(Context context) {
        new SecurePrefManagerInit.Initializer(context).useEncryption(true).initialize();
    }

    public static void initialize(Context context, String[] strings, String[] integers, String[] booleans) {
        initialize(context);
        if (strings != null) {
            for (String name : strings) {
                sStringMap.put(name, getValue(context, name, ""));
            }
        }
        if (integers != null) {
            for (String name : integers) {
                sIntegerMap.put(name, getValue(context, name, 0));
            }
        }
        if (booleans != null) {
            for (String name : booleans) {
                sBooleanMap.put(name, getValue(context, name, false));
            }
        }
    }

    public static void setValue(Context context, String name, String value) {
        getSetter(context, name).value(value).go();
        sStringMap.put(name, value);
    }

    public static void setValue(Context context, String name, int value) {
        getSetter(context, name).value(value).go();
        sIntegerMap.put(name, value);
    }

    public static void setValue(Context context, String name, boolean value) {
        getSetter(context, name).value(value).go();
        sBooleanMap.put(name, value);
    }

    //
//    public static void setValue(Context context, String name, long value) {
//        getSetter(context, name).value(value).go();
//    }
//
//    public static void setValue(Context context, String name, float value) {
//        getSetter(context, name).value(value).go();
//    }

    public static String getValue(String name, String defaultValue) {
        return sStringMap.containsKey(name) ? sStringMap.get(name) : defaultValue;
    }

    public static int getValue(String name, int defaultValue) {
        return sIntegerMap.containsKey(name) ? sIntegerMap.get(name) : defaultValue;
    }

    public static boolean getValue(String name, boolean defaultValue) {
        return sBooleanMap.containsKey(name) ? sBooleanMap.get(name) : defaultValue;
    }

    public static String getValue(Context context, String name, String defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static int getValue(Context context, String name, int defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }

    public static boolean getValue(Context context, String name, boolean defaultValue) {
        return getGetter(context, name).defaultValue(defaultValue).go();
    }
//
//    public static long getValue(Context context, String name, long defaultValue) {
//        return getGetter(context, name).defaultValue(defaultValue).go();
//    }
//
//    public static float getValue(Context context, String name, float defaultValue) {
//        return getGetter(context, name).defaultValue(defaultValue).go();
//    }

    private static SecurePrefManager.Setter getSetter(Context context, String name) {
        return SecurePrefManager.with(context).set(name);
    }

    private static SecurePrefManager.Getter getGetter(Context context, String name) {
        return SecurePrefManager.with(context).get(name);
    }
}
