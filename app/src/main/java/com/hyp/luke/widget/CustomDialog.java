package com.hyp.luke.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;

import com.alibaba.fastjson.JSON;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.hyp.luke.constants.Static_Conmom;
import com.hyp.luke.utils.Only_CallBack;
import com.hyp.luke.utils.ToastUtil;

import java.io.IOException;
import java.util.ArrayList;

import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.listeners.OnItemPickListener;
import cn.addapp.pickers.listeners.OnSingleWheelListener;
import cn.addapp.pickers.picker.SinglePicker;
import cn.addapp.pickers.util.ConvertUtils;

/**
 * Created by  HuangYP on 2017/5/27 0027.
 */

public class CustomDialog {
    /**
     * ActionSheetDialog有标题弹出框
     *
     * @param context
     * @param callBack
     */
    public static void DialogTitle(Context context, String title,String[] content, final Only_CallBack callBack) {

        ActionSheetDialog dialog = new ActionSheetDialog(context, content, null);
        dialog.title(title)//
                .titleTextSize_SP(14.5f)//
                .show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
               callBack.isSuccess(""+position);
            }
        });


    }

    /**
     * 无标题弹出框
     *
     * @param context
     * @param callBack
     */
    public static void DialogNoTitle(Context context, String[] content, final Only_CallBack callBack) {

        ActionSheetDialog dialog = new ActionSheetDialog(context, content, null);
        dialog.titleTextSize_SP(14.5f)//
                .show();
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                callBack.isSuccess(""+position);
            }
        });


    }

}
