package com.hyp.luke.module_me.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.AddressPickTask;
import com.hyp.luke.widget.CustomDialog;
import com.kyleduo.switchbutton.SwitchButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;

/**
 * Created by  HuangYP on 2017/5/25 0025.
 */

public class Me_DcInfo extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.tv_dcinfo_city)
    TextView mTvDcinfoCity;
    @BindView(R.id.tv_dcinfo_type)
    TextView mTvDcinfoType;
    @BindView(R.id.tv_dcinfo_area)
    EditText mTvDcinfoArea;
    @BindView(R.id.tv_dcinfo_budget)
    EditText mTvDcinfoBudget;
    @BindView(R.id.tv_dcinfo_style)
    TextView mTvDcinfoStyle;
    @BindView(R.id.sb_dcinfo_switch)
    SwitchButton mSbDcinfoSwitch;
    Context mContext = Me_DcInfo.this;
    ArrayList<Province> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_setting_dcinfo);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText("我的装修信息");
    }

    public static void launch(Context mContext){
        Intent mIntent = new Intent(mContext,Me_DcInfo.class);
        mContext.startActivity(mIntent);
    }
    @OnClick({R.id.btn_back, R.id.tv_dcinfo_city, R.id.tv_dcinfo_type, R.id.tv_dcinfo_area, R.id.tv_dcinfo_budget, R.id.tv_dcinfo_style, R.id.sb_dcinfo_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.tv_dcinfo_city://所在城市
                DeInfoCity();
                break;
            case R.id.tv_dcinfo_type://房屋类型
                DeInfoType();
                break;
            case R.id.tv_dcinfo_area://面积
                DeInfoArea();
                break;
            case R.id.tv_dcinfo_budget://预算
                DeInfoBudget();
                break;
            case R.id.tv_dcinfo_style://风格
                DeInfoStyle();
                break;
            case R.id.sb_dcinfo_switch:
                switchButton_Click(true);
                break;
        }
    }

    /**
     * switchbutton的状态改变
     *
     * @param type
     */
    private void switchButton_Click(boolean type) {
        if (mSbDcinfoSwitch.isChecked()) {
            if (type) {
                mSbDcinfoSwitch.setChecked(true);
                ToastUtil.showShort(mContext,"开");
            }
        } else {
            if (type) {
                mSbDcinfoSwitch.setChecked(false);
                ToastUtil.showShort(mContext,"关");

            }

        }

    }

    private void DeInfoBudget() {
        String budget = mTvDcinfoBudget.getText().toString();
        ToastUtil.showShort(mContext,budget);
        //上传到云后端（未完成）
    }

    private void DeInfoArea() {
        String area = mTvDcinfoArea.getText().toString();
        ToastUtil.showShort(mContext,area);
        //上传到云后端（未完成）
    }

    private void DeInfoCity() {

        AddressPickTask task= new AddressPickTask(this);
        task.setHideCounty(true);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                ToastUtil.showShort(mContext, "数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                mTvDcinfoCity.setText(city.getAreaName());
            }
        });
        task.execute("福建省", "厦门市");
    }
    private void DeInfoType() {
        String[] stringItems = {"公寓", "别墅"};
        CustomDialog.DialogTitle(mContext,"房屋类型",stringItems,result -> {

            ToastUtil.showShort(mContext,result);
        });
    }
    private void DeInfoStyle() {
        String[] stringItems = {"北欧", "日式","美式","中式", "地中海","混搭","欧式","东南亚","简约"};
        CustomDialog.DialogTitle(mContext,"风格偏好",stringItems,result -> {
            ToastUtil.showShort(mContext,result);
        });
    }
}
