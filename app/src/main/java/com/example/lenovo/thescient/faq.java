package com.example.lenovo.thescient;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class faq extends ExpandableListActivity {
    private ExpandableListAdapter mAdapter;
    ExpandableListView expand;
    BottomSheetBehavior bottomSheetBehavior;

    ImageView bulb_transition;

    int background=android.R.color.darker_gray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!NetworkAvailability.isNetworkAvailable(getBaseContext())){
            setContentView(R.layout.nointernet);
            FloatingActionButton refresh = findViewById(R.id.Refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(getBaseContext(),faq.class));
                }
            });
        }else{
            setContentView(R.layout.activity_faq);
            List<Map<String, String>> groupData = new ArrayList<>();
            List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap1 = new HashMap<>();
            groupData.add(curgroupMap1);

            curgroupMap1.put("parent", "What is SCIEnT ?");

            List<Map<String,String>> children1 =new ArrayList<Map<String,String>>();
            /* *** ChildData ***/
            Map<String, String> curChildMap1 = new HashMap<String, String>();
            children1.add(curChildMap1);
            curChildMap1.put("child", "SCIEnT is a completely student-run and alumni funded facility where a multitude of tools and consumables are provided in a workspace that is open 24/7 for students to work on projects.");


            childData.add(children1);

            /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap2 = new HashMap<String, String>();
            groupData.add(curgroupMap2);
            curgroupMap2.put("parent", "Who can access the facilities at SCIEnT ?");
            List<Map<String,String>> children2 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap2 = new HashMap<String, String>();
            children2.add(curChildMap2);
            curChildMap2.put("child", "SCIEnT is open to all students of all years of NIT Trichy.");

            childData.add(children2);


            /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap3 = new HashMap<String, String>();
            groupData.add(curgroupMap3);
            curgroupMap3.put("parent", "What is the SCIEnT Student Team ?");
            List<Map<String,String>> children3 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap3 = new HashMap<String, String>();
            children3.add(curChildMap3);
            curChildMap3.put("child", "The team coordinates the happenings in SCIEnT and acts as a bridge between alumni and students. It is the immediate point of contact for the students using the facility.");

            childData.add(children3);
            /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap4 = new HashMap<String, String>();
            groupData.add(curgroupMap4);
            curgroupMap4.put("parent", "How can I get biometric access ?");
            List<Map<String,String>> children4 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap4 = new HashMap<String, String>();
            children4.add(curChildMap4);
            curChildMap4.put("child", "Fill the access requisition form in the website. You will be contacted by a representative from the Student Team on how to receive access.");

            childData.add(children4);
            /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap5 = new HashMap<String, String>();
            groupData.add(curgroupMap5);
            curgroupMap5.put("parent", "Can I use SCIEnT even if I don't belong to a Tech club ?");
            List<Map<String,String>> children5 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap5 = new HashMap<String, String>();
            children5.add(curChildMap5);
            curChildMap5.put("child", "Yes, SCIEnT can be used by every student of the college.");

            childData.add(children5);
            /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap6 = new HashMap<String, String>();
            groupData.add(curgroupMap6);
            curgroupMap6.put("parent", "How can I get my project funded ?");
            List<Map<String,String>> children6 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap6 = new HashMap<String, String>();
            children6.add(curChildMap6);
            curChildMap6.put("child", "Submit your abstract by filling in the project registration form on our website. After scrutiny from both the alumni and students, a panel will decide about granting funds.");

            childData.add(children6);   /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap7 = new HashMap<String, String>();
            groupData.add(curgroupMap7);
            curgroupMap7.put("parent", "Can I take a tool outside SCIEnT ?");
            List<Map<String,String>> children7 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap7 = new HashMap<String, String>();
            children7.add(curChildMap7);
            curChildMap7.put("child", "Yes, but you will have to give an undertaking letter to the SCIEnT Admin in-charge or the student team head, stating that you will be responsible for any damage or loss to the tool.");

            childData.add(children7);   /* *************************End Group **************************/

            /* ******************** Start Group  ********************* */
            Map<String, String> curgroupMap8 = new HashMap<String, String>();
            groupData.add(curgroupMap8);
            curgroupMap8.put("parent", "Does SCIEnT provide guidance while doing a project ?");
            List<Map<String,String>> children8 =new ArrayList<Map<String,String>>();

            /* *** ChildData ***/
            Map<String, String> curChildMap8 = new HashMap<String, String>();
            children8.add(curChildMap8);
            curChildMap8.put("child", "Yes. We can provide mentorship for your projects by connecting you with alumni in a similar field.");

            childData.add(children8);

            mAdapter = new SimpleExpandableListAdapter(
                    this,
                    groupData,
                    android.R.layout.simple_expandable_list_item_1,
                    new String[] { "parent" },
                    new int[] { android.R.id.text1, android.R.id.text2 },
                    childData,
                    android.R.layout.simple_expandable_list_item_2,
                    new String[] {"child"},
                    new int[] { android.R.id.text1 }
            );
            setListAdapter(mAdapter);

            expand = getExpandableListView();

            expand.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    // TODO Auto-generated method stub
                    ;
                    return false;
                }
            });
        }
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        final ImageView arrow = (ImageView) bottom_sheet.findViewById(R.id.arrow);
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.left_to_right,R.anim.stay);
            }
        });
        Typeface karla_regular =  Typeface.createFromAsset(getAssets(),"fonts/Karla-Regular.ttf");
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        FrameLayout registration =  bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery =  bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events =  bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects =  bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources =  bottom_sheet1.findViewById(R.id.Resources);
        FrameLayout idea = bottom_sheet1.findViewById(R.id.Idea_sub);
        FrameLayout faq1 = bottom_sheet1.findViewById(R.id.faq);
        final FrameLayout contact =  bottom_sheet1.findViewById(R.id.Contact);
        FrameLayout announcements = bottom_sheet1.findViewById(R.id.Announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Announcement.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Register.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Gallery.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Events.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),project.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Resources.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),contactus.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ideasub.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(125);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                arrow.setRotation(v * 180);
                if(NetworkAvailability.isNetworkAvailable(getBaseContext())){
                    final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.acitivity_faq);
                    linearLayout.setAlpha(1 - v);
                }
            }
        });
        Made_By.setTypeface(karla_regular);
    }
    @Override
    protected void onStop() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        super.onStop();
    }
}