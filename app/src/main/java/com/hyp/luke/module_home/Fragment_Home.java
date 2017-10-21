package com.hyp.luke.module_home;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hyp.luke.MyApplication;
import com.hyp.luke.R;
import com.hyp.luke.loader.GlideImageLoader;
import com.hyp.luke.module_home.adapter.AblumAdapter;
import com.hyp.luke.module_home.adapter.Day365Adapter;
import com.hyp.luke.module_home.adapter.DayAdapter;
import com.hyp.luke.module_home.bean.AblumEntity;
import com.hyp.luke.module_home.bean.Day365Entity;
import com.hyp.luke.module_home.bean.DayEntity;
import com.hyp.luke.utils.HttpUtil;
import com.hyp.luke.widget.NetworkUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by  HuangYP on 2017/4/26 0026.
 */

public class Fragment_Home extends Fragment {
    private Context mContext;
    @BindView(R.id.banner)
    Banner mBanner;
    private static List<?> images = new ArrayList<>();
    @BindView(R.id.rc_home_album)
    RecyclerView mRcHomeAlbum;
    @BindView(R.id.rc_home_day)
    RecyclerView mRcHomeDay;
    @BindView(R.id.rc_home_365)
    RecyclerView mRcHome365;
    @BindView(R.id.ll_home_news)
    LinearLayout mLlHomeNews;
    @BindView(R.id.ll_home_sun)
    LinearLayout mLlHomeSun;
    @BindView(R.id.ll_home_moon)
    LinearLayout mLlHomeMoon;
    @BindView(R.id.ll_home_sapling)
    LinearLayout mLlHomeSapling;
    @BindView(R.id.ll_home_more)
    LinearLayout mLlHomeMore;
    private GridLayoutManager mGridLayoutManager1, mGridLayoutManager2, mGridLayoutManager3;
    private StaggeredGridLayoutManager SlayoutManager;
    private AblumAdapter mAblumAdapter;
    private DayAdapter mDayAdapter;
    private Day365Adapter m365Adapter;
    private ArrayList<AblumEntity> mAblumList = new ArrayList<>();
    private ArrayList<DayEntity> mDaylist = new ArrayList<>();
    private ArrayList<Day365Entity> m365List = new ArrayList<>();
    private boolean isFromCache = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //得到当前界面的装饰视图

        View mView = inflater.inflate(R.layout.fragment_home, null);

        ButterKnife.bind(this, mView);
        setBanner();//轮播图
        mAblumAdapter = new AblumAdapter(getActivity(), null);
        mDayAdapter = new DayAdapter(getActivity(), null);
        m365Adapter = new Day365Adapter(getActivity(), null);
        initView();
//        initData();
        return mView;
    }

    private void initData() {
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... params) {
                if (NetworkUtils.isConnectInternet(mContext)) {
                    isFromCache = false;
                }
                try {
                    JsonObject list = HttpUtil.getResposeJsonObject("https://api.kaishustory.com/homeservice/layout", mContext, isFromCache);

                    JsonObject object = list.get("result").getAsJsonObject();
                    JsonArray jsonArray = object.get("list").getAsJsonArray();
                    JsonObject AlbumArray = jsonArray.get(0).getAsJsonObject();
                    JsonObject DayArray = jsonArray.get(1).getAsJsonObject();
                    JsonObject Day365Array = jsonArray.get(2).getAsJsonObject();
                    for (int i = 0; i < 4; i++) {
                        mAblumList.add(MyApplication.gsonInstance().fromJson(AlbumArray, AblumEntity.class));
                    }
                    for (int i = 0; i < 3; i++) {
                        mDaylist.add(MyApplication.gsonInstance().fromJson(DayArray, DayEntity.class));
                    }
                    for (int i = 0; i < 5; i++) {
                        m365List.add(MyApplication.gsonInstance().fromJson(Day365Array, Day365Entity.class));
                    }


                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                return null;

            }

            @Override
            protected void onPostExecute(Void v) {
                mGridLayoutManager1 = new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false);
                mRcHomeAlbum.setLayoutManager(mGridLayoutManager1);
                mRcHomeAlbum.setAdapter(mAblumAdapter);
                mRcHomeAlbum.setHasFixedSize(true);


                mGridLayoutManager2 = new GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false);
                mRcHomeDay.setLayoutManager(mGridLayoutManager2);
                mRcHomeDay.setAdapter(mDayAdapter);
                mRcHomeDay.setHasFixedSize(true);

                mGridLayoutManager3 = new GridLayoutManager(mContext, 2);
                mRcHome365.setLayoutManager(mGridLayoutManager3);
                mRcHome365.setAdapter(m365Adapter);
                mRcHome365.setHasFixedSize(true);

                mAblumAdapter.update(mAblumList);
                mDayAdapter.update(mDaylist);
                m365Adapter.update(m365List);


            }

        }.execute();

    }

    private void initView() {

    }


    //轮播图
    private void setBanner() {
        String[] urls = getResources().getStringArray(R.array.url);

        List list_i = Arrays.asList(urls);

        images = new ArrayList<>(list_i);
        ////设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(1500);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick({R.id.ll_home_news, R.id.ll_home_sun, R.id.ll_home_moon, R.id.ll_home_sapling, R.id.ll_home_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home_news:

                break;
            case R.id.ll_home_sun:
                break;
            case R.id.ll_home_moon:
                break;
            case R.id.ll_home_sapling:
                break;
            case R.id.ll_home_more:
                break;
        }
    }
}
