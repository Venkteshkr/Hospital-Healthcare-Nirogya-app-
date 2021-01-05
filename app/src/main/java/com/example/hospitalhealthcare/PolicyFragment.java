package com.example.hospitalhealthcare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PolicyFragment extends Fragment {
    TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_policy, container, false);
        textView=root.findViewById(R.id.venki_no);
        textView2=root.findViewById(R.id.bhatt_no);
        textView3=root.findViewById(R.id.vardhan_no);
        textView4=root.findViewById(R.id.gulshan_no);
        textView5=root.findViewById(R.id.venki_email);
        textView6=root.findViewById(R.id.bhatt_email);
        textView7=root.findViewById(R.id.vardhan_email);
        textView8=root.findViewById(R.id.gulshan_email);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myActivity1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9110978726"));
                startActivity(myActivity1);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myActivity2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7061643399"));
                startActivity(myActivity2);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myActivity3=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9546629966"));
                startActivity(myActivity3);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myActivity4=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9556054610"));
                startActivity(myActivity4);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(Intent.ACTION_SEND,Uri.fromParts("mailto","abc@gmail.com", null));;
                //intent.setType("text/html");
              //  String email="venkateshhh";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:1706283@kiit.ac.in"));
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(Intent.ACTION_SEND,Uri.fromParts("mailto","abc@gmail.com", null));;
                //intent.setType("text/html");
                //  String email="venkateshhh";
                Intent intent2 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:1706212@kiit.ac.in"));
                startActivity(Intent.createChooser(intent2, "Send Email"));
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(Intent.ACTION_SEND,Uri.fromParts("mailto","abc@gmail.com", null));;
                //intent.setType("text/html");
                //  String email="venkateshhh";
                Intent intent3 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:1706306@kiit.ac.in"));
                startActivity(Intent.createChooser(intent3, "Send Email"));
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(Intent.ACTION_SEND,Uri.fromParts("mailto","abc@gmail.com", null));;
                //intent.setType("text/html");
                //  String email="venkateshhh";
                Intent intent4 = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:1706322@kiit.ac.in"));
                startActivity(Intent.createChooser(intent4, "Send Email"));
            }
        });
        return root;
    }
}
