package com.dai.zero.main.main.find;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

/**
 * Created by dai on 2018/3/19.
 */

public interface FindContract {
    interface View extends BaseView< Presenter > {
    }

    interface Presenter extends BasePresenter< View > {
    }
}
