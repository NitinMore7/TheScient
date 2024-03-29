package com.spider.scient.scientapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ideasub extends AppCompatActivity {
    EditText full, phone, email, project, projectidea;
    Button idea;
    BottomSheetBehavior bottomSheetBehavior;
    int flag = 0;

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
                    startActivity(new Intent(getBaseContext(), ideasub.class));
                }
            });
        } else {
            setContentView(R.layout.activity_ideasub);
            full = (EditText) findViewById(R.id.edtnam);
            phone = (EditText) findViewById(R.id.edtphn);
            email = (EditText) findViewById(R.id.edtemail);
            project = (EditText) findViewById(R.id.edtpro);
            projectidea = (EditText) findViewById(R.id.edtprojectidea);
            idea = (Button) findViewById(R.id.btnsubmit);
            idea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fulla = full.getText().toString();
                    String phonea = phone.getText().toString();
                    String emaila = email.getText().toString();
                    String projecta = project.getText().toString();
                    String projectia = projectidea.getText().toString();
                    if (fulla.isEmpty()) {
                        full.setError("Name required");
                    }
                    if (phonea.isEmpty()) {
                        phone.setError("Phone number is required");
                    }
                    if (emaila.isEmpty()) {
                        email.setError("Email is required");
                    }
                    if (projecta.isEmpty()) {
                        project.setError("Project name required");
                    } else {
                        Call<ResponseBody> call = Rettrofitclient
                                .getInstance()
                                .getApi()
                                .name(fulla, phonea, emaila, projecta, projectia);

                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    if (response.code() == 200) {
                                        Toast.makeText(getApplicationContext(), " Request Successful ", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), " Request Failed ", Toast.LENGTH_LONG).show();
                                    }
                                } catch (Exception e) {
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                }
            });
        }
        ImageView home = (ImageView) findViewById(R.id.Home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.left_to_right, R.anim.stay);
                finish();
            }
        });
        final LinearLayout bottom_sheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        final ImageView arrow = (ImageView) bottom_sheet.findViewById(R.id.arrow);
        Typeface karla_regular = Typeface.createFromAsset(getAssets(), "fonts/Karla-Regular.ttf");
        LinearLayout bottom_sheet1 = (LinearLayout) findViewById(R.id.bottom_sheet);
        TextView Made_By = (TextView) findViewById(R.id.Made_by);
        FrameLayout registration = bottom_sheet1.findViewById(R.id.Regitration);
        FrameLayout gallery = bottom_sheet1.findViewById(R.id.gallery);
        FrameLayout events = bottom_sheet1.findViewById(R.id.events);
        FrameLayout projects = bottom_sheet1.findViewById(R.id.Project);
        FrameLayout resources = bottom_sheet1.findViewById(R.id.Resources);
        FrameLayout idea = bottom_sheet1.findViewById(R.id.Idea_sub);
        FrameLayout faq1 = bottom_sheet1.findViewById(R.id.faq);
        final FrameLayout contact = bottom_sheet1.findViewById(R.id.Contact);
        FrameLayout announcements = bottom_sheet1.findViewById(R.id.Announcements);
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), Announcement.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);
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
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        faq1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), faq.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT));
                overridePendingTransition(R.anim.right_to_left, R.anim.stay);

            }
        });
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(125);
        Made_By.setTypeface(karla_regular);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                arrow.setRotation(v * 180);
                if (NetworkAvailability.isNetworkAvailable(getBaseContext())) {
                    final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_ideasub);
                    linearLayout.setAlpha(1 - v);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        super.onStop();
    }

}
