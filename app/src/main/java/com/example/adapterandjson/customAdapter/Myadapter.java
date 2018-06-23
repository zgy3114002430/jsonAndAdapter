package com.example.adapterandjson.customAdapter;

import android.content.Context;
import com.example.adapterandjson.R;
import com.example.adapterandjson.model.Bean;

import java.util.List;

/**
 * Created by 爱我请给我二十块 on 2018/6/23.
 */

public class Myadapter extends CommonAdapter<Bean>{

    public Myadapter(Context context,List<Bean> data,int layoutId){
        super(context,data,layoutId);

    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {
        holder.setText(R.id.name,bean.getName())
                .setText(R.id.code,bean.getCode())
                .setText(R.id.num,bean.getNum())
                .setText(R.id.price,bean.getPrice())
                .setText(R.id.sum,bean.getSum());
    }
}
