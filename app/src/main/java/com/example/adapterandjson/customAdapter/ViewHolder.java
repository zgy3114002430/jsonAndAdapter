package com.example.adapterandjson.customAdapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 爱我请给我二十块 on 2018/6/23.
 */

public class ViewHolder {

    private Context mContext;
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent,int layoutId,int position){
        this.mContext=context;
        mViews=new SparseArray<View>();
        mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,ViewGroup parent,int layoutId,int position){
        if(convertView==null){
            return new ViewHolder(context,parent,layoutId,position);
        }else{
            ViewHolder viewHolder=(ViewHolder)convertView.getTag();
            viewHolder.mPosition=position;
            return viewHolder;
        }
    }
    //通过viewId绑定控件
    public <T extends View> T getView(int viewId){
       View view=mViews.get(viewId);
       if(view==null){
           view=mConvertView.findViewById(viewId);
           mViews.put(viewId,view);
       }
       return (T)view;
    }

    public View getConvertView(){
        return mConvertView;
    }
    //设置控件的显示内容，可自定义
    public ViewHolder setText(int viewId,String text){
        TextView tv=getView(viewId);
        tv.setText(text);
        return this;
    }
}
