package com.example.lenovo.thescient;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class faq extends ExpandableListActivity {
    private ExpandableListAdapter mAdapter;
    ExpandableListView expand;
    int background=android.R.color.darker_gray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}