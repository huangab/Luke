package com.hyp.luke.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.Dialog_Show;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import static com.hyp.luke.widget.Dialog_Show.dialog;
//验证码登陆
public class ForgetActivity extends AppCompatActivity {

    private Context mContext = ForgetActivity.this;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.et_phone_num)
    EditText mEtPhoneNum;
    @BindView(R.id.et_verification_code)
    EditText mEtVerificationCode;
    @BindView(R.id.btn_get_code)
    Button mBtnGetCode;
    @BindView(R.id.btn_check_code)
    Button mBtnCheckCode;
    private TimerTask tt;
    private Timer tm;
    private String phone,code;
    private int TIME = 60;//倒计时60s这里应该多设置些因为mob后台需要60s,我们前端会有差异的建议设置90，100或者120
    public String country = "86";//这是中国区号，如果需要其他国家列表，可以使用getSupportedCountries();获得国家区号
    private static final int CODE_REPEAT = 1; //重新发送
    Handler hd = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == CODE_REPEAT) {
                mBtnGetCode.setEnabled(true);
                mBtnCheckCode.setEnabled(true);
                tm.cancel();//取消任务
                tt.cancel();//取消任务
                TIME = 60;//时间重置
                mBtnGetCode.setText("重新发送验证码");
            } else {
                mBtnGetCode.setText("重发"+TIME);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_forget);
        ButterKnife.bind(this);
        SMSSDK.registerEventHandler(eh); //注册短信回调（记得销毁，避免泄露内存）
        initView();

    }

    //回调
    EventHandler eh = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {
            phone= mEtPhoneNum.getText().toString();
            code =mEtVerificationCode.getText().toString();
            if (result == SMSSDK.RESULT_COMPLETE) {
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    ToastUtil.showShort(mContext, "验证成功");
                    //登陆操作
                    BmobUser.signOrLoginByMobilePhone(phone,code, new LogInListener<BmobUser>() {

                        @Override
                        public void done(BmobUser user, BmobException e) {
                            // TODO Auto-generated method stub
                            if(user!=null){
                                Log.i("smile","用户登陆成功");
                            }
                        }
                    });

                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {       //获取验证码成功
                    ToastUtil.showShort(mContext, "获取验证码成功");
                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {//如果你调用了获取国家区号类表会在这里回调
                    //返回支持发送验证码的国家列表
                }
            } else {//错误等在这里（包括验证失败）
                //错误码请参照http://wiki.mob.com/android-api-错误码参考/这里我就不再继续写了
                ((Throwable) data).printStackTrace();
                String str = data.toString();
                ToastUtil.showShort(mContext, str);
            }
        }
    };

    private void initView() {
        mTvTitle.setText("验证码登陆");
    }

    public static void launch(Context mContext) {
        Intent mIntent = new Intent(mContext, ForgetActivity.class);
        mContext.startActivity(mIntent);
    }

    @OnClick({R.id.btn_back, R.id.btn_get_code, R.id.btn_check_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_get_code:
                GetCode();
                break;
            case R.id.btn_check_code:
                CheckCode();
                break;
        }
    }

    private void CheckCode() {
        //获得用户输入的验证码
        String code = mEtVerificationCode.getText().toString().replaceAll("/s","");
        if (!TextUtils.isEmpty(code)) {//判断验证码是否为空
            //验证
            SMSSDK.submitVerificationCode(country,phone,code);
        }else{//如果用户输入的内容为空，提醒用户
            ToastUtil.showShort(mContext, "请输入验证码后再提交");
        }
    }

    private void GetCode() {
        phone = mEtPhoneNum.getText().toString().trim().replaceAll("/s", "");
        if (!TextUtils.isEmpty(phone)) {
            //定义需要匹配的正则表达式的规则
            String REGEX_MOBILE_SIMPLE = "[1][358]\\d{9}";
            //把正则表达式的规则编译成模板
            Pattern pattern = Pattern.compile(REGEX_MOBILE_SIMPLE);
            //把需要匹配的字符给模板匹配，获得匹配器
            Matcher matcher = pattern.matcher(phone);
            // 通过匹配器查找是否有该字符，不可重复调用重复调用matcher.find()
            if (matcher.find()) {//匹配手机号是否存在
                alterWarning();
            } else {
                ToastUtil.showShort(mContext, "手机号格式错误");
            }
        } else {
            ToastUtil.showShort(mContext, "请先输入手机号");
        }
    }

    //弹窗确认下发
    private void alterWarning() {
        // 2. 通过sdk发送短信验证
        Dialog_Show.showTwoButton(mContext, "提示", "我们将要发送到" + phone + "验证", "取消", "确定", result -> {
            if (result == "2") {
                dialog.dismiss(); //关闭dialog
                // 2. 通过sdk发送短信验证（请求获取短信验证码，在监听（eh）中返回）
                SMSSDK.getVerificationCode(country, phone);
                //做倒计时操作
                ToastUtil.showShort(ForgetActivity.this, "已发送,请注意查收");
                mBtnGetCode.setEnabled(false);
                mBtnCheckCode.setEnabled(true);
                tm = new Timer();
                tt = new TimerTask() {
                    @Override
                    public void run() {
                        hd.sendEmptyMessage(TIME--);
                    }
                };
                tm.schedule(tt, 0, 1000);
            } else {
                dialog.dismiss();
                ToastUtil.showShort(ForgetActivity.this, "已取消");
            }
        });

    }
    //销毁短信注册
    @Override
    protected void onDestroy () {
        super.onDestroy();
        // 注销回调接口registerEventHandler必须和unregisterEventHandler配套使用，否则可能造成内存泄漏。
        SMSSDK.unregisterEventHandler(eh);

    }
}