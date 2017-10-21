package com.hyp.luke.module_me.other;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hyp.luke.R;
import com.hyp.luke.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.http.bean.Init;

/**
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Me_Feedback extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.rbt_feedback_function)
    RadioButton mRbtFeedbackFunction;
    @BindView(R.id.ll_feedback_function)
    LinearLayout mLlFeedbackFunction;
    @BindView(R.id.rbt_feedback_report)
    RadioButton mRbtFeedbackReport;
    @BindView(R.id.ll_feedback_report)
    LinearLayout mLlFeedbackReport;
    @BindView(R.id.rbt_feedback_select)
    RadioButton mRbtFeedbackSelect;
    @BindView(R.id.ll_feedback_select)
    LinearLayout mLlFeedbackSelect;
    @BindView(R.id.rbt_feedback_others)
    RadioButton mRbtFeedbackOthers;
    @BindView(R.id.ll_feedback_others)
    LinearLayout mLlFeedbackOthers;
    @BindView(R.id.editText)
    EditText mEditText;
private Context mContext = Me_Feedback.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_feedback);
        ButterKnife.bind(this);
        init();
    }

    private void init()
    {
        mTvTitle.setText("意见反馈");
        mTvSave.setText("发送");
        mTvSave.setVisibility(View.VISIBLE);

    }

    @OnClick({R.id.btn_back, R.id.tv_save, R.id.ll_feedback_function, R.id.ll_feedback_report, R.id.ll_feedback_select, R.id.ll_feedback_others})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.tv_save:
                ToastUtil.showShort(mContext,"发送成功");
                finish();
                break;
            case R.id.ll_feedback_function:
                break;
            case R.id.ll_feedback_report:
                break;
            case R.id.ll_feedback_select:
                break;
            case R.id.ll_feedback_others:
                break;
        }
    }
}
