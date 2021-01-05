package com.example.hospitalhealthcare;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.data.SingleRefDataBufferIterator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verify_number extends AppCompatActivity {
   private EditText editText;
   private Button button;
   DatabaseHelper db;
   private ProgressBar progressBar;
private String verification_later;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=new DatabaseHelper(this);
        setContentView(R.layout.activity_verify_number);
        SharedPreferences result =getSharedPreferences("SaveDetailing", Context.MODE_PRIVATE);
        final String name7=result.getString("valuable","");
        final String name8=result.getString("valuable2","");
        getSupportActionBar().setTitle("                 Get verification code");
        mAuth=FirebaseAuth.getInstance();
        editText=findViewById(R.id.edt_entercode);
        button=findViewById(R.id.btn_sign_in);
        progressBar=findViewById(R.id.progress_br);

        String phonenumber=getIntent().getStringExtra("phonenumber");
        sendverification(phonenumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcode=editText.getText().toString();

                if (newcode.isEmpty()||newcode.length()<6){
                    editText.setError("enter valid code....");
                    editText.requestFocus();
                    return;
                }

                    progressBar.setVisibility(View.VISIBLE);
                    verifycode(newcode);

            }
        });
    }
    private void verifycode(String code){
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verification_later,code);
        signInwithcredential(credential);
    }

    private void signInwithcredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                                    Intent intent = new Intent(Verify_number.this, User_signin.class);
                                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK | intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);


                        }
                        else {
                            Toast.makeText(Verify_number.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private  void sendverification(String number){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60, TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verification_later = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code=phoneAuthCredential.getSmsCode();
            if(code!=null){
                progressBar.setVisibility(View.VISIBLE);
                verifycode(code);
            }


        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Verify_number.this,e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    };
}
