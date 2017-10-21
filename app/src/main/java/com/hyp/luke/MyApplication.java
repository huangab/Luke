package com.hyp.luke;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import cn.bmob.v3.Bmob;
import cn.sharesdk.framework.ShareSDK;
import cn.smssdk.SMSSDK;

/**
 * Created by  HuangYP on 2017/5/18 0018.
 *
 Bmob.initialize(this, String.valueOf(R.string.Application_ID));
 ShareSDK.initSDK(mContext,"1decbbd91df76");
 */

public class MyApplication extends Application {
    public static Context context;
    public static String[] forgetItems = {"重置密码","使用手机验证码登录"};//找回密码方式
    public static Gson gson;
    public static Gson gsonInstance() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "31874f984748c55e354a4af8b8491221");
        SMSSDK.initSDK(this, "1a4332c76fd54", "e3ec5388b7cd207c1e27305905ad89d2");
        ShareSDK.initSDK(this,"1decbbd91df76");

    }
}
