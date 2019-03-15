package com.example.lenovo.thescient;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class Gallery extends AppCompatActivity {
    GridView gridView;
    ArrayList<mga> mgaArrayList;
    BottomSheetBehavior bottomSheetBehavior;
    ProgressDialog progressDialog;
    String[] a=new String[10];
    String[] b =new String[10];
    String tag=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_gallery);
        ImageView home = (ImageView) findViewById(R.id.Home);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Fetching Images...");
        progressDialog.show();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                overridePendingTransition(R.anim.left_to_right,R.anim.stay);
                finish();
            }
        });
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        final ImageView arrow = (ImageView) bottom_sheet.findViewById(R.id.arrow);
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
                startActivity(new Intent(getBaseContext(),Announcement.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Register.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
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
                startActivity(new Intent(getBaseContext(),contactus.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

            }
        });
        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ideasub.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),faq.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);

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
                linearLayout.setAlpha(1 - v);
            }
        });
        Made_By.setTypeface(karla_regular);
        String Url1="https://scient.nitt.edu/gallery-images";
        gridView=findViewById(R.id.rv);
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
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getBaseContext(),content_error.class));
                overridePendingTransition(R.anim.right_to_left,R.anim.stay);
                finish();
                progressDialog.cancel();
            }
        }); RequestQueue rQueue = Volley.newRequestQueue(Gallery.this);
        rQueue.add(request);


gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getBaseContext(),imageshow.class);
        intent.putExtra("imagelink",a[position]);
        intent.putExtra("imagename",b[position]);
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left,R.anim.stay);
    }
});
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    void parseJsonData(JSONArray jsonarray) {
        try {
            for (int i = 0; i < jsonarray.length(); i++) {
                {  String a1=(String)jsonarray.get(i);
                    if(a1.lastIndexOf(".")>0)
                    b[i]=a1.substring(0,a1.lastIndexOf("."));


                    a[i]= "https://scient.nitt.edu/images/gallery/"+(String) jsonarray.get(i);

                    mgaArrayList.add(new mga(a[i],b[i]));
                   // Toast.makeText(getApplicationContext(),""+a[i],Toast.LENGTH_SHORT).show();
                }
                Galleryadapter galleryadapter=new Galleryadapter(this,mgaArrayList);
                gridView.setAdapter(galleryadapter);
            }

            } catch (Exception e) {
            e.printStackTrace();
                                 }


    }
}
