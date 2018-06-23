package com.example.adapterandjson.customAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.adapterandjson.R;

import java.util.List;

/**
 * Created by 爱我请给我二十块 on 2018/6/24.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    public CommonAdapter(Context context,List<T> datas,int layoutId){
        this.mContext=context;
        this.mData=datas;
        this.mLayoutId=layoutId;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public  View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder=ViewHolder.get(mContext,convertView,parent,mLayoutId,position);
        convert(holder,getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder,T t);

}
