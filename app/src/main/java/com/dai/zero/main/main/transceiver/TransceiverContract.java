package com.dai.zero.main.main.transceiver;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/3/19.
 */

public interface TransceiverContract {
    interface View extends BaseView<Presenter> {

        void showTestView1(String string);

        void showTestView2(String string);

        void showTestView3(String string);

        void showTestView4(String string);
    }

    interface Presenter extends BasePresenter<View> {

        void getNoSleep();

        void getSleepTwo();

        void getSleepThree();

        void getSleepFive();
    }
}
