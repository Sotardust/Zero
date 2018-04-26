package com.dai.zero.main.main.find;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/3/19.
 */

public interface FindContract {
    interface View extends BaseView<Presenter> {
        void bindViews();

        void showTestView1(String string);

        void showTestView2(String string);

        void showTestView3(String string);

        void showTestView4(String string);

        void showLoading();

        void hideLoading();
    }

    interface Presenter extends BasePresenter<View> {
        void getNeteaseData();

        void initData();

        void getNoSleep();

        void getSleepTwo();

        void getSleepThree();

        void getSleepFive();
    }
}
