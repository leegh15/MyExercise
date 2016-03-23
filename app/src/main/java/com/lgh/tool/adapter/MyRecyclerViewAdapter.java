package com.lgh.tool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lgh.tool.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/19.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements View.OnClickListener {

    private MyViewHolder myViewHolder;
    private Context context;
    private List<String> mData;
    private OnRecyclerViewClickListener listener=null;
    public MyRecyclerViewAdapter (Context context,List<String> mData){
        this.context=context;
        this.mData=mData;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        myViewHolder=new MyViewHolder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        myViewHolder.tv.setText(mData.get(position));

        myViewHolder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onItemClick(v, (Integer) v.getTag());
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.tv_item);
        }

    }
    public void setOnItemClickListener(OnRecyclerViewClickListener listener){

            this.listener=listener;
    }
    public static interface OnRecyclerViewClickListener{
        void onItemClick(View v,int position);
    }
}
