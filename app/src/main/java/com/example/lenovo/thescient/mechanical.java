package com.example.lenovo.thescient;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class mechanical extends Fragment {
    GridView gridView;
    ArrayList<mga> mgaArrayList;
    ProgressDialog progressDialog;
    String[] a=new String[20];
    String[] b =new String[20];
    String tag=" ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_mechanical, container, false);
        gridView=(GridView)view.findViewById(R.id.gv_mech);
        progressDialog=new ProgressDialog(getContext());
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Fetching Images...");
        progressDialog.show();
        String Url1="https://scient.nitt.edu/mechanical/images";

        mgaArrayList=new ArrayList<>();
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, Url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray filename = response.getJSONArray("filenames");
                    parseJsonData(filename);
                    progressDialog.dismiss();
                } catch (Exception e) {
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                progressDialog.cancel();
            }
        }); RequestQueue rQueue = Volley.newRequestQueue(getActivity());
        rQueue.add(request);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),imageshow.class);
                intent.putExtra("imagelink",a[position]);
                intent.putExtra("imagename",b[position]);
                startActivity(intent);

            }
        });
        return view;

    }
    void parseJsonData(JSONArray jsonarray) {
        try {
            for (int i = 0; i < jsonarray.length(); i++) {
                {  String a1=(String)jsonarray.get(i);
                    if(a1.lastIndexOf(".")>0)
                        b[i]=a1.substring(0,a1.lastIndexOf("."));


                    a[i]= "https://scient.nitt.edu/images/tools/mechanical/"+(String) jsonarray.get(i);

                    mgaArrayList.add(new mga(a[i],b[i]));
                    // Toast.makeText(getApplicationContext(),""+a[i],Toast.LENGTH_SHORT).show();
                }
                Galleryadapter galleryadapter=new Galleryadapter(getActivity(),mgaArrayList);
                gridView.setAdapter(galleryadapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
