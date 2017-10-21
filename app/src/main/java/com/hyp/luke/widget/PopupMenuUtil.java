package com.hyp.luke.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.hyp.luke.R;


/**
 * Created by mj
 * on 2016/10/28.
 */
public class PopupMenuUtil {

    private static final String TAG = "PopupMenuUtil";

    public static PopupMenuUtil getInstance() {
        return MenuUtilHolder.INSTANCE;
    }

    private static class MenuUtilHolder {
        public static PopupMenuUtil INSTANCE = new PopupMenuUtil();
    }

    private View rootVew;
    private PopupWindow popupWindow;
    private ImageView ivTabPost;
    private LinearLayout publishPhoto,publishHouse;
    private TextView tvPhoto,tvHouse;

    /**
     * 动画执行的 属性值数组
     */
    float animatorProperty[] = null;
    /**
     * 第一排图 距离屏幕底部的距离
     */
    int top = 0;
    /**
     * 第二排图 距离屏幕底部的距离
     */
    int bottom = 0;

    /**
     * 创建 popupWindow 内容
     *
     * @param context context
     */
    private void _createView(final Context context) {
        rootVew = LayoutInflater.from(context).inflate(R.layout.popup_menu, null);
        popupWindow = new PopupWindow(rootVew,
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        //设置为失去焦点 方便监听返回键的监听
        popupWindow.setFocusable(false);

        // 如果想要popupWindow 遮挡住状态栏可以加上这句代码
        //popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(false);

        if (animatorProperty == null) {
            top = dip2px(context, 10);
            bottom = dip2px(context, 90);
            animatorProperty = new float[]{bottom,60, -30, -20, - 10, 0};
        }

        initLayout(context);
    }

    /**
     * dp转化为px
     *
     * @param context  context
     * @param dipValue dp value
     * @return 转换之后的px值
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 初始化 view
     */
    private void initLayout(Context context) {
        ivTabPost = (ImageView) rootVew.findViewById(R.id.iv_tab_post);
        publishPhoto = (LinearLayout) rootVew.findViewById(R.id.ll_publish_photo);
        publishHouse = (LinearLayout) rootVew.findViewById(R.id.ll_publish_house);
        tvPhoto = (TextView) rootVew.findViewById(R.id.tv_publish_photo);
        tvHouse = (TextView) rootVew.findViewById(R.id.tv_publish_house);

        ivTabPost.setOnClickListener(new MViewClick(0, context));

        publishPhoto.setOnClickListener(new MViewClick(1, context));
        publishHouse.setOnClickListener(new MViewClick(2, context));
    }

    /**
     * 点击事件
     */
    private class MViewClick implements View.OnClickListener {

        public int index;
        public Context context;

        public MViewClick(int index, Context context) {
            this.index = index;
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            if (index == 0) {
                //加号按钮点击之后的执行
                ClosePostAction();
            } else {
                showToast(context, "index=" + index);
            }
        }
    }

    Toast toast = null;

    /**
     * 防止toast 多次被创建
     *
     * @param context context
     * @param str     str
     */
    private void showToast(Context context, String str) {
        if (toast == null) {
            toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        } else {
            toast.setText(str);
        }
        toast.show();
    }

    /**
     * 刚打开popupWindow 执行的动画
     */
    private void _openPopupWindowAction() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivTabPost, "rotation", 0f, 135f);
        objectAnimator.setDuration(200);
        objectAnimator.start();

        startAnimation(publishPhoto, 500, animatorProperty);
        startAnimation(publishHouse, 430, animatorProperty);
        startTvAnimation(tvPhoto, 700, 0,1);
        startTvAnimation(tvHouse, 700, 0,1);

    }


    /**
     * 关闭 popupWindow执行的动画
     */
    public void ClosePostAction() {
        if (ivTabPost != null) {

            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivTabPost, "rotation", 135f, 0f);
            objectAnimator.setDuration(300);
            objectAnimator.start();

            closeAnimation(publishPhoto, 300, top);
            closeAnimation(publishHouse, 200, top);


            ivTabPost.postDelayed(new Runnable() {
                @Override
                public void run() {
                    close();
                }
            }, 300);

        }
    }


    /**
     * 弹起 popupWindow
     *
     * @param context context
     * @param parent  parent
     */
    public void show(Context context, View parent) {
        _createView(context);
        if (popupWindow != null && !popupWindow.isShowing()) {
            popupWindow.showAtLocation(parent, Gravity.NO_GRAVITY, 0, 0);
            _openPopupWindowAction();
        }
    }

    /**
     * 关闭popupWindow
     */

    public void close() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
        }
    }

    /**
     * @return popupWindow 是否显示了
     */
    public boolean _isShowing() {
        if (popupWindow == null) {
            return false;
        } else {
            return popupWindow.isShowing();
        }
    }

    /**
     * 关闭 popupWindow 时的动画
     *
     * @param view     mView
     * @param duration 动画执行时长
     * @param  next     平移量
     */
    private void closeAnimation(View view, int duration, int next) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", next);
        anim.setDuration(duration);
        anim.start();
    }

    /**
     * 启动动画
     *
     * @param view     view
     * @param duration 执行时长
     * @param distance 执行的轨迹数组
     */
    private void startAnimation(View view, int duration, float[] distance) {

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "translationY", distance);
        anim.setDuration(duration);
        anim.start();
    }
    private void startTvAnimation(View view, int duration,int start,int end) {

        ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", start,end);
        anim.setDuration(duration);
        anim.start();
    }

}
