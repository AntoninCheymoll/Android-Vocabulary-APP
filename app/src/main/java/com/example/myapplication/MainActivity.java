package com.example.myapplication;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adapter.Traduction_list_adapter;
import com.example.myapplication.models.Traduction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Traduction> trad_list = new ArrayList<>();
        trad_list.add(new Traduction("aaa","xxx"));
        trad_list.add(new Traduction("bbb","yyy"));
        trad_list.add(new Traduction("ccc","zzz"));

        ListView trad_list_view = findViewById(R.id.list_view);
        trad_list_view.setAdapter(new Traduction_list_adapter(this,trad_list));
    }
}
