package com.example.lenovo.thescient;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Events extends AppCompatActivity {
    RecyclerView recyclerView;
    EventAdapter eventAdapter;
    RequestQueue requestQueue;
    BottomSheetBehavior bottomSheetBehavior;
    ArrayList<Event_objects> arrayList;
    String url = "https://scient.nitt.edu/events";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        arrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_event);
        requestQueue = Volley.newRequestQueue(this);
        jsonParse();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_events);
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        final ImageView arrow = (ImageView) bottom_sheet.findViewById(R.id.arrow);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(125);
        Typeface karla_regular =  Typeface.createFromAsset(getAssets(),"fonts/Karla-Regular.ttf");
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                overridePendingTransition(R.anim.left_to_right,R.anim.stay);
            }
        });
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        FrameLayout registration =  bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery =  bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events =  bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects =  bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources =  bottom_sheet1.findViewById(R.id.Resources);
        final FrameLayout contact =  bottom_sheet1.findViewById(R.id.Contact);
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

    }
    public void jsonParse(){
        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("lENGTH",response.length()+"");
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String details = jsonObject.getString("EventsDetails");
                                Log.d("lENGTH",details+"");
                                String date = jsonObject.getString("startDate") + " - " + jsonObject.getString("endDate");
                                String time = jsonObject.getString("startTime") + " - " + jsonObject.getString("endTime");
                                eventAdapter = new EventAdapter(getBaseContext(),arrayList);
                                recyclerView.setAdapter(eventAdapter);
                                arrayList.add(new Event_objects(details,date,time));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
