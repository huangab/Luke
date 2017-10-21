package com.hyp.luke.module_me.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyp.luke.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by  HuangYP on 2017/5/25 0025.
 */

public class Me_Decoration extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.ll_decoration_no)
    LinearLayout mLlDecorationNo;
    @BindView(R.id.ll_decoration_prepare)
    LinearLayout mLlDecorationPrepare;
    @BindView(R.id.ll_decoration_ing)
    LinearLayout mLlDecorationIng;
    @BindView(R.id.ll_decoration_already)
    LinearLayout mLlDecorationAlready;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_setting_decoration);
        ButterKnife.bind(this);
        init();
    }
public static void launch(Context mContext){
    Intent mIntent = new Intent(mContext,Me_Decoration.class);
    mContext.startActivity(mIntent);
}
    private void init() {
        mTvTitle.setText("我的装修状态");
    }

    @OnClick({R.id.btn_back, R.id.ll_decoration_no, R.id.ll_decoration_prepare, R.id.ll_decoration_ing, R.id.ll_decoration_already})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.ll_decoration_no:
                break;
            case R.id.ll_decoration_prepare:
                break;
            case R.id.ll_decoration_ing:
                break;
            case R.id.ll_decoration_already:
                break;
        }
    }
}
