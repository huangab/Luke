package com.hyp.luke.module_me.subscribe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by  HuangYP on 2017/6/4 0004.
 */

public class Me_Subscribe extends AppCompatActivity {
    @BindView(R.id.me_flow_space)
    TagFlowLayout mMeFlowSpace;
    @BindView(R.id.me_flow_hard)
    TagFlowLayout mMeFlowHard;
    @BindView(R.id.me_flow_solf)
    TagFlowLayout mMeFlowSolf;
    @BindView(R.id.me_flow_hot)
    TagFlowLayout mMeFlowHot;
    private StringTagAdapter spaceAdapter,hardAdapter,solfAdapter,hotAdapter;

    private List<String> spaceData,hardData,solfData,hotData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.me_subscribe_manage);
        ButterKnife.bind(this);
        initData();
        initViews();
    }

    private void initData() {
        spaceData = new ArrayList<>();
        spaceData.add("客厅");
        spaceData.add("卫生间");
        spaceData.add("厨房");
        spaceData.add("卧室");
        spaceData.add("阳台");
        spaceData.add("玄关");
        spaceData.add("餐厅");

        hardData = new ArrayList<>();
        hardData.add("瓷砖");
        hardData.add("门");
        hardData.add("橱柜");
        hardData.add("地板");
        hardData.add("吧台");
        hardData.add("洗漱台");

        solfData = new ArrayList<>();
        solfData.add("窗帘");
        solfData.add("绿植");
        solfData.add("衣柜");
        solfData.add("床");
        solfData.add("沙发");
        solfData.add("装饰画");
        solfData.add("地毯");

        hotData = new ArrayList<>();
        hotData.add("收纳");
        hotData.add("小户型");
        hotData.add("电视背景墙");
        hotData.add("飘窗");
        hotData.add("榻榻米");
        hotData.add("家庭工作区");
        hotData.add("装修经验");
        hotData.add("生活技能");
        hotData.add("大家的家");
    }

    private void initViews() {
        spaceAdapter = new StringTagAdapter(this, spaceData);
        spaceAdapter.setOnSubscribeListener(selectedItem -> {
            ToastUtil.showShort(Me_Subscribe.this, "已选择" + selectedItem.size() + "个");
        });
        mMeFlowSpace.setAdapter(spaceAdapter);

        hardAdapter = new StringTagAdapter(this, hardData);
        hardAdapter.setOnSubscribeListener(selectedItem -> {
            ToastUtil.showShort(Me_Subscribe.this, "已选择" + selectedItem.size() + "个");
        });
        mMeFlowHard.setAdapter(hardAdapter);

        solfAdapter = new StringTagAdapter(this, solfData);
        solfAdapter.setOnSubscribeListener(selectedItem -> {
            ToastUtil.showShort(Me_Subscribe.this, "已选择" + selectedItem.size() + "个");
        });
        mMeFlowSolf.setAdapter(solfAdapter);

        hotAdapter = new StringTagAdapter(this, hotData);
        hotAdapter.setOnSubscribeListener(selectedItem -> {
            ToastUtil.showShort(Me_Subscribe.this, "已选择" + selectedItem.size() + "个");
        });
        mMeFlowHot.setAdapter(hotAdapter);
    }


}

