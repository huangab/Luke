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
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.Dialog_Show;
import com.kyleduo.switchbutton.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by  HuangYP on 2017/5/23 0023.
 */

public class Me_Setting extends AppCompatActivity {
    Context mContext = Me_Setting.this;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.ll_setting_data)
    LinearLayout mLlSettingData;
    @BindView(R.id.tv_setting_decoration)
    TextView mTvSettingDecoration;
    @BindView(R.id.ll_setting_decoration)
    LinearLayout mLlSettingDecoration;
    @BindView(R.id.ll_setting_security)
    LinearLayout mLlSettingSecurity;
    @BindView(R.id.ll_setting_blacknum)
    LinearLayout mLlSettingBlackNum;
    @BindView(R.id.sb_setting_infoState)
    SwitchButton mSbSwitch;
    @BindView(R.id.bt_setting_quit)
    Button mBtSettingQuit;
    @BindView(R.id.ll_setting_dcinfo)
    LinearLayout mLlSettingDcinfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_setting);
        ButterKnife.bind(this);
        init();
    }



    private void init() {
        mTvTitle.setText("设置");
    }

    public static void launch(Context mContext) {
        Intent mIntent = new Intent(mContext, Me_Setting.class);
        mContext.startActivity(mIntent);
    }

    @OnClick({R.id.tv_title, R.id.btn_back, R.id.ll_setting_data, R.id.ll_setting_decoration, R.id.ll_setting_dcinfo,R.id.ll_setting_security, R.id.ll_setting_blacknum, R.id.sb_setting_infoState, R.id.bt_setting_quit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back://返回
                finish();
                break;
            case R.id.ll_setting_data://编辑个人资料
                Me_Information.launch(mContext);
                break;
            case R.id.ll_setting_decoration://我的装修状态
                Me_Decoration.launch(mContext);
                break;
            case R.id.ll_setting_dcinfo://我的装修信息
                Me_DcInfo.launch(mContext);
                break;
            case R.id.ll_setting_security://账号与安全
                Me_Security.launch(mContext);
                break;
            case R.id.ll_setting_blacknum://黑名单
                Me_BlackNum.launch(mContext);
                break;
            case R.id.sb_setting_infoState://消息通知
                switchButton_Click(true);

                break;
            case R.id.bt_setting_quit://退出
                Dialog_Show.showTwoButton(mContext, "警告", "是否确定退出登录?", "返回", "退出", result -> {
                    if (result.equals("2")) {
                        ToastUtil.showShort(getApplicationContext(), "您已退出!");
                    }
                });
                break;
        }
    }


    /**
     * switchbutton的状态改变
     *
     * @param type
     */
    private void switchButton_Click(boolean type) {
        if (mSbSwitch.isChecked()) {
            if (type) {
                mSbSwitch.setChecked(true);
                ToastUtil.showShort(mContext,"开");
            }
        } else {
            if (type) {
                mSbSwitch.setChecked(false);
                ToastUtil.showShort(mContext,"关");

            }

        }

    }

}
