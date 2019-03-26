package com.spider.scient.scientapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

public class faqadapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listtitles;
    private List<String> listChildIntents;

    public faqadapter(Context context, List<String> listtitles, List<String> listChildIntents) {
        this.context = context;
        this.listtitles = listtitles;
        this.listChildIntents = listChildIntents;


    }

    @Override
    public int getGroupCount() {
        return this.listtitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listtitles.get(groupPosition);
    }


    @Override
    public Object getChild(int i, int i1) {
        return this.listChildIntents.get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String title = (String) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandablefaq, null);
        }
        TextView listTitleView = view.findViewById(R.id.list_ftext);

        listTitleView.setText(title);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean isLastChild, View view, ViewGroup parent) {
        String intentstring = (String) getChild(i, i1);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.faq_ac, null);

        }

        TextView intentText = view.findViewById(R.id.intent_faq_text);
        intentText.setTextSize(18);
        intentText.setText(intentstring);


        return view;
    }


}
