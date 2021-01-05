package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class Splace_Screen extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splace__screen);
        getSupportActionBar().hide();

        videoView=findViewById(R.id.video_view1);
        Uri video=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.abcvideonew);
        videoView.setVideoURI(video);


                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {


                            Intent intent = new Intent(Splace_Screen.this, Navigation_main.class);
                            startActivity(intent);
                            finish();

                        }
                        });
                    videoView.start();

    }
}
