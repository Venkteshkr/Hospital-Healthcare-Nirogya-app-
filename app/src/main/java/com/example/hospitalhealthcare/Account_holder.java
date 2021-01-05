package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Account_holder extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_holder);
        getSupportActionBar().setTitle("                     Verification");
        db=new DatabaseHelper(this);

        button=findViewById(R.id.btn_verify);
        editText=findViewById(R.id.edt4);
        textView=findViewById(R.id.text_error);

        SharedPreferences result =getSharedPreferences("SaveDetailing", Context.MODE_PRIVATE);
        final String name=result.getString("valuable","");
        final String name1=result.getString("valuable2","");
       // String name2=result.getString("value3","");
       // Toast.makeText(getApplicationContext(),""+name+name1,Toast.LENGTH_SHORT).show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText.getText().toString();

                if (number.isEmpty()||number.length()<10){
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }
                else {
                    boolean resultGood = db.checkUser(name, name1);
                    if (resultGood == true){

                        boolean resulttt = db.verify_mobile(number);
                        boolean solution=db.checkUser_mobile(name,number);

                    if (resulttt == true&&resultGood == true&&solution==true) {
                        String phone_no = "+" + "91" + number;
                        Intent intent = new Intent(Account_holder.this, Verify_number.class);
                        intent.putExtra("phonenumber", phone_no);
                        startActivity(intent);
                    } else {
                        textView.setText("please enter your registered number");
                        textView.setError("");
                        textView.requestFocus();
                        return;
                    }
                }
                }







            }
        });

    }


}
