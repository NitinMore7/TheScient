package com.spider.scient.scientapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Galleryadapter extends BaseAdapter {
    private Context mcontext;
    private LayoutInflater inflater;
    private ArrayList<mga> mgaArrayList;

    Galleryadapter(Context context, ArrayList<mga> list) {
        mcontext = context;
        inflater = LayoutInflater.from(mcontext);
        mgaArrayList = list;
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

            holder.textView = (TextView) view.findViewById(R.id.txt_gtxt);

            holder.progressBar = view.findViewById(R.id.gallery_progress);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final ProgressBar pb = holder.progressBar;
        mga item = mgaArrayList.get(i);
        ImageView imageView = holder.imageView;
        TextView textView = holder.textView;
        Picasso.get().load(item.getImg()).resize(450, 300).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                if (pb != null) {
                    pb.setVisibility(View.GONE);
                }
            }

            @Override
            public void onError(Exception e) {
            }
        });
        textView.setText(item.getString());
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView textView;
        ProgressBar progressBar;

    }
}
