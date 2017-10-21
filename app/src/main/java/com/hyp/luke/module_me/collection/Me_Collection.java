package com.hyp.luke.module_me.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hyp.luke.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的收藏
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_Collection extends AppCompatActivity {
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"作品", "图片", "物品"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_collection_main);
        ButterKnife.bind(this);
        //页面，数据源
        list = new ArrayList<>();
        list.add(new Fragment_Works());
        list.add(new Fragment_Picture());
        list.add(new Fragment_Goods());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(adapter);
        //绑定
        mTablayout.setupWithViewPager(mViewpager);
    }

    @OnClick({R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}