package com.spider.scient.scientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Announcement extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior;
    AnnouncementAdapter announcementAdapter;
    ArrayList<Announcement_objects> arrayList;
    String url = "https://scient.nitt.edu/announcements";
    RecyclerView recyclerView;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!NetworkAvailability.isNetworkAvailable(getBaseContext())) {
            setContentView(R.layout.nointernet);
            FloatingActionButton refresh = findViewById(R.id.Refresh);
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(getBaseContext(), Announcement.class));
                }
            });
        } else {
            setContentView(R.layout.activity_announcement);
            arrayList = new ArrayList<>();
            recyclerView = (RecyclerView) findViewById(R.id.recycler_event);
            requestQueue = Volley.newRequestQueue(this);
            jsonParse();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.left_to_right, R.anim.stay);
            }
        });
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        FrameLayout registration = bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery = bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events = bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects = bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources = bottom_sheet1.findViewById(R.id.Resources);
        FrameLayout idea = bottom_sheet1.findViewById(R.id.Idea_sub);
        FrameLayout faq1 = bottom_sheet1.findViewById(R.id.faq);
        final FrameLayout contact = bottom_sheet1.findViewById(R.id.Contact);
        final ImageView arrow = (ImageView) bottom_sheet1.findViewById(R.id.arrow);
        FrameLayout announcements = bottom_sheet1.findViewById(R.id.Announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Register.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Gallery.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Events.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), project.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Resources.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), contactus.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), ideasub.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), faq.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
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
                if (NetworkAvailability.isNetworkAvailable(getBaseContext())) {
                    final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.acitivity_announcements);
                    linearLayout.setAlpha(1 - v);
                }
            }
        });
    }

    public void jsonParse() {
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("announcements");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String details = jsonObject.getString("Text");
                                announcementAdapter = new AnnouncementAdapter(getBaseContext(), arrayList);
                                recyclerView.setAdapter(announcementAdapter);
                                arrayList.add(new Announcement_objects(details));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    protected void onStop() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        super.onStop();
    }
}
