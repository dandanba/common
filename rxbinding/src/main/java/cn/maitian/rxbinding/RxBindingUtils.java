package cn.maitian.rxbinding;

import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;

import rx.Observer;

/**
 * Created by geng on 2016/8/31.
 */
public class RxBindingUtils {

    public static void throttleFirst(View view, Observer<? super Void> onNext) {
        RxView.clicks(view).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(onNext);
    }
}
