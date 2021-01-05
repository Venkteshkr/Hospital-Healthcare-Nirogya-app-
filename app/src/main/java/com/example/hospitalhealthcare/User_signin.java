package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class User_signin extends AppCompatActivity {
Button button,button2,button3;
TextView textView;
ProgressBar progressBar1;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signin);
        getSupportActionBar().setTitle("                  You are signed in");
        db=new DatabaseHelper(this);
        textView=findViewById(R.id.welcome);
        progressBar1=findViewById(R.id.progress_logout);
        button=findViewById(R.id.button_logout);
        button2=findViewById(R.id.signin_btn1);
        button3=findViewById(R.id.signin_btn2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(User_signin.this,Navigation_main.class);
                startActivity(intent6);
            }
        });



        SharedPreferences result =getSharedPreferences("SaveData", Context.MODE_PRIVATE);

        final String name=result.getString("value","");
        String name1=result.getString("value2","");
        String name2=result.getString("value3","");

        SharedPreferences result2 =getSharedPreferences("SaveDetail", Context.MODE_PRIVATE);
        String name3=result2.getString("valueText","");
        SharedPreferences result3 =getSharedPreferences("SaveDetailing", Context.MODE_PRIVATE);
        final String name8=result3.getString("valuable","");
        // final String name8=result.getString("valuable2","");
        final String name10=result3.getString("valuable3","");

        textView.setText("Welcome Mr. "+name+"\n"+name1+"\n"+name2+"\n"+name3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar1.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(User_signin.this,Navigation_main.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res4=db.checkUser_email_spin(name8,name10);
                if (res4==true)
                {
                    String s="Patient_Login";
                    String s2="Staff_Login";
                    String s1="Doctor_Login";
                    if (name10.equals(s)) {
                        Intent intent = new Intent(User_signin.this, Gridview_activity.class);
                        startActivity(intent);//patient
                    }
                    else if (name10.equals(s1))
                    {
                        Intent intent = new Intent(User_signin.this, Doctor_access.class);
                        startActivity(intent);//doctor
                        //Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                    }
                    else if (name10.equals(s2)){
                        Intent intent = new Intent(User_signin.this, Staff_access.class);
                        startActivity(intent);//staff
                    }
                }
            }
        });
    }
}
