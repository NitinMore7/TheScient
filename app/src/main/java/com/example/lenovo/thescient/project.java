package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class project extends AppCompatActivity {

    private RecyclerView recyclerView;
    private projectadapter mAdapter;
   ArrayList<promga> marray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

      String URL="https://scient.nitt.edu/projects-images";
        recyclerView=(RecyclerView)findViewById(R.id.prorv);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rv=layoutManager;
        recyclerView.setLayoutManager(rv);
        marray=new ArrayList<>();
        StringRequest request=new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                setUI(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(project.this);
        requestQueue.add(request);
    }
    private void setUI(String jsonString){

            try{
                JSONArray jsonarray = new JSONArray(jsonString);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject h=jsonarray.getJSONObject(i);
                    Toast.makeText(getApplicationContext(), ""+jsonarray.getJSONObject(i).get("projectImage"),Toast.LENGTH_LONG).show();
                   String img= h.getString("projectImage");
                   String title=h.getString("projectTitle");
                   String dec=h.getString("projectDesc");
                    marray.add(new promga(img,title,dec));
                }
                projectadapter pro=new projectadapter(this,marray);
                recyclerView.setAdapter(pro);

            }catch (Exception e){e.printStackTrace();}



    }
}
