package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Continue_email extends AppCompatActivity {
Button button6;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DatabaseHelper(this);
        setContentView(R.layout.activity_continue_email);
        SharedPreferences result3 =getSharedPreferences("SaveDetailing", Context.MODE_PRIVATE);
        final String name7=result3.getString("valuable","");
       // final String name8=result.getString("valuable2","");
        final String name9=result3.getString("valuable3","");
        button6=findViewById(R.id.button_email2);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res3=db.checkUser_email_spin(name7,name9);
                if (res3==true)
                {
                    String s="Patient_Login";
                    String s2="Staff_Login";
                    String s1="Doctor_Login";
                    if (name9.equals(s)) {
                        Intent intent = new Intent(Continue_email.this, Gridview_activity.class);
                        startActivity(intent);
                    }
                    else if (name9.equals(s2)){
                        Intent intent3 = new Intent(Continue_email.this, Staff_access.class);
                        startActivity(intent3);
                    }
                    else if (name9.equals(s1))
                    {
                        Intent intent2 = new Intent(Continue_email.this, Doctor_access.class);
                        startActivity(intent2);
                        //Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"please input valid entry",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
