package com.example.android_lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> target;
    private ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] values=new String[]{"Pies","Kot","Koń","Gołąb","Kruk","Dzik","Karp","Osioł","Chomik","Mysz","Jeż"};
        this.target=new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));
        this.adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,this.target);
        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.setAdapter(this.adapter);

    }

}
