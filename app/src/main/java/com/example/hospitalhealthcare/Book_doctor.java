package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Book_doctor extends AppCompatActivity {
ArrayAdapter arrayAdapter;
Spinner spinner;
Button button;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_doctor);
        spinner=findViewById(R.id.spinner_123);
        button=findViewById(R.id.button_doctor);
        final ArrayAdapter<String> my_adapter=new ArrayAdapter<String>(Book_doctor.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names2));
        my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(my_adapter);
        Toast.makeText(getApplicationContext(),"your appointment booked with"+spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Book_doctor.this,Book_appointment2.class);
               startActivity(intent);
           }
       });
    }
}
