package com.hyp.luke.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hyp.luke.R;
import com.hyp.luke.constants.Static_Conmom;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.utils.ValidateUtil;
import com.hyp.luke.widget.LoadingDialog;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class RegisterActivity extends AppCompatActivity implements PlatformActionListener {
    public LoadingDialog mLoadingDialog = new LoadingDialog();
    @BindView(R.id.btn_back)
    ImageView mBtnBack;
    @BindView(R.id.et_register_username)
    EditText mEtUsername;
    @BindView(R.id.et_register_password)
    EditText mEtPassword;
    @BindView(R.id.et_check_pwd)
    EditText mEtCheckPwd;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.iv_login_weibo)
    ImageView mIvLoginWeibo;
    @BindView(R.id.iv_login_qq)
    ImageView mIvLoginQq;
    @BindView(R.id.iv_login_weixin)
    ImageView mIvLoginWeixin;
    private Context mContext = RegisterActivity.this;
    private Handler mHandler = new Handler();
    private String username, password, checkPwd,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        ButterKnife.bind(this);
//        ShareSDK.initSDK(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void launch(Context mContext) {
        Intent mIntent = new Intent(mContext, RegisterActivity.class);
        mContext.startActivity(mIntent);
    }

    @OnClick({R.id.btn_back, R.id.btn_register, R.id.iv_login_weixin, R.id.iv_login_qq, R.id.iv_login_weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_register:
                toRegister();
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

    //注册
    private void toRegister() {
        username = mEtUsername.getText().toString();
        password = mEtPassword.getText().toString();
        checkPwd = mEtCheckPwd.getText().toString();
        if (!ValidateUtil.isMobilePhone(username)) {
            ToastUtil.showShort(mContext, "请填写正确的手机号");
        } else if (!ValidateUtil.isPassword(password)) {
            ToastUtil.showShort(mContext, "密码由数字和字母组成，6-18位");

        } else if (!password.equals(checkPwd)) {
            ToastUtil.showShort(mContext, "密码输入不一致");
        }else {
            mBtnRegister.setEnabled(false);
            mIvLoginWeibo.setEnabled(false);
            mIvLoginQq.setEnabled(false);
            mIvLoginWeixin.setEnabled(false);
            BmobUser user = new BmobUser();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.signUp(new SaveListener<BmobUser>() {
                @Override
                public void done(BmobUser user, BmobException e) {
                    if (e == null) {
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        LoginActivity.launch(mContext);

                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        mBtnRegister.setEnabled(true);
                        mIvLoginWeibo.setEnabled(true);
                        mIvLoginQq.setEnabled(true);
                        mIvLoginWeixin.setEnabled(true);


                    }
                }
            });
        }

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
                    ToastUtil.showLong(RegisterActivity.this, "userid:" + platDB.getUserId() + "username:" + platDB.getUserName() + "登录成功!");
                    platform.removeAccount();//清除第三方缓存信息
                }
            });
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        ToastUtil.showShort(RegisterActivity.this, "授权失败!");
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


}
