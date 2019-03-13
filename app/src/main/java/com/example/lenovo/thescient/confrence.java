package com.example.lenovo.thescient;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class confrence extends AppCompatActivity {
EditText name,roll,dept,cno,email,atten,purpose,date,start,end;
Button submit;
    final Calendar calendar=Calendar.getInstance();
    Time time,t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrence);
        name=(EditText)findViewById(R.id.edt_hbname);
        roll=(EditText)findViewById(R.id.edt_hbrollno);
        dept=(EditText)findViewById(R.id.edt_hbdept);
        cno=(EditText)findViewById(R.id.edt_hbCno);
        email=(EditText)findViewById(R.id.edt_hbemail);
        atten=(EditText)findViewById(R.id.edt_hbnatte);
        purpose=(EditText)findViewById(R.id.edt_hbpurpose);
        date=(EditText)findViewById(R.id.edt_hbdate);
        start=(EditText)findViewById(R.id.edt_hbstart);
        end=(EditText)findViewById(R.id.edt_hbend);
        submit=(Button)findViewById(R.id.btn_hbsubmit);


        final DatePickerDialog.OnDateSetListener datea=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(confrence.this, datea, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

final TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,minute);
        timer();
    }
};
        final TimePickerDialog.OnTimeSetListener timeSetListener1=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                timer1();
            }
        };
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         new TimePickerDialog(confrence.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   new TimePickerDialog(confrence.this,timeSetListener1,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date d = null,starta=null,enda = null;
                String namea=name.getText().toString();
                String rolla=roll.getText().toString();
                String depta=dept.getText().toString();
                String cnoa=cno.getText().toString();
                String emaila=email.getText().toString();
                Integer attenda=null;
                if(atten.getText().toString().isEmpty())
                    atten.setError("Can't be empty");
                else
                    attenda= Integer.valueOf(atten.getText().toString());
                String pur=purpose.getText().toString();
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                try {
                     d=sdf.parse( date.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm");
                try {
                     starta=sdf1.parse(start.getText().toString());
                     time=new Time();
                     time.set(starta.getTime());

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    enda=sdf1.parse(end.getText().toString());
                    t=new Time();
                    t.set(enda.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(namea.isEmpty()||rolla.isEmpty()||depta.isEmpty()||cnoa.isEmpty()||emaila.isEmpty()|| attenda.toString().isEmpty()||pur.isEmpty()||date.getText().toString().isEmpty()||start.getText().toString().isEmpty()||end.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"All fields must be filled",Toast.LENGTH_SHORT).show();
                else
                {
                    Call<ResponseBody> call=Rettrofitclient
                            .getInstance()
                            .getApi()
                            .hall(namea,rolla,depta,cnoa,emaila,attenda,pur,d,time,t);

                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                if(response.code()==200)
                                {
                                    Toast.makeText(getApplicationContext()," Request Successful ",Toast.LENGTH_LONG).show();}
                                else
                                {Toast.makeText(getApplicationContext()," Request Failed ",Toast.LENGTH_LONG).show();
                                    Log.e("TAG",""+response);}
                            }catch (Exception e){}
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                            Log.e("TAG",t.toString() );
                        }
                    });
                }
            }
        });
    }
    private void updateLabel() {
        String myFormat = "dd-MM-yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(calendar.getTime()));
    }
    private void timer(){
        String format="HH:mm";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format,Locale.US);
        start.setText(simpleDateFormat.format(calendar.getTime()));
    }
    private void timer1(){
        String format="HH:mm";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format,Locale.US);
        end.setText(simpleDateFormat.format(calendar.getTime()));
    }
}
