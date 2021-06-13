package com.example.listgridactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
GridView lv1;

    String name[]= {"DEMO 1","DEMO 2","DEMO 3","DEMO 4","DEMO 5","DEMO 6","DEMO 7","DEMO 8","DEMO 9","DEMO 10","DEMO 11","DEMO 12","DEMO 13","DEMO 14","DEMO 15","DEMO 16","DEMO 17","DEMO 18"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv1= findViewById(R.id.lv1);

        ArrayAdapter arrayAdapter= new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_list_item_1,name);

        lv1.setAdapter(arrayAdapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,"You Select "+name[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}