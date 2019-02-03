package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<mga> mgaArrayList;
    String tag=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        String Url1="https://scient.nitt.edu/gallery-images";
        recyclerView=findViewById(R.id.rv);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLa=layoutManager;
        recyclerView.setLayoutManager(rvLa);
        mgaArrayList=new ArrayList<>();
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
        try {String[] a=new String[10];
            JSONArray jsonarray = new JSONArray(jsonString);
            for (int i = 0; i < jsonarray.length(); i++) {
                {a[i]= "https://scient.nitt.edu/images/gallery/"+(String) jsonarray.get(i);
                    mgaArrayList.add(new mga(a[i]));
                   // Toast.makeText(getApplicationContext(),""+a[i],Toast.LENGTH_SHORT).show();
                }
                Galleryadapter galleryadapter=new Galleryadapter(this,mgaArrayList);
                recyclerView.setAdapter(galleryadapter);
            }

            } catch (Exception e) {
            e.printStackTrace();
                                 }


    }
}
