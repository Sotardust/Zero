package com.dai.zero.http.okhttp;

import com.dai.zero.util.inter.ObservableOnSubscribeListener;
import com.dai.zero.util.inter.ObserverListener;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public class OkHttpUtil {

    //无参数请求数据
    public static void getRequest(final String url, ObserverListener<String> observerListener) {
        executeSubscribe(getObservable(url), observerListener);
    }

    //自定义get请求数据
    public static void getRequest(ObservableOnSubscribeListener<String> listener, ObserverListener<String> observerListener) {
        executeSubscribe(getObservable(listener), observerListener);
    }

    //有参数请求数据
    public static void postRequest(final String url, final HashMap<String, String> param, ObserverListener<String> observerListener) {
        executeSubscribe(getObservable(url, param), observerListener);
    }

    //自定义post请求数据
    public static void postRequest(ObservableOnSubscribeListener<String> listener, ObserverListener<String> observerListener) {
        executeSubscribe(getObservable(listener), observerListener);
    }

    private static void executeSubscribe(Observable<String> observable, ObserverListener<String> observerListener) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observerListener);
    }

    private static Observable<String> getObservable(ObservableOnSubscribeListener<String> listener) {
        return Observable.create(listener);
    }

    private static Observable<String> getObservable(final String url) {
        return Observable.create(new ObservableOnSubscribeListener<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                super.subscribe(emitter);
                Response response = getOkHttpClient().newCall(getRequest(url)).execute();
                emitter.onNext(response.body().string());
            }
        });
    }

    private static Observable<String> getObservable(final String url, final HashMap<String, String> param) {
        return Observable.create(new ObservableOnSubscribeListener<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                super.subscribe(emitter);
                Response response = getOkHttpClient().newCall(getRequest(url, param)).execute();
                emitter.onNext(response.body().string());
            }
        });
    }

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient();
    }

    private static Request getRequest(String url, HashMap<String, String> param) {
        return getRequestBuilder(url).post(getRequestBody(param)).build();
    }

    private static Request getRequest(String url) {
        return getRequestBuilder(url).build();
    }

    private static Request.Builder getRequestBuilder(String url) {
        return new Request.Builder().url(url);
    }

    private static RequestBody getRequestBody(HashMap<String, String> param) {
        FormBody.Builder formBody = new FormBody.Builder();
        for (String key : param.keySet()) {
            formBody.add(key, param.get(key));
        }
        return formBody.build();
    }

}
