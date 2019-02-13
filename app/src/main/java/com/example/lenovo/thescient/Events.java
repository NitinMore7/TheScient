package com.example.lenovo.thescient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
