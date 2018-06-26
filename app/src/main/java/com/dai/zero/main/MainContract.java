package com.dai.zero.main;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/2/13.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();
        void initViews();
    }

    interface Presenter extends BasePresenter<View> {
        void initData();
    }
}
