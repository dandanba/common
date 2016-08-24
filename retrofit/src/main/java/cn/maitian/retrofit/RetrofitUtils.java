package cn.maitian.retrofit;

import android.content.Context;

import cn.maitian.jackson.JascksonUtil;
import cn.maitian.okhttp.OkHttpUtil;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitUtils {
    public static Retrofit initClient(Context context, String baseUrl, String appplicationId, String flavor, String versionName, String versionCode) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(JascksonUtil.initMapper()))
                .client(OkHttpUtil.initClient(context, appplicationId, flavor, versionName, versionCode))
                .build();
        return retrofit;
    }

}