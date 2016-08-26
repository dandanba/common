package cn.maitian.calligrahpy;

import android.content.Context;
import android.content.ContextWrapper;

import cn.maitian.calligraphy.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by geng on 2016/8/26.
 */
public class CalligrahphyUtil {
    /**
     * @param fontPath "fonts/Roboto-RobotoRegular.ttf"
     */
    public static void initDefault(String fontPath) {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(fontPath)
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    /**
     * <pre>
     *     @Override
     *     protected void attachBaseContext(Context newBase) {
     *     super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
     *     }
     * </pre>
     *
     * @param newBase
     * @return
     */
    public static ContextWrapper wrap(Context newBase) {
        return CalligraphyContextWrapper.wrap(newBase);
    }
}
