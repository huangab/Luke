package com.hyp.luke.module_me.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hyp.luke.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 黑名单
 * Created by  HuangYP on 2017/5/25 0025.
 */

public class Me_BlackNum extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_setting_blacknum);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText("黑名单");
    }
    public static void launch(Context mContext){
        Intent mIntent = new Intent(mContext,Me_BlackNum.class);
        mContext.startActivity(mIntent);
    }
    @OnClick({R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
