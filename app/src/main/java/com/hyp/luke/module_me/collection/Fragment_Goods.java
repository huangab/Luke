package com.hyp.luke.module_me.collection;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyp.luke.R;

/**
 * Created by  HuangYP on 2017/5/31 0031.
 */

public class Fragment_Goods  extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me_collection_goods,container,false);
    }
}
