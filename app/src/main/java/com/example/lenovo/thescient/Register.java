package com.example.lenovo.thescient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;


public class Register extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<List<String>> intenttexts;
    private List<String> listtitles;
    private List<String> it;
    private int lastExpandedPos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        expandableListView=findViewById(R.id.expandableListView);
        listtitles=getExpandableListTitles();
        intenttexts=getExpandableListitemIntentTexts();

        expandableListAdapter=new CustomExpandableListViewAdapter(this,listtitles,intenttexts);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPos!=-1 && i!=lastExpandedPos){
                    expandableListView.collapseGroup(lastExpandedPos);
                }
                lastExpandedPos=i;
            }
        });

    }

    private List<String> getExpandableListTitles(){
        List<String> list=new ArrayList<>();
        list.add("Project Registration");
        list.add("Access Requisition");
        list.add("Conference Hall");
        return list;
    }
    private List<List<String>> getExpandableListitemIntentTexts(){
        List<List<String>> list=new ArrayList<>();

        List <String> l1=new ArrayList<>();
        l1.add("Register your project under SCIEnT to be eligible for the following provisions:");
        l1.add("o Funding for all parts, components and services associated with your project.\n" +
                "o 24/7 access to all tools and resources available in SCIEnT\n" +
                "o Reviews and guidance on progress\n");
        list.add(l1);

        List <String> l2=new ArrayList<>();
        l2.add("Register for access to SCIEnT with the following provisions:");
        l2.add("o 24/7 access to all tools and resources available in SCIEnT");
        list.add(l2);

        List<String> l3=new ArrayList<>();
        l3.add("Book conference hall");
        l3.add("");

        list.add(l3);

return list;
    }




}
