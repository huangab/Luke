package com.hyp.luke.module_home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hyp.luke.R;
import com.hyp.luke.module_home.bean.DayEntity;
import com.hyp.luke.utils.ToastUtil;

import java.util.ArrayList;

/**
 * Created by  HuangYP on 2017/6/26 0026.
 */

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder>{
    private ArrayList<DayEntity> mList;
    private Context mContext;
    public DayAdapter(Context context,ArrayList<DayEntity> list) {
        mContext = context;
        mList = list;
    }
    public void update(ArrayList<DayEntity> list) {
        mList = list;
        notifyDataSetChanged();
    }
    @Override
    public DayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_day,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DayEntity info =mList.get(position);
        if(info.getContent().get(position).getContenttype().equals("ablum")){
            //如果story为空，则显示ablum数据
            Glide.with(mContext).load(info.getContent().get(position).getCoverurl()).into(holder.img);
            holder.name.setText(info.getContent().get(position).getAblum().getAblumname());
            holder.subhead.setText(info.getContent().get(position).getAblum().getSubhead());
            holder.count.setText(info.getContent().get(position).getAblum().getStorycount()+"");
            holder.price.setText(info.getContent().get(position).getAblum().getProduct().getRealityprice()+"元");
        }else{
            Glide.with(mContext).load(info.getContent().get(position).getCoverurl()).into(holder.img);
            holder.name.setText(info.getContent().get(position).getStory().getStoryname());
            holder.subhead.setText(info.getContent().get(position).getStory().getSubhead());
            holder.price.setText("");
            holder.count.setText("");
        }


        holder.itemView.setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, PlaylistActivity.class);
//            intent.putExtra("storycount", info.getContent().get(position).getAblum().getStorycount());
//            intent.putExtra("islocal", false);
//            intent.putExtra("ablumname", info.getContent().get(position).getAblum().getAblumname());
//            intent.putExtra("coverurl", info.getContent().get(position).getAblum().getIconurl());
//
//            mContext.startActivity(intent);
            ToastUtil.showShort(mContext,"HHHHHHHHHHHHH");
        });

    }

    @Override
    public int getItemCount() {
       return mList.size();
    }

   class MyViewHolder extends RecyclerView.ViewHolder {
       private ImageView img;
       private TextView name, subhead,count,price;

       public MyViewHolder(View itemView) {
           super(itemView);
           img = (ImageView) itemView.findViewById(R.id.sd_day_art);
           name = (TextView) itemView.findViewById(R.id.tv_day_name);
           subhead = (TextView) itemView.findViewById(R.id.tv_day_subname);
           price = (TextView) itemView.findViewById(R.id.tv_day_price);
           count = (TextView) itemView.findViewById(R.id.tv_day_listencount);
       }
    }
}
