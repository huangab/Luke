package com.hyp.luke.module_me.other;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.http.bean.Init;

/**
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_AboutStandard extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.web_standard)
    WebView mWebStandard;
    private Activity mActivity = Me_AboutStandard.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_about_standard);
        ButterKnife.bind(this);
        init();

    }
    public static void launch(Context mContext){
        Intent mIntent =new Intent(mContext,Me_AboutStandard.class);
        mContext.startActivity(mIntent);
    }
    private void init() {
        mTvTitle.setText("用户协议");
        mWebStandard.getSettings().setJavaScriptEnabled(true);
        mWebStandard.getSettings().setSupportMultipleWindows(true);
        mWebStandard.getSettings().setUseWideViewPort(true);

        mWebStandard.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebStandard.loadUrl("http://baidu.com/");
        ToastUtil.showShort(mActivity, "网页测试...");
    }

    @OnClick({R.id.btn_back, R.id.web_standard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

        }
    }
}