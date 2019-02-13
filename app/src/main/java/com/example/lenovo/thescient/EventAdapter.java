package com.example.lenovo.thescient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    Context mcontext;
    ArrayList<Event_objects> marrayList;
    public EventAdapter(Context context, ArrayList<Event_objects> arrayList){
        mcontext = context;
        marrayList = arrayList;
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.event_card,viewGroup,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder eventViewHolder, int i) {
        Event_objects event_objects = marrayList.get(i);
        eventViewHolder.details.setText(event_objects.getMdetails());
        eventViewHolder.date.setText(event_objects.getMdate());
        eventViewHolder.time.setText(event_objects.getMtime());
    }

    @Override
    public int getItemCount() {
        return marrayList.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        TextView details, date, time;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            details = (TextView) itemView.findViewById(R.id.details);
            date = (TextView) itemView.findViewById(R.id.date);
            time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}
