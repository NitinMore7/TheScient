package com.example.lenovo.thescient;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rproject extends AppCompatActivity {
EditText name,roll,dept,cno,email,visibility,abstrac,budget,timeline;
    BottomSheetBehavior bottomSheetBehavior;
    Button addmemberbutton;
Button submitt;public enum visi{open,closed}
LinearLayout.LayoutParams layoutParams;
ArrayList<View> viewlist=new ArrayList<>();
LinearLayout addmemberlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rproject);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_rproject);
        ImageView back = findViewById(R.id.Home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getBaseContext(),Register.class));
            }
        });
        submitt=(Button)findViewById(R.id.btn_prosub);
        name=(EditText)findViewById(R.id.edt_namer);
        roll=(EditText)findViewById(R.id.edt_rollnor);
        dept=(EditText)findViewById(R.id.edt_deptr);
        cno=(EditText)findViewById(R.id.edt_Cnor);
        email=(EditText)findViewById(R.id.edt_emailr);
        visibility=(EditText)findViewById(R.id.edt_visibilityr);
        abstrac=(EditText)findViewById(R.id.edt_abstractr);
        budget=(EditText)findViewById(R.id.edt_budgetr);
        timeline=(EditText)findViewById(R.id.edt_timeliner);
        addmemberbutton=findViewById(R.id.add_member_button);
        addmemberlayout=findViewById(R.id.add_edit_text_layout);
        addmemberbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //addview
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View v= Objects.requireNonNull(vi).inflate(R.layout.team_members_view,null);
                final ViewGroup insertPoint = (ViewGroup) findViewById(R.id.add_edit_text_layout);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                viewlist.add(v);
                Button button=v.findViewById(R.id.close);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewlist.remove(v);
                        insertPoint.removeView(v);
                    }
                });
            }
        });

        submitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namea=name.getText().toString();
                String rolla=roll.getText().toString();
                String depta=dept.getText().toString();
                String cnoa=cno.getText().toString();
                String emaila=email.getText().toString();
                visibility.setHint("Open/Closed");
                String visibi=visibility.getText().toString();
                visi visibilitya = visi.open;


                if(visibi.compareToIgnoreCase("open")==1||visibi.compareToIgnoreCase("closed")==1) {
                    if (visibi == "open")
                        visibilitya = visi.open;
                    else
                        visibilitya = visi.closed;
                }
                else {
                    visibility.setError("Please Enter a valid Text");
                }

                Editable abstraca=abstrac.getText();
                Integer budgetr=null;
                try{
                budgetr=Integer.parseInt(budget.getText().toString());}catch (Exception e){}
                Editable timeliner= timeline.getText();
                if(namea.isEmpty())
                {
                    name.setError("Name Required");
                }
                else if(rolla.isEmpty())
                {
                    roll.setError("Roll No. required");
                }
                else if(depta.isEmpty())
                {
                    dept.setError("Department Is Required");
                }
                else if(cnoa.length()<9)
                {
                    cno.setError("Please enter a Valid Contact Number");
                }
                else if(emaila.isEmpty())
                {
                    email.setError("Email Id is Required");
                }
                else if(visibilitya.toString().isEmpty())
                {
                    visibility.setError("Purpose Required");
                }

                else {
                    Call<ResponseBody> call=Rettrofitclient
                            .getInstance()
                            .getApi()
                            .rpro(namea,rolla,depta,cnoa,emaila,visibilitya,abstraca,budgetr,timeliner);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                if(response.code()==200)
                                {
                                    Toast.makeText(getApplicationContext()," Request Successful ",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getBaseContext(),Register.class));
                                    overridePendingTransition(R.anim.left_to_right,R.anim.stay);}
                                else
                                {Toast.makeText(getApplicationContext()," Request Failed ",Toast.LENGTH_LONG).show();}
                            }catch (Exception e){}
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
