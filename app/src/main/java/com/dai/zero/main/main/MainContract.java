package com.dai.zero.main.main;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/2/13.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {
    }
}
