package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class contactus extends AppCompatActivity {
EditText fullname,email,cno,message;
Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        send=(Button)findViewById(R.id.btn_sndmsg);
        fullname=(EditText)findViewById(R.id.edt_fname);
        email=(EditText) findViewById(R.id.edt_femail);
        cno=(EditText)findViewById(R.id.edt_fCno);
        message=(EditText)findViewById(R.id.edt_msg);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name=fullname.getText().toString();
            String emai=email.getText().toString();
            String con=cno.getText().toString();
            String messs=message.getText().toString();
            if(name.isEmpty()||emai.isEmpty()||con.isEmpty()||messs.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"All fields are Mandatory",Toast.LENGTH_LONG).show();
            }
            else
            {
                Call<ResponseBody> call=Rettrofitclient
                        .getInstance()
                        .getApi()
                        .mesa(name,con,emai,messs);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            if(response.code()==200)
                            {
                                Toast.makeText(getApplicationContext()," Request Successful ",Toast.LENGTH_LONG).show();}
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
