package com.hyp.luke.module_me.other;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.module_me.Fragment_Me;
import com.hyp.luke.utils.ToastUtil;
import com.hyp.luke.widget.Dialog_Show;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_AboutContact extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.ll_contact_tel)
    LinearLayout mLlContactTel;
    @BindView(R.id.ll_contact_email)
    LinearLayout mLlContactEmail;
    @BindView(R.id.tv_tel)
    TextView mTvTel;
    private Context mContext =Me_AboutContact.this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_about_contact);
        ButterKnife.bind(this);
        init();
    }

    public static void launch(Context mContext) {
        Intent mIntent = new Intent(mContext, Me_AboutContact.class);
        mContext.startActivity(mIntent);
    }

    private void init() {
        mTvTitle.setText("联系我们");
    }

    @OnClick({R.id.btn_back, R.id.ll_contact_tel, R.id.ll_contact_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.ll_contact_tel:
                Dialog_Show.showTwoButton(Me_AboutContact.this,"1008611","工作时间：09：00-20：00","我再想想","立刻联系", result -> {
                  if(result.equals("2")){
                      String number = mTvTel.getText().toString();
                      //用intent启动拨打电话
                      Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                          // TODO: Consider calling
                          //    ActivityCompat#requestPermissions
                          // here to request the missing permissions, and then overriding
                          //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                          //                                          int[] grantResults)
                          // to handle the case where the user grants the permission. See the documentation
                          // for ActivityCompat#requestPermissions for more details.
                          return;
                      }
                      startActivity(intent);
                  }
                });

                break;
            case R.id.ll_contact_email:
                Intent data = new Intent(Intent.ACTION_SENDTO);
                data.setData(Uri.parse("mailto:yphuang0@qq.com"));
//                String address[]= new String[]{"yphuang0@qq.com"};
//                data.putExtra(Intent.EXTRA_EMAIL, address);
                startActivity(data);
                break;
        }
    }
}