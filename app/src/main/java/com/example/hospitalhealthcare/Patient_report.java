package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Patient_report extends AppCompatActivity {
 TextView textView,textView2,textView3,textView4,textView5;

        DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_report);
        db = new DatabaseHelper(this);
        textView=findViewById(R.id.patient_txt);
        textView2=findViewById(R.id.patient_txt2);
        textView3=findViewById(R.id.patient_txt_t3);
        textView4=findViewById(R.id.patient_txt4);
        textView5=findViewById(R.id.patient_txt5);
        Cursor cursor=db.allData();
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }
        StringBuilder builder=new StringBuilder();
        StringBuilder builder1=new StringBuilder();
        StringBuilder builder2=new StringBuilder();
        StringBuilder builder3=new StringBuilder();
        StringBuilder builder4=new StringBuilder();
        do {
        String name1=cursor.getString(0);
        String name2=cursor.getString(1);
            String name3=cursor.getString(2);
            String name4=cursor.getString(3);
            String name5=cursor.getString(4);
            builder.append(name1+"\n\n");
            builder1.append(name2+"\n\n");
            builder2.append(name3+"\n\n");
            builder3.append(name4+"\n\n");
            builder4.append(name5+"\n\n");


            //Toast.makeText(getApplicationContext(),""+name1+""+name2+""+name3+""+name4+""+name5,Toast.LENGTH_SHORT).show();
        }while (cursor.moveToNext());
        textView.setText(builder.toString());
        textView2.setText(builder1.toString());
        textView3.setText(builder2.toString());
        textView4.setText(builder3.toString());
        textView5.setText(builder4.toString());


    }



}