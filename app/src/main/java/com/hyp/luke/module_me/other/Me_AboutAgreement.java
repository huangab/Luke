package com.hyp.luke.module_me.other;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_AboutAgreement extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.web_aggreement)
    WebView mWebAggreement;
    private Activity mActivity  =Me_AboutAgreement.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_about_agreement);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        mTvTitle.setText("用户协议");
        mWebAggreement.getSettings().setJavaScriptEnabled(true);
        mWebAggreement.getSettings().setSupportMultipleWindows(true);
        mWebAggreement.getSettings().setUseWideViewPort(true);

        mWebAggreement.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebAggreement.loadUrl("http://baidu.com/");
        ToastUtil.showShort(mActivity, "网页测试...");
    }
public static void launch(Context mContext){
    Intent mIntent =new Intent(mContext,Me_AboutAgreement.class);
    mContext.startActivity(mIntent);
}
    @OnClick({R.id.btn_back, R.id.web_aggreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;

        }
    }
}
