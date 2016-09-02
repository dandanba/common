package cn.maitian.android_autofittextview;

import android.widget.TextView;

import me.grantland.widget.AutofitHelper;

/**
 * Created by geng on 2016/9/2.
 */
public class AutofitTextviewUtil {
    public static void createAutofitTextView(TextView textView) {
        AutofitHelper.create(textView);
    }
}
