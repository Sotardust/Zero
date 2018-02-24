package com.dai.zero.main.main;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;
import com.dai.zero.adapter.MainAdapter;

/**
 * Created by dai on 2018/2/13.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        boolean isActive();

        void init();

        void setAdapter(MainAdapter adapter);

        Object getObject();
    }

    interface Presenter extends BasePresenter<View> {
        void setData();

        void onRefresh();
    }
}
