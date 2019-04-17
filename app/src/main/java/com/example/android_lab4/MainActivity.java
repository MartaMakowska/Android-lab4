package com.example.android_lab4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> target;
    private SimpleCursorAdapter adapter;
    MySQLite db = new MySQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String[] values=new String[]{"Pies","Kot","Koń","Gołąb","Kruk","Osioł", "Chomik", "Mysz", "Jeż", "Kraluch"};
        this.target=new ArrayList<String>();
        //this.target.addAll(Arrays.asList(values));
        this.adapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,db.lista(), new String[]{"_id", "gatunek"},
                new int[]{android.R.id.text1,android.R.id.text2},
                SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE);

        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(this.adapter);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
    public void nowyWpis(MenuItem mi){
        Intent intencja=new Intent(this,DodajWpis.class);
        startActivityForResult(intencja,1);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==1 && resultCode==RESULT_OK){
            Bundle extras=data.getExtras();
            //String nowy=(String)extras.get("wpis");
            Animal nowy=(Animal)extras.getSerializable("nowy");
            this.db.dodaj(nowy);
            //target.add(nowy);
            adapter.changeCursor(db.lista());
            adapter.notifyDataSetChanged();
        }
    }

}
