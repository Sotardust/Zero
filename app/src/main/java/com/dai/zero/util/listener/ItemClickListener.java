package com.dai.zero.util.listener;

/**
 * Created by dai on 2018/4/4.
 */

public interface ItemClickListener {

    void onItemClickListener(int type, String value, int position);

    void onItemLongClickListener(int type,String value, int position);
}
