package com.hyp.luke.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyp.luke.R;

import butterknife.ButterKnife;

/**
 * Created by  HuangYP on 2017/4/26 0026.
 */

public class F2 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.f2, null);
        ButterKnife.bind(this, mView);

        return mView;
    }





}
