package com.baidu.picasssotest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.util.List;

/**
 * Created by Administrator on 2016/3/7 0007.
 */
public class MyAdapter extends BaseAdapter {
    List<String> list;
    Context context;

    public MyAdapter(List list, Context context) {
        this.list = list;
        this.context = context;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context)
                .load(list.get(position))
                .resize(320,480)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .placeholder(R.drawable.abc_btn_radio_material)
                .into(viewHolder.imageView);


        return convertView;
    }

    public static class ViewHolder {
        ImageView imageView;
    }

}
