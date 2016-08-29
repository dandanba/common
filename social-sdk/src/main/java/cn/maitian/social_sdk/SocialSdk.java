package cn.maitian.social_sdk;

import android.app.Activity;
import android.content.Intent;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.utils.Log;

import java.util.Map;

/**
 * Created by geng on 2016/8/29.
 */
public class SocialSdk {
    private static final java.lang.String TAG = SocialSdk.class.getSimpleName();

    public static void init() {
        Log.LOG = false;
        Config.IsToastTip = false;
    }

    //微信 appid appsecret
    public static void setWeixin(String appid, String appsecret) {
        PlatformConfig.setWeixin(appid, appsecret);
    }

    //新浪微博 appkey appsecret redirectUrl
    public static void setSinaWeibo(String appkey, String appsecret, String redirectUrl) {
        PlatformConfig.setSinaWeibo(appkey, appsecret);
        Config.REDIRECT_URL = redirectUrl;
    }

    public static void doOauthVerify(Activity activity, SHARE_MEDIA shareMedia, SocialAuthSdkHandler handler) {
        final UMShareAPI mShareAPI = UMShareAPI.get(activity);
        mShareAPI.doOauthVerify(activity, shareMedia, handler);
    }

    public static void getPlatformInfo(Activity activity, SHARE_MEDIA shareMedia, SocialAuthSdkHandler handler) {
        final UMShareAPI mShareAPI = UMShareAPI.get(activity);
        mShareAPI.getPlatformInfo(activity, shareMedia, handler);
    }

    public static void openShareAction(Activity activity, String text, String title, String targetUrl, String imageUrl, SocialShareSdkHandler handler) {
        final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]{SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SINA, SHARE_MEDIA.QQ};
        new ShareAction(activity).setDisplayList(displaylist)
                .withText(text)
                .withTitle(title)
                .withTargetUrl(targetUrl)
                .withMedia(new UMImage(activity, imageUrl))
                .setListenerList(handler)
                .open();
    }

    public static void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        final UMShareAPI mShareAPI = UMShareAPI.get(activity);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    // QQ和Qzone appid appkey
    public void setQQZone(String appid, String appkey) {
        PlatformConfig.setQQZone(appid, appkey);
    }

    public static class SocialAuthSdkHandler implements UMAuthListener {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int action, Map<String, String> map) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int action, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int action) {

        }
    }

    public static class SocialShareSdkHandler implements UMShareListener {

        @Override
        public void onResult(SHARE_MEDIA share_media) {

        }

        @Override
        public void onError(SHARE_MEDIA share_media, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media) {

        }
    }
}
