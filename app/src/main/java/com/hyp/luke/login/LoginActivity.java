package com.hyp.luke.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.constants.Static_Conmom;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.utils.ValidateUtil;
import com.hyp.luke.widget.CustomVideoView;
import com.hyp.luke.widget.Dialog_Show;
import com.hyp.luke.widget.LoadingDialog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends AppCompatActivity implements PlatformActionListener {

    public LoadingDialog mLoadingDialog = new LoadingDialog();
    @BindView(R.id.videoview)
    CustomVideoView mVideoview;
    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvForgetPwd;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.iv_login_weibo)
    ImageView mIvLoginWeibo;
    @BindView(R.id.iv_login_qq)
    ImageView mIvLoginQq;
    @BindView(R.id.iv_login_weixin)
    ImageView mIvLoginWeixin;
    private Context mContext = LoginActivity.this;
    private Handler mHandler = new Handler();
    private String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        ButterKnife.bind(this);
        //加载数据
        initView();

    }

    private void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏
        //加载视频资源控件
        mVideoview = (CustomVideoView) findViewById(R.id.videoview);
        //设置播放加载路径
        mVideoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        //播放
        mVideoview.start();
        //循环播放
        mVideoview.setOnCompletionListener(mediaPlayer -> mVideoview.start());
    }
    public static void launch(Context mContext){
        Intent mIntent = new Intent(mContext,LoginActivity.class);
        mContext.startActivity(mIntent);
    }
    @OnClick({R.id.btn_login, R.id.tv_forget_pwd, R.id.tv_register, R.id.iv_login_qq, R.id.iv_login_weibo, R.id.iv_login_weixin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login://登录
                toLogin();

                break;
            case R.id.tv_forget_pwd:
                Dialog_Show.showList(mContext, result -> {
                    switch (result) {
                        case "0"://重置密码
                            ResetPwdActivity.launch(mContext);
                            break;
                        case "1"://使用手机验证码登陆
                            ForgetActivity.launch(mContext);
                            break;
                    }
                });
                break;
            case R.id.tv_register:
                RegisterActivity.launch(mContext);
                break;
            case R.id.iv_login_weibo:
                threeLogin("微博");
                break;
            case R.id.iv_login_qq:
                threeLogin("QQ");
                break;
            case R.id.iv_login_weixin:
                threeLogin("微信");
                break;

        }
    }
    //登陆
    private void toLogin() {
        username = mEtUsername.getText().toString();
        password = mEtPassword.getText().toString();
        if(!ValidateUtil.isEmpty(username)){
            ToastUtil.showShort(mContext,"请输入账号");
//            mEtUsername.setFocusable(true);
        }else if(!ValidateUtil.isEmpty(password)){
            ToastUtil.showShort(mContext,"请输入密码");
//            mEtPassword.setFocusable(true);
        }
        mLoadingDialog.show(mContext);
        mTvRegister.setEnabled(false);//为了避免用户重复点击登录按钮，在开始执行登录请求时将登录按钮设置为不可用状态
        mTvRegister.setEnabled(false);
        mIvLoginWeibo.setEnabled(false);
        mIvLoginQq.setEnabled(false);
        mIvLoginWeixin.setEnabled(false);
        BmobUser.loginByAccount(username, password, new LogInListener<BmobUser>() {

            @Override
            public void done(BmobUser user, BmobException e) {
                // TODO Auto-generated method stub
                if(user!=null){
                    ToastUtil.showShort(mContext,"登陆成功");
                    mLoadingDialog.cancel();
                }else{
                    mLoadingDialog.cancel();
                    ToastUtil.showShort(mContext,"账号或密码错误");
                    mTvRegister.setEnabled(true);
                    mTvRegister.setEnabled(true);
                    mIvLoginWeibo.setEnabled(true);
                    mIvLoginQq.setEnabled(true);
                    mIvLoginWeixin.setEnabled(true);
                }
            }
        });
    }

    //第三方登录
    private void threeLogin(String type) {
        mLoadingDialog.show(mContext);
        switch (type) {
            case "QQ":
                Platform qq = ShareSDK.getPlatform(QQ.NAME);

                qq.setPlatformActionListener(this);// 设置分享事件回调
                // 关闭SSO授权
                qq.SSOSetting(false);
                qq.showUser(null);//授权并获取用户信息
                Static_Conmom.ThreeLogin_Type = "QQ";

                break;
            case "微信":
                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);

                wechat.SSOSetting(false);  //设置false表示使用SSO授权方式

                wechat.setPlatformActionListener(this); // 设置分享事件回调

                wechat.showUser(null);
                Static_Conmom.ThreeLogin_Type = "wechat";

                break;
            case "微博":
                Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);

                weibo.SSOSetting(false);  //设置false表示使用SSO授权方式

                weibo.setPlatformActionListener(this); // 设置分享事件回调

                weibo.showUser(null);
                Static_Conmom.ThreeLogin_Type = "weibo";

                break;
        }

    }

    @Override //点击后退弹出确认框
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            Dialog_Show.showTwoButton(mContext, "警告", "是否退出Luke?", "返回", "退出", result -> {
                if (result.equals("2")) {
                    ShareSDK.stopSDK(LoginActivity.this);
                    System.exit(0);
                }
            });
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //第三方回调开始
    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        Log.i("登录类型", Static_Conmom.ThreeLogin_Type);

        if (i == Platform.ACTION_USER_INFOR) {
            final PlatformDb platDB = platform.getDb();//获取数平台数据DB

            //通过DB获取各种数据
            Log.i("token", platDB.getToken());
            Log.i("usergender", platDB.getUserGender());
            Log.i("usericon", platDB.getUserIcon());
            Log.i("userid", platDB.getUserId());
            Log.i("username", platDB.getUserName());

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    ToastUtil.showLong(LoginActivity.this, "userid:" + platDB.getUserId() + "username:" + platDB.getUserName() + "登录成功!");
                    platform.removeAccount();//清除第三方缓存信息
                }
            });
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        ToastUtil.showShort(LoginActivity.this, "授权失败!");
    }

    @Override
    public void onCancel(Platform platform, int i) {
        ToastUtil.showShort(getApplicationContext(), "取消授权!");
    }

    //第三方回调结束
    @Override
    public void onResume() {
        super.onResume();
        mLoadingDialog.cancel();
    }

    //返回重启加载
    @Override
    protected void onRestart() {
        initView();
        super.onRestart();
    }

    //防止锁屏或者切出的时候，音乐在播放
    @Override
    protected void onStop() {
        mVideoview.stopPlayback();
        super.onStop();
    }
}
