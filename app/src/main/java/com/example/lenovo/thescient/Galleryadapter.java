package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Galleryadapter extends RecyclerView.Adapter<Galleryadapter.ViewHolder> {
   private Context mcontext;
    private ArrayList<mga> mgaArrayList;
    Galleryadapter(Context context, ArrayList<mga> list){
        mcontext=context;
        mgaArrayList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(mcontext);
        View view=layoutInflater.inflate(R.layout.rv_food_items,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        mga item=mgaArrayList.get(i);
        ImageView imageView=viewHolder.imageView;
        TextView textView=viewHolder.textView;
        Picasso.get().load(item.getImg()).resize(250,300).into(imageView);
        textView.setText(item.getString());
    }

    @Override
    public int getItemCount() {
        return mgaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.txt_gtxt);
        }
    }
}
