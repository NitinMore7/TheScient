package com.example.lenovo.thescient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class Accessreq extends AppCompatActivity {
    EditText name,roll,dept,cno,email,purpose,duration,hmac;
    Button submitt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessreq);
        name=(EditText)findViewById(R.id.edt_name);
        roll=(EditText)findViewById(R.id.edt_rollno);
        dept=(EditText)findViewById(R.id.edt_dept);
        cno=(EditText)findViewById(R.id.edt_Cno);
        email=(EditText)findViewById(R.id.edt_email);
        purpose=(EditText)findViewById(R.id.edt_purpose);
        duration=(EditText)findViewById(R.id.edt_duration);
        hmac=(EditText)findViewById(R.id.edt_Hmac);
        submitt=(Button)findViewById(R.id.btnsubmit);

        submitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namea=name.getText().toString();
                String rolla=roll.getText().toString();
                String depta=dept.getText().toString();
                String cnoa=cno.getText().toString();
                String emaila=email.getText().toString();
                Text purposea=((Text)purpose.getText());
                String durationa=duration.getText().toString();
                Text hmaca= ((Text) hmac.getText());
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
                else if(purposea.toString().isEmpty())
                {

                }
            }
        });
    }
}
