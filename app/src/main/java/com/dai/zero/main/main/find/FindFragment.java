package com.dai.zero.main.main.find;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.GlideApp;
import com.dai.zero.http.netease.AddParam;
import com.dai.zero.http.netease.NetEaseApi;
import com.dai.zero.main.main.find.banner.BannerView;
import com.dai.zero.util.inter.ObserverListener;

import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindFragment extends BaseFragment implements FindContract.View {

    private static final String TAG = "FindFragment";

    @BindView(R.id.banner_view)
    BannerView bannerView;
    Unbinder unbinder;

    @Inject
    public FindFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);

        List<ImageView> imageViews = new ArrayList<>();

        String[] urls = getResources().getStringArray(R.array.module_url_banner_picture);

        for (String url : urls) {
            ImageView imageView = new ImageView(getContext());
            imageViews.add(GlideApp.with(this).load(url).centerCrop().into(imageView).getView());
        }
        bannerView.setImageViewList(imageViews);
        bannerView.start();
        bannerView.setOnBannerViewClickListener(new BannerView.OnBannerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });

        io.reactivex.Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                AddParam upp = NetEaseApi.SearchGeShou("红昭愿");
//            UrlParamPair upp = Api.SearchMusic("红昭愿");
//                String param = upp.getParas().toJSONString();
//                String param = "{\"logs\":\"[{\\\"action\\\":\\\"bannerimpress\\\",\\\"json\\\":{\\\"type\\\":\\\"1_歌曲\\\",\\\"url\\\":\\\"/song?id=548556869\\\",\\\"id\\\":\\\"548556869\\\",\\\"position\\\":2}}]\",\"csrf_token\":\"\"}";
//                String param = "{\"csrf_token\":\"\"}";
                String param = "{\"ids\":\"[426027293]\",\"br\":128000,\"csrf_token\":\"\"}";
                System.out.println("param:" + param);
//                String url = "http://39.106.220.113:8080/mobile/params";
                String url = "http://39.106.220.113:8080/mobile/params";
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormBody.Builder()
                        .add("param", param).build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(requestBody)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                emitter.onNext(response.body().string());

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverListener<String>() {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        Log.d(TAG, "onNext() returned: " + s);
                        test(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });


        return view;
    }


    private void test(final String param) {
        io.reactivex.Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    JSONObject jsonObject = new JSONObject(param);
                    hashMap.put("params", jsonObject.getString("params"));
                    hashMap.put("encSecKey", jsonObject.getString("encSecKey"));
                    Connection.Response
//                            response = Jsoup.connect("http://music.163.com/weapi/search/suggest/web?csrf_token=")
//                            response = Jsoup.connect("http://music.163.com/weapi/feedback/weblog?csrf_token=")
//                            response = Jsoup.connect("http://music.163.com/#/playlist?id=2160550186")
                            response = Jsoup.connect("http://music.163.com/weapi/song/enhance/player/url?csrf_token=")
                            .data(hashMap)
                            .method(Connection.Method.POST)
                            .ignoreContentType(true)
                            .timeout(10000)
                            .execute();
                    String list = response.body();
//                    System.out.println(list);
                    emitter.onNext(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverListener<String>() {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        Log.d(TAG, "onNext() returned: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
