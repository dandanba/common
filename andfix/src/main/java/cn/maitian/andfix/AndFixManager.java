package cn.maitian.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * Created by geng on 2016/9/9.
 */
public class AndFixManager {
    PatchManager patchManager;

    public void create(Context context, String appversion) {
        patchManager = new PatchManager(context);
        patchManager.init(appversion);//current version
    }

    /**
     * You should load patch as early as possible, generally, in the initialization phase of your application(such as Application.onCreate()).
     */
    public void loadPatch() {
        patchManager.loadPatch();
    }

    public boolean appPatch(String path) {
        try {
            patchManager.addPatch(path);//path of the patch file that was downloaded
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
