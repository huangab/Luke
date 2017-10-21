package com.hyp.luke.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyp.luke.R;
import com.hyp.luke.login.ResetPwdActivity;
import com.hyp.luke.module_me.Fragment_Me;
import com.hyp.luke.module_home.Fragment_Home;
import com.hyp.luke.ui.fragment.F2;
import com.hyp.luke.ui.fragment.F3;
import com.hyp.luke.widget.MainNavigateTabBar;
import com.hyp.luke.widget.PopupMenuUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
  主页面
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG_PAGE_F1 = "首页";
    private static final String TAG_PAGE_F2 = "同城";
    private static final String TAG_PAGE_PUBLISH = "1";
    private static final String TAG_PAGE_F3 = "消息";
    private static final String TAG_PAGE_F4 = "我的";
    @BindView(R.id.mainTabBar)
    MainNavigateTabBar mNavigateTabBar;
    @BindView(R.id.tab_post_icon)
    ImageView mTabPostIcon;
    private SharedPreferences sp;
    private boolean isNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);

        mNavigateTabBar.addTab(Fragment_Home.class, new MainNavigateTabBar.TabParam(R.mipmap.nav_home, R.mipmap.nav_home_pre, TAG_PAGE_F1));
        mNavigateTabBar.addTab(F2.class, new MainNavigateTabBar.TabParam(R.mipmap.nav_discovery, R.mipmap.nav_discovery_pre, TAG_PAGE_F2));
        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(F3.class, new MainNavigateTabBar.TabParam(R.mipmap.nav_gallery, R.mipmap.nav_gallery_pre, TAG_PAGE_F3));
        mNavigateTabBar.addTab(Fragment_Me.class, new MainNavigateTabBar.TabParam(R.mipmap.nav_user, R.mipmap.nav_user_pre, TAG_PAGE_F4));

    }


    public static void launch(Context mContext){
        Intent mIntent = new Intent(mContext,ResetPwdActivity.class);
        mContext.startActivity(mIntent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }


    public void onClickPublish(View v) {
        PopupMenuUtil.getInstance().show(this, mTabPostIcon);
        Toast.makeText(this, "发布", Toast.LENGTH_LONG).show();
    }
}
