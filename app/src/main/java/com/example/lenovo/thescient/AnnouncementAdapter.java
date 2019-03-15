package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {
    Context mcontext;
    ArrayList<Announcement_objects> marrayList;
    public AnnouncementAdapter(Context context, ArrayList<Announcement_objects> arrayList){
        mcontext = context;
        marrayList = arrayList;
    }
    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.announcement_card,viewGroup,false);
        return new AnnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementAdapter.AnnouncementViewHolder announcementViewHolder, int i) {
        Announcement_objects announcement_objects = marrayList.get(i);
        announcementViewHolder.details.setText(announcement_objects.getmAnnouncement());
    }

    @Override
    public int getItemCount() {
        return marrayList.size();
    }

    public class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView details;
        public AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            details = (TextView) itemView.findViewById(R.id.details);
        }
    }
}
