package com.example.ip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=findViewById(R.id.search);
        EditText et=findViewById(R.id.et);
        TextView tv=findViewById(R.id.tv);
        ArrayList<Mineral> marr= make_min(),min;
        min = new ArrayList<>(marr);
        MinAdapter adapter=new MinAdapter(this,min);
        ListView lv= findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Mineral sm= (Mineral) adapter.getItem(i) ;
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("et",  sm.imageID);
            intent.putExtra("et1",  sm.mapID);
            intent.putExtra("et2",  sm.strID);
            startActivity(intent);
        });
        View.OnClickListener ls= v -> {
            String s=et.getText().toString();
            min.clear();
            Iterator it=marr.iterator();
            while(it.hasNext()){
                Mineral a= (Mineral) it.next();
                if (a.name.toLowerCase().contains(s.toLowerCase())) min.add(a);
            }

            if(min.isEmpty())  tv.setTextSize(24);
            else tv.setTextSize(0);
            adapter.notifyDataSetInvalidated();
        };
        bt.setOnClickListener(ls);

    }

    ArrayList<Mineral> make_min(){
        ArrayList<Mineral> arr=new ArrayList<>();
        String[] minNames= {"Аметист","Алмаз","Шеелит","Касситерит","Жеода хальцедона","Паравоксит","Базальт","Голубой агат","Везувий","Эритрин","Марказит","Эпидот","энигматит","Брусит","Пиролюзит"};
        int imageIDs[] ={R.drawable.ametist,R.drawable.diamond,R.drawable.she,R.drawable.kas,R.drawable.zhe,R.drawable.para,R.drawable.baz,R.drawable.agat,R.drawable.vez,R.drawable.ery,R.drawable.mark,R.drawable.epi,R.drawable.enigma,R.drawable.bru,R.drawable.pyro},
        mapIDs[]={R.drawable.ametistm,R.drawable.diamondm,R.drawable.shem,R.drawable.kasm,R.drawable.zhem,R.drawable.param,R.drawable.bazm,R.drawable.agatm,R.drawable.vezm,R.drawable.erym,R.drawable.markm,R.drawable.epim,R.drawable.enigmam,R.drawable.brum,R.drawable.pyrom},
        stringIDs[][]={{R.string.ametist1,R.string.ametist2,R.string.ametist3,R.string.ametist4},
                {R.string.diamond1,R.string.diamond2,R.string.diamond3,R.string.diamond4},
                {R.string.shee1,R.string.shee2,R.string.shee3,R.string.shee4},
                {R.string.kas1,R.string.kas2,R.string.kas3,R.string.kas4},
                {R.string.zhe1,R.string.zhe2,R.string.zhe3,R.string.zhe4},
                {R.string.para1,R.string.para2,R.string.para3,R.string.para4},
                {R.string.baz1,R.string.baz2,R.string.baz3,R.string.baz4},
                {R.string.aga1,R.string.aga2,R.string.aga3,R.string.aga4},
                {R.string.vez1,R.string.vez2,R.string.vez3,R.string.vez4},
                {R.string.ery1,R.string.ery2,R.string.ery3,R.string.ery4},
                {R.string.mark1,R.string.mark2,R.string.mark3,R.string.mark4},
                {R.string.epy1,R.string.epy2,R.string.epy3,R.string.epy4},
                {R.string.enigma1,R.string.enigma2,R.string.enigma3,R.string.enigma4},
                {R.string.bru1,R.string.bru2,R.string.bru3,R.string.bru4},
                {R.string.pyro1,R.string.pyro2,R.string.pyro3,R.string.pyro4},


        };
        int ln=minNames.length;
        int i;
        for (i=0;i<ln;i++){
            Mineral min = new Mineral();
            min.name = minNames[i];
            min.imageID = imageIDs[i];
            min.mapID=mapIDs[i];
            for(int j=0;j<4;j++) min.strID[j]=stringIDs[i][j];
            arr.add(min);
        }
        arr.sort(new MinCompare());
        return arr;
    }


    class MinCompare implements Comparator<Mineral>{

        @Override
        public int compare(Mineral o1, Mineral o2) {

            return o1.name.compareTo(o2.name);
        }
    }
}