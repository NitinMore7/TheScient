package com.example.lenovo.thescient;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
        setContentView(R.layout.activity_faq);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.acitivity_faq);
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                overridePendingTransition(R.anim.left_to_right,R.anim.stay);
            }
        });
        bulb_transition = (ImageView) findViewById(R.id.bulb_transition);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(150);
        if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
        }
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                Log.d("Offset",v+"");
                linearLayout.setAlpha(1-v);
                if(v<=0.150){
                    bulb_transition.setVisibility(View.INVISIBLE);
                }else{
                    bulb_transition.setVisibility(View.VISIBLE);
                }
                if(v<=0.0169)
                    bulb_transition.setImageResource(R.drawable.i0);
                else if(v<=0.0169*2&&v>0.0169)
                    bulb_transition.setImageResource(R.drawable.i1);
                else if(v<=0.0169*3&&v>0.0169*2)
                    bulb_transition.setImageResource(R.drawable.i2);
                else if(v<=0.0169*4&&v>0.0169*3)
                    bulb_transition.setImageResource(R.drawable.i3);
                else if(v<=0.0169*5&&v>0.0169*4)
                    bulb_transition.setImageResource(R.drawable.i4);
                else if(v<=0.0169*6&&v>0.0169*5)
                    bulb_transition.setImageResource(R.drawable.i5);
                else if(v<=0.0169*7&&v>0.0169*6)
                    bulb_transition.setImageResource(R.drawable.i6);
                else if(v<=0.0169*8&&v>0.0169*7)
                    bulb_transition.setImageResource(R.drawable.i7);
                else if(v<=0.0169*9&&v>0.0169*8)
                    bulb_transition.setImageResource(R.drawable.i8);
                else if(v<=0.0169*10&&v>0.0169*9)
                    bulb_transition.setImageResource(R.drawable.i9);
                else if(v<=0.0169*11&&v>0.0169*10)
                    bulb_transition.setImageResource(R.drawable.i10);
                else if(v<=0.0169*12&&v>0.0169*11)
                    bulb_transition.setImageResource(R.drawable.i11);
                else if(v<=0.0169*13&&v>0.0169*12)
                    bulb_transition.setImageResource(R.drawable.i12);
                else if(v<=0.0169*14&&v>0.0169*13)
                    bulb_transition.setImageResource(R.drawable.i13);
                else if(v<=0.0169*15&&v>0.0169*14)
                    bulb_transition.setImageResource(R.drawable.i14);
                else if(v<=0.0169*16&&v>0.0169*15)
                    bulb_transition.setImageResource(R.drawable.i15);
                else if(v<=0.0169*17&&v>0.0169*16)
                    bulb_transition.setImageResource(R.drawable.i16);
                else if(v<=0.0169*18&&v>0.0169*17)
                    bulb_transition.setImageResource(R.drawable.i17);
                else if(v<=0.0169*19&&v>0.0169*18)
                    bulb_transition.setImageResource(R.drawable.i18);
                else if(v<=0.0169*20&&v>0.0169*19)
                    bulb_transition.setImageResource(R.drawable.i19);
                else if(v<=0.0169*21&&v>0.0169*20)
                    bulb_transition.setImageResource(R.drawable.i20);
                else if(v<=0.0169*22&&v>0.0169*23)
                    bulb_transition.setImageResource(R.drawable.i21);
                else if(v<=0.0169*23&&v>0.0169*24)
                    bulb_transition.setImageResource(R.drawable.i22);
                else if(v<=0.0169*24&&v>0.0169*23)
                    bulb_transition.setImageResource(R.drawable.i23);
                else if(v<=0.0169*25&&v>0.0169*24)
                    bulb_transition.setImageResource(R.drawable.i24);
                else if(v<=0.0169*26&&v>0.0169*25)
                    bulb_transition.setImageResource(R.drawable.i25);
                else if(v<=0.0169*27&&v>0.0169*26)
                    bulb_transition.setImageResource(R.drawable.i26);
                else if(v<=0.0169*28&&v>0.0169*27)
                    bulb_transition.setImageResource(R.drawable.i27);
                else if(v<=0.0169*29&&v>0.0169*28)
                    bulb_transition.setImageResource(R.drawable.i28);
                else if(v<=0.0169*30&&v>0.0169*29)
                    bulb_transition.setImageResource(R.drawable.i29);
                else if(v<=0.0169*31&&v>0.0169*30)
                    bulb_transition.setImageResource(R.drawable.i30);
                else if(v<=0.0169*32&&v>0.0169*31)
                    bulb_transition.setImageResource(R.drawable.i31);
                else if(v<=0.0169*33&&v>0.0169*32)
                    bulb_transition.setImageResource(R.drawable.i32);
                else if(v<=0.0169*34&&v>0.0169*33)
                    bulb_transition.setImageResource(R.drawable.i33);
                else if(v<=0.0169*35&&v>0.0169*34)
                    bulb_transition.setImageResource(R.drawable.i34);
                else if(v<=0.0169*36&&v>0.0169*35)
                    bulb_transition.setImageResource(R.drawable.i35);
                else if(v<=0.0169*37&&v>0.0169*34)
                    bulb_transition.setImageResource(R.drawable.i36);
                else if(v<=0.0169*38&&v>0.0169*37)
                    bulb_transition.setImageResource(R.drawable.i37);
                else if(v<=0.0169*39&&v>0.0169*38)
                    bulb_transition.setImageResource(R.drawable.i38);
                else if(v<=0.0169*40&&v>0.0169*39)
                    bulb_transition.setImageResource(R.drawable.i39);
                else if(v<=0.0169*41&&v>0.0169*40)
                    bulb_transition.setImageResource(R.drawable.i40);
                else if(v<=0.0169*42&&v>0.0169*41)
                    bulb_transition.setImageResource(R.drawable.i41);
                else if(v<=0.0169*43&&v>0.0169*42)
                    bulb_transition.setImageResource(R.drawable.i42);
                else if(v<=0.0169*44&&v>0.0169*43)
                    bulb_transition.setImageResource(R.drawable.i43);
                else if(v<=0.0169*45&&v>0.0169*44)
                    bulb_transition.setImageResource(R.drawable.i44);
                else if(v<=0.0169*46&&v>0.0169*45)
                    bulb_transition.setImageResource(R.drawable.i45);
                else if(v<=0.0169*47&&v>0.0169*46)
                    bulb_transition.setImageResource(R.drawable.i46);
                else if(v<=0.0169*48&&v>0.0169*47)
                    bulb_transition.setImageResource(R.drawable.i47);
                else if(v<=0.0169*49&&v>0.0169*48)
                    bulb_transition.setImageResource(R.drawable.i48);
                else if(v<=0.0169*50&&v>0.0169*49)
                    bulb_transition.setImageResource(R.drawable.i49);
                else if(v<=0.0169*51&&v>0.0169*50)
                    bulb_transition.setImageResource(R.drawable.i50);
                else if(v<=0.0169*52&&v>0.0169*51)
                    bulb_transition.setImageResource(R.drawable.i51);
                else if(v<=0.0169*53&&v>0.0169*52)
                    bulb_transition.setImageResource(R.drawable.i52);
                else if(v<=0.0169*54&&v>0.0169*53)
                    bulb_transition.setImageResource(R.drawable.i53);
                else if(v<=0.0169*55&&v>0.0169*54)
                    bulb_transition.setImageResource(R.drawable.i54);
                else if(v<=0.0169*56&&v>0.0169*55)
                    bulb_transition.setImageResource(R.drawable.i55);
                else if(v<=0.0169*57&&v>0.0169*56)
                    bulb_transition.setImageResource(R.drawable.i56);
                else if(v<=0.0169*58&&v>0.0169*57)
                    bulb_transition.setImageResource(R.drawable.i57);
                else if(v>=0.0169*58)
                    bulb_transition.setImageResource(R.drawable.i58);
            }
        });
        Typeface karla_regular =  Typeface.createFromAsset(getAssets(),"fonts/Karla-Regular.ttf");
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        TextView registration = (TextView) bottom_sheet1.findViewById(R.id.Regitration);
        TextView gallery = (TextView) bottom_sheet1.findViewById(R.id.gallery);
        TextView events = (TextView) bottom_sheet1.findViewById(R.id.events);
        TextView projects = (TextView) bottom_sheet1.findViewById(R.id.Project);
        TextView resources = (TextView) bottom_sheet1.findViewById(R.id.Resources);
        final TextView contact = (TextView) bottom_sheet1.findViewById(R.id.Contact);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Gallery.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Events.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),project.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Made_By.setTypeface(karla_regular);
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
}