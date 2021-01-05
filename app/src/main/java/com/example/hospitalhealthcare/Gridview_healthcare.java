package com.example.hospitalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.jar.Attributes;

public class Gridview_healthcare extends AppCompatActivity {
    GridView gv;
    String s[]={"Name","Address book","Contact","past record ","Allergies","Infection","Patient report","Doctor details","Hospital details"};
   // String c[]={Name.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_healthcare);
        gv=findViewById(R.id.grid_v);
        ArrayAdapter<String> ar=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,s);
        gv.setAdapter(ar);
        //gv.setBackgroundColor(Color.RED);

       // gv.setBackgroundResource(R.drawable.saffron2);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = s[position];
                try {
                //    Intent intent=new Intent(Gridview_healthcare.this,c[position]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
