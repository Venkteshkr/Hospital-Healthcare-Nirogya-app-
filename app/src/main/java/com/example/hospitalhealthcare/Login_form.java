package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Login_form extends AppCompatActivity {
Button btnn1;
EditText edt1,edt2;
DatabaseHelper db;
TextView txt;
Spinner spinner;
SharedPreferences sharedPreferences,sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        db=new DatabaseHelper(this);
        getSupportActionBar().setTitle("Login Here");
        btnn1=findViewById(R.id.button);
        edt1=findViewById(R.id.edt_email);
        edt2=findViewById(R.id.edt_pswd);

        txt=findViewById(R.id.txt1);
        spinner=findViewById(R.id.spinner_scroll);
        final ArrayAdapter<String> my_adapter=new ArrayAdapter<String>(Login_form.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
        my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(my_adapter);
     //   sp = getSharedPreferences("login",MODE_PRIVATE);

     //   if(sp.getBoolean("logged",false)){
     //       Intent intent2=new Intent(Login_form.this,User_signin.class);
      //      startActivity(intent2);
      //  }

        btnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edt1.getText().toString();
                String password=edt2.getText().toString();
                String textt=txt.getText().toString();
                if(email.equals("")&&password.equals("")){
                    txt.setText("Invalid email and password");
                    Toast.makeText(getApplicationContext(),"all fields are mandatory",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (email.equals("")){
                        edt1.setError("please fill the email");
                        edt1.requestFocus();
                        return;
                    }
                    else {
                        if(password.equals("")){
                            txt.setText("please fill the password");

                        }
                        else{
                            boolean res1=db.checkUser(email,password);
                            boolean res2=db.checkUserSpinner(spinner.getSelectedItem().toString(),email);
                            if (res1==true&&res2==true){
                                sharedPreferences=getSharedPreferences("SaveDetailing", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("valuable",email);
                                editor.putString("valuable2",password);
                                editor.putString("valuable3",spinner.getSelectedItem().toString());
                                editor.apply();
                              //  Toast.makeText(getApplicationContext(),"Successfully Login"+email+password,Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Login_form.this,Account_holder.class);
                                startActivity(intent);
                               // sp.edit().putBoolean("logged",true).apply();
                            }
                            else {
                                txt.setText("Invalid email and password");
                                Toast.makeText(getApplicationContext(),"Login error",Toast.LENGTH_SHORT).show();

                            }
                        }
                    }



                }



            }
        });

    }

    public void txt_register(View view) {
        Intent i=new Intent(Login_form.this,Registration_form.class);
        startActivity(i);
    }


}
