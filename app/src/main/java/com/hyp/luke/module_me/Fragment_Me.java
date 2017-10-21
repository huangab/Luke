package com.hyp.luke.module_me;


import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doublewave.DoubleWaveView;
import com.hyp.luke.R;
import com.hyp.luke.module_me.collection.Me_Collection;
import com.hyp.luke.module_me.draft.Me_Draft;
import com.hyp.luke.module_me.other.Me_AboutApp;
import com.hyp.luke.module_me.other.Me_Feedback;
import com.hyp.luke.module_me.other.Me_Upgrade;
import com.hyp.luke.module_me.setting.Me_Setting;
import com.hyp.luke.module_me.subscribe.Me_Subscribe;
import com.hyp.luke.utils.cacheUtil;
import com.hyp.luke.widget.Dialog_Show;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
/**
 * Created by  HuangYP on 2017/4/26 0026.
 */

public class Fragment_Me extends Fragment {
    @BindView(R.id.waveView)
    DoubleWaveView mWaveView;
    Unbinder unbinder;
    @BindView(R.id.iv_me_setting)
    ImageView mIvMeSetting;
    @BindView(R.id.ll_article_draft)
    LinearLayout mLlArticleDraft;
    @BindView(R.id.ll_all_collection)
    LinearLayout mLlAllCollection;
    @BindView(R.id.ll_subscribe_manage)
    LinearLayout mLlSubscribeManage;
    @BindView(R.id.ll_accounta_upgrade)
    LinearLayout mLlAccountaUpgrade;
    @BindView(R.id.ll_recommend)
    LinearLayout mLlRecommend;
    @BindView(R.id.ll_feedback)
    LinearLayout mLlFeedback;
    @BindView(R.id.ll_check_up_date)
    LinearLayout mLlCheckUpDate;
    @BindView(R.id.tv_clean_cache)
    TextView mTvCleanCache;
    @BindView(R.id.ll_clean_cache)
    LinearLayout mLlCleanCache;
    @BindView(R.id.ll_about_app)
    LinearLayout mLlAboutApp;
    @BindView(R.id.iv_me_information_image)
    RoundedImageView mMeHead;
    String cacheSize = "";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_me, null);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;

    }

    private void initView() {
        //得到当前界面的装饰视图
        View decorView = getActivity().getWindow().getDecorView();
        // SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN会将状态栏透明显示
        //设置系统UI元素的可见性
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.iv_me_setting, R.id.ll_article_draft, R.id.ll_all_collection, R.id.ll_subscribe_manage, R.id.ll_accounta_upgrade,
            R.id.ll_recommend, R.id.ll_feedback, R.id.ll_check_up_date, R.id.ll_clean_cache, R.id.ll_about_app,R.id.iv_me_information_image})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_me_setting://设置
                Me_Setting.launch(getActivity());
                break;
            case R.id.iv_me_information_image://头像

                break;
            case R.id.ll_article_draft://文章草稿
                Intent DIntent=new Intent(getActivity(), Me_Draft.class);
                startActivity(DIntent);
                break;
            case R.id.ll_all_collection://我的收藏
                Intent CIntent=new Intent(getActivity(), Me_Collection.class);
                startActivity(CIntent);
                break;
            case R.id.ll_subscribe_manage://我的订阅
                Intent SIntent=new Intent(getActivity(), Me_Subscribe.class);
                startActivity(SIntent);
                break;
            case R.id.ll_accounta_upgrade://账号升级
                Intent UIntent=new Intent(getActivity(), Me_Upgrade.class);
                startActivity(UIntent);
                break;
            case R.id.ll_recommend://推荐给好友
                showShare();
                break;
            case R.id.ll_feedback://反馈与意见
                Intent FIntent=new Intent(getActivity(), Me_Feedback.class);
                startActivity(FIntent);
                break;
            case R.id.ll_check_up_date://检查更新
                break;
            case R.id.ll_clean_cache://清除缓存
                String text = "是否清除缓存?";
                Dialog_Show.showTwoButton(this.getActivity(), "温馨提示", text, "取消", "确定",
                        result -> {
                            if (result.equals("2")) {


                                cacheUtil.clearAllCache(this.getActivity());
                                try {
                                    cacheSize = cacheUtil.getTotalCacheSize(this.getActivity());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                mTvCleanCache.setText(cacheSize);
                            }
                        });


                break;
            case R.id.ll_about_app://关于应用
                Intent AIntent=new Intent(getActivity(), Me_AboutApp.class);
                startActivity(AIntent);
                break;
        }
    }

    private void showShare() {
        ShareSDK.initSDK(this.getActivity());
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this.getActivity());
    }


}
