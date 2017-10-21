package com.hyp.luke.module_me.setting;

import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.AddressPickTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.DatePicker;
import cn.addapp.pickers.picker.DateTimePicker;

/**
 * Created by  HuangYP on 2017/5/23 0023.
 */

public class Me_Information extends AppCompatActivity {

    Context mContext = Me_Information.this;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.ll_me_information_address)
    LinearLayout mLlPosition;
    @BindView(R.id.et_me_information_province)
    TextView mEtProvince;
    @BindView(R.id.et_me_information_city)
    TextView mEtCity;
    @BindView(R.id.et_me_brithday)
    TextView mEtBrithday;
    private  Integer Year;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_setting_information);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText("个人资料");
        mTvSave.setVisibility(View.VISIBLE);
    }

    public static void launch(Context mContext) {
        Intent mIntent = new Intent(mContext, Me_Information.class);
        mContext.startActivity(mIntent);
    }

    @OnClick({R.id.btn_back, R.id.tv_save, R.id.ll_me_information_address,R.id.et_me_brithday})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.tv_save:
                break;
            case R.id.ll_me_information_address:
                onAddressPicker(view);
                break;
            case R.id.et_me_brithday:
                onBrithday(view);
                break;

        }
    }

    public void onAddressPicker(View view) {
        AddressPickTask task = new AddressPickTask(this);
        task.setHideCounty(true);
        task.setCallback(new AddressPickTask.Callback() {
            @Override
            public void onAddressInitFailed() {
                ToastUtil.showShort(mContext, "数据初始化失败");
            }

            @Override
            public void onAddressPicked(Province province, City city, County county) {
                mEtProvince.setText(province.getAreaName());
                mEtCity.setText(city.getAreaName());
                ToastUtil.showShort(mContext, province.getAreaName() + " " + city.getAreaName());
            }
        });
        task.execute("福建省", "厦门市");
    }

    public void onBrithday(View view) {
        final DatePicker picker = new DatePicker(this);
        picker.setCanLoop(false);
        picker.setWheelModeEnable(true);
        picker.setTopPadding(15);
        picker.setRangeStart(1940, 1, 1);
        picker.setRangeEnd(2017, 12, 12);
        picker.setSelectedItem(1991, 1, 1);
        picker.setWeightEnable(true);
        picker.setOnDatePickListener((DatePicker.OnYearMonthDayPickListener) (year, month, day) -> {
                mEtBrithday.setText(year + "-" + month + "-" + day);
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }

}
