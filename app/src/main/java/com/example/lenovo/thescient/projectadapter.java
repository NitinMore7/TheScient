package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableWeightLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class projectadapter extends RecyclerView.Adapter<projectadapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<promga> mgaArrayList;

    projectadapter(Context context, ArrayList<promga> list) {
        mcontext = context;
        mgaArrayList = list;
    }

    @NonNull
    @Override
    public projectadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.cardviewproject, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull projectadapter.ViewHolder viewHolder, int i) {

        promga item = mgaArrayList.get(i);
        ImageView imageView = viewHolder.imageView;
        final ExpandableWeightLayout expandableWeightLayout = viewHolder.expandableWeightLayout;
        CardView cardView = viewHolder.cardView;
        final ProgressBar pb = viewHolder.progressBar;
        Picasso.get().load(item.getProjectImage()).resize(250, 250).into(imageView, new Callback() {
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
        TextView txt1 = viewHolder.txt1;
        final TextView txt2 = viewHolder.txt2;
        txt1.setText(item.getProjectTitle());
        txt2.setText(item.getdesc());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt2.setVisibility(View.VISIBLE);
                expandableWeightLayout.toggle();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mgaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txt1, txt2;
        ExpandableWeightLayout expandableWeightLayout;
        CardView cardView;
        ProgressBar progressBar;

        public ViewHolder(View itemview) {
            super(itemview);
            imageView = (ImageView) itemview.findViewById(R.id.proimg);
            txt1 = (TextView) itemview.findViewById(R.id.prohead);
            txt2 = (TextView) itemview.findViewById(R.id.prodes);
            expandableWeightLayout = itemview.findViewById(R.id.expandableLayout);
            cardView = itemview.findViewById(R.id.project_cardview);
            progressBar = itemview.findViewById(R.id.project_progress);
        }
    }
}
