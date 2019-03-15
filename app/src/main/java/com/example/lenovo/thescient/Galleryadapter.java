package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Galleryadapter extends BaseAdapter {
   private Context mcontext;
    private LayoutInflater inflater;
    private ArrayList<mga> mgaArrayList;
    Galleryadapter(Context context, ArrayList<mga> list){
        mcontext=context;
        inflater=LayoutInflater.from(mcontext);
        mgaArrayList=list;
    }



    @Override
    public int getCount() {
        return mgaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View viewHolder, ViewGroup parent) {
        final ViewHolder holder;
        View view = viewHolder;
        if (view == null) {
            view = inflater.inflate(R.layout.rv_food_items, parent, false);
            holder = new ViewHolder();
            assert view != null;

            holder.imageView = (ImageView) view.findViewById(R.id.img);

            holder.textView=(TextView)view.findViewById(R.id.txt_gtxt);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        mga item = mgaArrayList.get(i);
        ImageView imageView = holder.imageView;
        TextView textView = holder.textView;
        Picasso.get().load(item.getImg()).resize(450,300).into(imageView);
        textView.setText(item.getString());
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;

    }
}
