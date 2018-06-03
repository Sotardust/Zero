package com.dai.zero.main.main.mine;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dai on 2018/3/19.
 */

public interface MineContract {
    interface View extends BaseView<Presenter> {
        void bindView();

        void showRecyclerView();
    }

    interface Presenter extends BasePresenter<View> {

    }
}
