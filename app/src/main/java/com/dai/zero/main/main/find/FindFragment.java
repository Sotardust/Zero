package com.dai.zero.main.main.find;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.RecommendAdapter;
import com.dai.zero.bean.FindBean;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.GlideApp;
import com.dai.zero.http.okhttp.OkHttpUtil;
import com.dai.zero.main.util.MyItemDecoration;
import com.dai.zero.main.util.ParamAnalysisUtil;
import com.dai.zero.storage.file.FileManager;
import com.dai.zero.storage.file.FileUtil;
import com.dai.zero.storage.file.PathUtil;
import com.dai.zero.util.callback.ObservableCallback;
import com.dai.zero.util.callback.ObserverCallback;
import com.dai.zero.util.listener.RecycleItemClickListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindFragment extends BaseFragment implements FindContract.View {

    private static final String TAG = "FindFragment";

    @Inject
    FindContract.Presenter mPresenter;

    Unbinder unbinder;

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.load_image)
    ImageView loadImage;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;

    private View view;
    private AnimationDrawable animationDrawable;
    private boolean isFirstVisible = false;
    private boolean isVisibleToUser = false;

    private RecommendAdapter adapter;

    @Inject
    public FindFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        isFirstVisible = true;
        if (isVisibleToUser()) {
            onFragmentFirstVisible();
        }
        String a = "abd";
        String b = "abd";
        String c = new String("abd");
        System.out.println("(a.equals(b)) = " + (a.equals(b)));
        System.out.println("(a == b) = " + (a == b));
        System.out.println("(a.equals(c)) = " + (a.equals(c)));
        System.out.println("(a==c) = " + (a==c));
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        if (isVisibleToUser() && adapter != null && adapter.getBannerView() != null) {
            adapter.getBannerView().subscribe();
        }
//        mPresenter.getNeteaseData();
        isFirstVisible = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isVisibleToUser() && adapter != null && adapter.getBannerView() != null) {
            adapter.getBannerView().unSubscribe();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.dropView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void bindViews() {

        List<ImageView> imageViews = new ArrayList<>();

        String[] urls = getResources().getStringArray(R.array.module_url_banner_picture);

        for (String url : urls) {
            ImageView imageView = new ImageView(getContext());
            imageViews.add(GlideApp.with(this).load(url).centerCrop().into(imageView).getView());
        }

        adapter = new RecommendAdapter();
        String[] mTitle = getContext().getResources().getStringArray(R.array.module_recommend_title);

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> urlList = new ArrayList<>();

        ArrayList<String> mTitleList = new ArrayList<>();
        Collections.addAll(mTitleList, mTitle);
        FindBean findBean = ParamAnalysisUtil.getFindData();


        for (int i = 0; i < mTitle.length * 6; i++) {
//            System.out.println("findBean.getTitleList().get(i) = " + findBean.getTitleList().get(i));
//            System.out.println("findBean.getAddressList().get(i) = " + findBean.getAddressList().get(i));
            list.add(findBean.getTitleList().get(i));
            urlList.add(findBean.getImageList().get(i));
        }

        adapter.setData(list);
        adapter.setTitleList(mTitleList);
        adapter.setImageViewList(imageViews);
        adapter.setUrlList(urlList);
//        String url = "http://music.163.com/playlist?id=2129466456";
        String url = "http://music.163.com/song?id=553310138";
        OkHttpUtil.getRequest(url, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
//                Log.d(TAG, "onNext() returned: " + s);
//                System.out.println("s = " + s);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.d(TAG, "onError() returned: " + e.toString());
            }
        });

        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        MyItemDecoration decoration = new MyItemDecoration();
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = adapter.getItemViewType(position);
                return type <= 0 ? 3 : 1;
            }
        });

        recycleView.addItemDecoration(decoration);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);

        adapter.setRecycleItemClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClickListener(int type, String value, int position) {

                switch (type) {
                    case -2:
                        Log.d(TAG, "BANNER_VIEW() returned: " + position);
                        break;
                    case -1:
                        getSong();
                        break;
                    case 0:
                        Log.d(TAG, "onItemClickListener() returned: " + 0);
                        break;
                    case 1:
                        Log.d(TAG, "onItemClickListener() returned: " + 1);
                        break;
                    case 2:
                        Log.d(TAG, "onItemClickListener() returned: " + 2);
                        break;
                    case 3:
                        Log.d(TAG, "onItemClickListener() returned: " + 3);
                        break;
                }
            }
        });


    }

    @Override
    public void showTestView1(String string) {

    }

    @Override
    public void showTestView2(String string) {

    }

    @Override
    public void showTestView3(String string) {

    }

    @Override
    public void showTestView4(String string) {

    }

    @Override
    public void showLoading() {
        if (isFirstVisible()) {
            llLoad.setVisibility(View.VISIBLE);
            loadImage = (ImageView) view.findViewById(R.id.load_image);
            loadImage.setImageResource(R.drawable.module_load_anim);
            animationDrawable = (AnimationDrawable) loadImage.getDrawable();
            animationDrawable.start();
        }

    }

    @Override
    public void hideLoading() {
        if (isFirstVisible()) {
            animationDrawable.stop();
            llLoad.setVisibility(View.GONE);
            isFirstVisible = false;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser && isFirstVisible()) {
            onFragmentFirstVisible();
        }
    }

    private void onFragmentFirstVisible() {
        bindViews();
//        mPresenter.getNeteaseData();
//        mPresenter.getNoSleep();
//        mPresenter.getSleepTwo();
//        mPresenter.getSleepThree();
//        mPresenter.getSleepFive();
    }

    public boolean isFirstVisible() {
        return isFirstVisible;
    }

    public boolean isVisibleToUser() {
        return isVisibleToUser;
    }

    private void getSong() {

        Observable.create(new ObservableCallback<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                super.subscribe(emitter);
                Log.d(TAG, "subscribe: ");
                String url = "http://39.106.220.113:8080/mobile/music/qiansixi";
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                Response response = OkHttpUtil.getInstance().newCall(request).execute();
                Log.d(TAG, "subscribe: header" + response.headers().toString());
                String path = PathUtil.MUSIC_PATH + "富士山下.mp3";


                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(FileManager.getInstance().createNewFile(path));
                    byte[] bytes1 = response.body().bytes();
                    fileOutputStream.write(bytes1);
                    fileOutputStream.flush();//将内容一次性写入文件

                } catch (IOException e) {
                    Log.d(TAG, "run() returned: " + e);
                    e.printStackTrace();
                } finally {
                    fileOutputStream.close();
                    fileOutputStream = null;
                    emitter.onNext("写入成功");
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObserverCallback<String>() {
                    @Override
                    public void onNext(final String response) {
                        super.onNext(response);
                        System.out.println("response = " + response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.d(TAG, "onError() returned: " + e);
                    }
                });
    }

}
