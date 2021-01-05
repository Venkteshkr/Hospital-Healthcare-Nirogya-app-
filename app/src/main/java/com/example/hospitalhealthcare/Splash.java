package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity {
    RelativeLayout re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().setTitle("");
        getSupportActionBar().hide();
        getSupportActionBar().setBackgroundDrawable(null);
        re = findViewById(R.id.rl);

        Thread ob = new Thread() {
            public void run() {
                try {
                    sleep(2 * 1000);
                    Intent i = new Intent(Splash.this, Navigation_main.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }//upload prescription
            }
        };
        ob.start();
    }
}
