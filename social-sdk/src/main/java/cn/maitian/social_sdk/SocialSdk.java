package cn.maitian.social_sdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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

    public static void initLog(boolean isLog) {
        Log.LOG = isLog;
    }

    public static void initTip(boolean isToastTip) {
        Config.IsToastTip = isToastTip;
    }

    //微信 appid appsecret
    public static void setWeixin(String appid, String appsecret) {
        PlatformConfig.setWeixin(appid, appsecret);
    }

    //新浪微博 appkey appsecret redirectUrl
    public static void setSinaWeibo(String appkey, String appsecret) {
        PlatformConfig.setSinaWeibo(appkey, appsecret);
    }

    //新浪微博 appkey appsecret redirectUrl
    public static void setSinaWeibo(String appkey, String appsecret, String redirectUrl) {
        PlatformConfig.setSinaWeibo(appkey, appsecret);
        Config.REDIRECT_URL = redirectUrl;
    }

    public static void doOauthVerify(Activity activity, SHARE_MEDIA shareMedia, SocialAuthSdkHandler handler) {
        final UMShareAPI shareAPI = UMShareAPI.get(activity);
        shareAPI.doOauthVerify(activity, shareMedia, handler);
    }

    public static void getPlatformInfo(Activity activity, SHARE_MEDIA shareMedia, SocialAuthSdkHandler handler) {
        final UMShareAPI shareAPI = UMShareAPI.get(activity);
        shareAPI.getPlatformInfo(activity, shareMedia, handler);
    }


    //    平台	title	Text	TargetUrl	图片	音乐	视频
//    新浪微博	不支持	新浪编辑页面，限制最多140个字符（1个数字或者英文算半个字符，中文算一个字符）	TatgetUrl只能加在文字中间或后面，当同时传递视频/音频时无效	支持JPG\PNG\GIF格式的本地及URL图片，GIF图片无动态效果	支持URL音乐,显示音乐播放缩略图需要linkcard权限	支持URL视频，显示视频播放缩略图需要linkcard权限
//    QQ好友	支持，最多只显示20个字符	最多只显示30个字符	http链接分享后无法打开targetURL，https链接可以打开，纯图片分享时点击无效	支持JPG\PNG\GIF格式的本地及URL图片，URL形式及resource内的GIF图片有动态效果，SD卡中的GIF图片无动态效果	支持URL音乐,音乐author无法显示，可以点击音乐播放按钮直接播放	支持URL视频，视频会转化为音乐样式
//    QQ空间	支持，最多只显示20个字符	最多只显示30个字符	不支持www开头的URL链接	不支持纯图片分享，支持JPG\PNG\GIF格式的本地及URL图片，URL形式及resource内的GIF图片有动态效果，SD卡中的GIF图片无动态效果	支持URL音乐,音乐author无法显示，可以点击音乐播放按钮直接播放	支持URL视频，视频会转化为音乐样式
//    微信好友	支持	支持超长字符和特殊字符	纯图片分享时targetURL无效	支持JPG\PNG\GIF格式的本地及URL图片，图文分享类型时GIF图片无动态效果	支持URL音乐,音乐author无法显示，可以点击音乐播放按钮直接播放	支持URL视频，视频会转化为音乐样式
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
        final UMShareAPI shareAPI = UMShareAPI.get(activity);
        shareAPI.onActivityResult(requestCode, resultCode, data);
    }

    // QQ和Qzone appid appkey
    public static void setQQZone(String appid, String appkey) {
        PlatformConfig.setQQZone(appid, appkey);
    }

    public static void initProgressDialog(Context context, String title, String message) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        Config.dialog = dialog;
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
