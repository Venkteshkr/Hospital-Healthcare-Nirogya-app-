package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Doctor_access extends AppCompatActivity implements View.OnClickListener {
    Button button,button2,button3,button4,button5,button6,button7,button8,button9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_access);
        button = findViewById(R.id.button_l112);
        button2 = findViewById(R.id.button_l23);
        button3 = findViewById(R.id.button_l34);
        button4 = findViewById(R.id.button_l145);
        button5 = findViewById(R.id.button_l56);
        button6 = findViewById(R.id.button_l67);
        button7 = findViewById(R.id.button_l78);
        button8 = findViewById(R.id.button_l89);
        button9 = findViewById(R.id.button_l910);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            switch (v.getId()) {
                case R.id.button_l112:
                    Intent intent = new Intent(Doctor_access.this, Name_activity.class);
                    startActivity(intent);
                    break;
                case R.id.button_l23:
                   // Intent intent1 = new Intent(Doctor_access.this, Address_book.class);
                    //startActivity(intent1);
                    Toast.makeText(getApplicationContext(),"you are not allowed",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button_l34:
                    Intent intent2 = new Intent(Doctor_access.this, Contact_act.class);
                    startActivity(intent2);
                    break;
                case R.id.button_l145:
                    Intent intent3 = new Intent(Doctor_access.this, Past_record.class);
                    startActivity(intent3);
                    break;
                case R.id.button_l56:
                    Intent intent4 = new Intent(Doctor_access.this, Allergies.class);
                    startActivity(intent4);
                    break;
                case R.id.button_l67:
                    Intent intent5 = new Intent(Doctor_access.this, Infection.class);
                    startActivity(intent5);
                    break;
                case R.id.button_l78:
                    Intent intent6 = new Intent(Doctor_access.this, Patient_report.class);
                    startActivity(intent6);
                    break;
                case R.id.button_l89:
                    Intent intent7 = new Intent(Doctor_access.this, Doctor_details.class);
                    startActivity(intent7);
                    break;
                case R.id.button_l910:
                    Intent intent8 = new Intent(Doctor_access.this, Hospital_details.class);
                    startActivity(intent8);
                    break;
            }
        }
        catch(IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(),"please click on button",Toast.LENGTH_SHORT).show();
            e.printStackTrace();


        }

    }

}
