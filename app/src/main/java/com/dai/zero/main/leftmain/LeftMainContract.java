package com.dai.zero.main.leftmain;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/2/13.
 */

public interface LeftMainContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {
    }
}
