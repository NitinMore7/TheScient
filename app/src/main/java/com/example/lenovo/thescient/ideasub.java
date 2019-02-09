package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ideasub extends AppCompatActivity {
    EditText full,phone,email,project,projectidea;
    Button idea;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideasub);
       full=(EditText)findViewById(R.id.edtnam);
       phone=(EditText)findViewById(R.id.edtphn);
       email=(EditText)findViewById(R.id.edtemail);
       project=(EditText)findViewById(R.id.edtpro);
       projectidea=(EditText)findViewById(R.id.edtprojectidea);
        idea=(Button)findViewById(R.id.btnsubmit);


        idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fulla=full.getText().toString();
                String phonea=phone.getText().toString();
                String emaila=email.getText().toString();
                String projecta=project.getText().toString();
                String projectia=projectidea.getText().toString();
                if(fulla.isEmpty()){
                    full.setError("Name required");
                }
                if(phonea.isEmpty())
                {
                    phone.setError("Phone number is required");
                }
                if(emaila.isEmpty())
                {
                    email.setError("Email is required");
                }
                if(projecta.isEmpty())
                {
                    project.setError("Project name required");
                }

                Call<ResponseBody> call=Rettrofitclient
                        .getInstance()
                        .getApi()
                        .name(fulla,phonea,emaila,projecta,projectia);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                       try {
                           if(response.code()==200)
                           {Toast.makeText(getApplicationContext()," Request Successful ",Toast.LENGTH_LONG).show();}
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
        });

    }
}
