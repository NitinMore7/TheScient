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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rproject extends AppCompatActivity {
EditText name,roll,dept,cno,email,abstrac,budget,timeline;
    BottomSheetBehavior bottomSheetBehavior;
    Button addmemberbutton,addmaterialsbutton,addservicebutton;
Button submitt;public enum visi{open,closed}
ArrayList<View> addmemberviewlist=new ArrayList<>(),addmaterialviewlist=new ArrayList<>(),addserviceviewlist=new ArrayList<>();
LinearLayout addmemberlayout;
String radioText;
    ArrayList<String> teamMembersNames=new ArrayList<>();
    ArrayList<String> teamMembersRoll=new ArrayList<>();
    ArrayList<String> materialNames=new ArrayList<>();
    ArrayList<String> materialSpecs=new ArrayList<>();
    ArrayList<String> materialQuantity=new ArrayList<>();
    ArrayList<String> materialPrice=new ArrayList<>();
    ArrayList<String> purpose=new ArrayList<>();
    ArrayList<String> vendors=new ArrayList<>();
    ArrayList<String> serviceNames=new ArrayList<>();
    ArrayList<String> serviceSpecs=new ArrayList<>();
    ArrayList<String> servicePrice=new ArrayList<>();
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
        addmaterialsbutton=findViewById(R.id.add_material_button);
        abstrac=(EditText)findViewById(R.id.edt_abstractr);
        budget=(EditText)findViewById(R.id.edt_budgetr);
        timeline=(EditText)findViewById(R.id.edt_timeliner);
        addmemberbutton=findViewById(R.id.add_member_button);
        addmemberlayout=findViewById(R.id.add_edit_text_layout);
        addservicebutton=findViewById(R.id.add_service_button);



        addmemberbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View v= Objects.requireNonNull(vi).inflate(R.layout.team_members_view,null);
                final ViewGroup insertPoint = (ViewGroup) findViewById(R.id.add_edit_text_layout);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                addmemberviewlist.add(v);
                Button button=v.findViewById(R.id.close);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addmemberviewlist.remove(v);
                        insertPoint.removeView(v);
                    }
                });
            }
        });

        addmaterialsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View v= Objects.requireNonNull(vi).inflate(R.layout.materials_view,null);
                final ViewGroup insertPoint = (ViewGroup) findViewById(R.id.add_material_child);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                addmaterialviewlist.add(v);
                Button button=v.findViewById(R.id.close);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addmaterialviewlist.remove(v);
                        insertPoint.removeView(v);
                    }
                });
            }
        });

        addservicebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View v= Objects.requireNonNull(vi).inflate(R.layout.service_view,null);
                final ViewGroup insertPoint = (ViewGroup) findViewById(R.id.add_service_child);
                insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                addserviceviewlist.add(v);
                Button button=v.findViewById(R.id.close);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addserviceviewlist.remove(v);
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
                RadioGroup radioGroup=findViewById(R.id.radioGroup);
                RadioButton radioButton=findViewById(radioGroup.getCheckedRadioButtonId());
                radioText= (String) radioButton.getText();
                visi visibilitya;

                    if (radioText.equals("Open"))
                        visibilitya = visi.open;
                    else
                        visibilitya = visi.closed;

                String abstraca= String.valueOf(abstrac.getText());
                Integer budgetr=null;
                try{
                budgetr=Integer.parseInt(budget.getText().toString());}catch (Exception e){}
                String timeliner= String.valueOf(timeline.getText());
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
                else if(checkemptyteamViews()){
                    Toast.makeText(getApplicationContext(),"Please fill up all details of team members",Toast.LENGTH_SHORT).show();
                }

                else if(checkemptymaterialViews()){
                    Toast.makeText(getApplicationContext(),"Please fill up all details of materials",Toast.LENGTH_SHORT).show();
                }

                else if(checkEmptyServiceViews()){
                    Toast.makeText(getApplicationContext(),"Please fill up all details of Services",Toast.LENGTH_SHORT).show();
                }

                else {
                    for(int i=0;i<addmemberviewlist.size();i++){
                        teamMembersNames.add(((EditText)addmemberviewlist.get(i).findViewById(R.id.member_name)).getText().toString());
                        teamMembersRoll.add(((EditText)addmemberviewlist.get(i).findViewById(R.id.member_rollno)).getText().toString());
                    }
                    for(int i=0;i<addmaterialviewlist.size();i++){
                        materialNames.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_name)).getText().toString());
                        materialSpecs.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_specification)).getText().toString());
                        materialQuantity.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_quantity)).getText().toString());
                        materialPrice.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_price)).getText().toString());
                        purpose.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_purpose)).getText().toString());
                        vendors.add(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_link)).getText().toString());
                    }
                    for(int i=0;i<addserviceviewlist.size();i++){
                        serviceNames.add(((EditText)addserviceviewlist.get(i).findViewById(R.id.service_name)).getText().toString());
                        serviceSpecs.add(((EditText)addserviceviewlist.get(i).findViewById(R.id.service_specification)).getText().toString());
                        servicePrice.add(((EditText)addserviceviewlist.get(i).findViewById(R.id.service_price)).getText().toString());
                    }
                    Call<ResponseBody> call=Rettrofitclient
                            .getInstance()
                            .getApi()
                            .rpro(namea,rolla,depta,cnoa,emaila,visibilitya,abstraca,budgetr,timeliner,teamMembersNames,teamMembersRoll,materialNames,materialSpecs,
                                    materialQuantity,materialPrice,purpose,vendors,serviceNames,serviceSpecs,servicePrice);

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

    boolean checkemptyteamViews(){
        for(int i=0;i<addmemberviewlist.size();i++){
            if(((EditText)addmemberviewlist.get(i).findViewById(R.id.member_name)).getText().toString().isEmpty() ||
                    ((EditText)addmemberviewlist.get(i).findViewById(R.id.member_rollno)).getText().toString().isEmpty()){
                return true;
            }
        }
        return false;
    }

    boolean checkemptymaterialViews(){
        for(int i=0;i<addmaterialviewlist.size();i++){
            if(((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_name)).getText().toString().isEmpty() ||
                    ((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_specification)).getText().toString().isEmpty() ||
                    ((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_price)).getText().toString().isEmpty() ||
                    ((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_quantity)).getText().toString().isEmpty() ||
                    ((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_purpose)).getText().toString().isEmpty() ||
                    ((EditText)addmaterialviewlist.get(i).findViewById(R.id.material_link)).getText().toString().isEmpty()){
                return true;
            }
        }
        return false;
    }

    boolean checkEmptyServiceViews(){
        for(int i=0;i<addserviceviewlist.size();i++){
            if(((EditText)addserviceviewlist.get(i).findViewById(R.id.service_name)).getText().toString().isEmpty() ||
                    ((EditText)addserviceviewlist.get(i).findViewById(R.id.service_specification)).getText().toString().isEmpty() ||
                    ((EditText)addserviceviewlist.get(i).findViewById(R.id.service_price)).getText().toString().isEmpty()){
                return true;
            }
        }
        return false;
    }


}
