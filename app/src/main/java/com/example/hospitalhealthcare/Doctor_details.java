package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class Doctor_details extends AppCompatActivity {
DatabaseHelper db;
    TextView textView,textView2,textView3,textView4,textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DatabaseHelper(this);
        setContentView(R.layout.activity_doctor_details);
        textView=findViewById(R.id.patient_txt1);
        textView2=findViewById(R.id.patient_txt21);
        textView3=findViewById(R.id.patient_txt_t31);
        textView4=findViewById(R.id.patient_txt41);
        textView5=findViewById(R.id.patient_txt51);
        Cursor cursor=db.allData2();
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
            String name12=cursor.getString(0);
            String name22=cursor.getString(1);
            String name32=cursor.getString(2);
            String name42=cursor.getString(3);
            String name5=cursor.getString(4);
            builder.append(name12+"\n\n");
            builder1.append(name22+"\n\n");
            builder2.append(name32+"\n\n");
            builder3.append(name42+"\n\n");
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
