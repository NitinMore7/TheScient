package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    String tag=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String Url1="https://scient.nitt.edu/gallery-images";

        StringRequest request = new StringRequest(Url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        RequestQueue rQueue = Volley.newRequestQueue(Gallery.this);
        rQueue.add(request);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    void parseJsonData(String jsonString) {
        try {


            } catch (Exception e) {
            e.printStackTrace();
                                 }


    }
}
