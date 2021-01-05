package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration_form extends AppCompatActivity  {

    Spinner spinner;
    RadioGroup radioGroup1;
    RadioButton radioButton_male,radioButton_female,radioButton3_other;
    Button btn_register;
    SharedPreferences sharedPreferences;
    EditText edt1_pswrd,edt2_cnfpswrd,edt3_name,edt4_id,edt5_email,edt6_phone;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        db=new DatabaseHelper(this);
        getSupportActionBar().setTitle("Registration form");
        btn_register=findViewById(R.id.btn1);
        edt1_pswrd=findViewById(R.id.pswrd);
        edt2_cnfpswrd=findViewById(R.id.pswrd2);
        edt3_name=findViewById(R.id.name);
        edt4_id=findViewById(R.id.id1);
        edt5_email=findViewById(R.id.email1);
        edt6_phone=findViewById(R.id.phone_no);
        radioGroup1=findViewById(R.id.radio_grp);
        radioButton_male=findViewById(R.id.radio_btn);
        radioButton_female=findViewById(R.id.radio_btn2);
        radioButton3_other=findViewById(R.id.radio_btn3);
        spinner=findViewById(R.id.spin);
        final ArrayAdapter<String> my_adapter=new ArrayAdapter<String>(Registration_form.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(my_adapter);
       // spinner.setOnItemSelectedListener(this);
       // spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         //   @Override
           // public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             //   String selected=parent.getItemAtPosition(position).toString();

            //}

            //@Override
            //public void onNothingSelected(AdapterView<?> parent) {

            //}
        //});
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt3_name.getText().toString().trim();
                //String id=edt4_id.getText().toString().trim();
                String email = edt5_email.getText().toString().trim();
                String mob_phone = edt6_phone.getText().toString().trim();

                //int select=radioGroup1.getCheckedRadioButtonId();
                //RadioButton gender=(RadioButton)
                //findViewById(select);

                String pwd = edt1_pswrd.getText().toString().trim();
                String c_pwd = edt2_cnfpswrd.getText().toString().trim();

                if (name.equals("") || email.equals("") || mob_phone.equals("") || pwd.equals("") || c_pwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "fields are empty", Toast.LENGTH_SHORT).show();


                }
                else
                {
                    if (pwd.equals(c_pwd)){
                        boolean ckemail=db.chk_email(email);
                        if (ckemail==true) {
                            //boolean mobile1 = db.chk_mobile(mob_phone);
                           // if (mobile1 == true){
                                boolean result = db.addUser(email, name, mob_phone,spinner.getSelectedItem().toString(), pwd);
                            if (result == true) {
                                sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("value", name);
                                editor.putString("value2", email);
                                editor.putString("value3", mob_phone);

                                editor.apply();


                                Toast.makeText(getApplicationContext(), "registered successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "registration error", Toast.LENGTH_SHORT).show();
                            }
                       // }
                          //  else {
                               // Toast.makeText(getApplicationContext(), "This number is already registered", Toast.LENGTH_SHORT).show();
                           // }
                        }
                        else {

                            Toast.makeText(getApplicationContext(),"email already exists",Toast.LENGTH_SHORT).show();
                            edt5_email.setError("email already exists");
                            edt5_email.requestFocus();
                            return;
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"password not matched",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public void txt_login(View view) {
        Intent intent=new Intent(Registration_form.this,Login_form.class);
        startActivity(intent);
    }



}
