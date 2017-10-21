package com.hyp.luke.module_me.other;


import android.content.Context;
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
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_AboutApp extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.ll_about_agreement)
    LinearLayout mLlAboutAgreement;
    @BindView(R.id.ll_about_contact)
    LinearLayout mLlAboutContact;
    @BindView(R.id.ll_about_standard)
    LinearLayout mLlAboutStandard;
    private Context mContext = Me_AboutApp.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_about_app);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText("关于Luke");
    }

    @OnClick({R.id.btn_back, R.id.ll_about_agreement, R.id.ll_about_contact, R.id.ll_about_standard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.ll_about_agreement://用户协议
                Me_AboutAgreement.launch(mContext);
                break;
            case R.id.ll_about_contact://联系我们
                Me_AboutContact.launch(mContext);
                break;
            case R.id.ll_about_standard://社区规范
                Me_AboutStandard.launch(mContext);
                break;
        }
    }
}
