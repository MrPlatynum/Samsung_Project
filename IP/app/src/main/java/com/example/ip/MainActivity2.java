package com.example.ip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int imID=getIntent().getIntExtra("et",-1),mapID=getIntent().getIntExtra("et1",-1),strID[]=getIntent().getIntArrayExtra("et2");
        ImageView iv=findViewById(R.id.iv),map=findViewById(R.id.map);
        TextView tv[]={findViewById(R.id.tv),findViewById(R.id.tv1),findViewById(R.id.tv2),findViewById(R.id.places)};
        iv.setImageResource(imID); map.setImageResource(mapID);
        for(int i=0;i<4;i++) tv[i].setText(strID[i]);
    }
}