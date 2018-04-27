package com.dai.zero.main.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.dai.zero.BaseActivity;
import com.dai.zero.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dai on 2018/4/27.
 */

public class AActivity extends BaseActivity {
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.receive)
    TextView receive;

    private Handler handler ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_a);
        ButterKnife.bind(this);

        handler  = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println("msg.toString() = " + msg.toString());
                receive.setText("接收到数据");
            }
        };
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        handler.sendMessage(Message.obtain());

    }
}
