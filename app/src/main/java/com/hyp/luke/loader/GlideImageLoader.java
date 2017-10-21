package com.hyp.luke.loader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by  HuangYP on 2017/4/26 0026.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
             Glide.with(context.getApplicationContext())
                     .load(path)
                     .into(imageView);
    }
}
