package com.example.myapplication;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapter.Traduction_list_adapter;
import com.example.myapplication.models.Traduction;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Traduction> trad_list = parsefile();

        ListView trad_list_view = findViewById(R.id.list_view);
        trad_list_view.setAdapter(new Traduction_list_adapter(this,trad_list));
    }

    private ArrayList<Traduction> parsefile(){

        //write
        String fn = "myfile";
        String fileContents = "Hello@world!\n  aaa@wbdde\n oooo@kkk\n ";

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fn, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //read

        ArrayList<Traduction> trad_list = new ArrayList<Traduction>();
        String filename = "myfile";


        try {
            FileInputStream inputStream = openFileInput(filename);

            String item1 = "";
            int c;
            String temp="";

            while( (c = inputStream.read()) != -1){

                if(((char) c) == '@'){
                    item1 = temp;
                    temp = "";

                }else if(((char) c) == '\n'){
                    trad_list.add(new Traduction(item1,temp));
                    temp = "";
                    item1 = "";

                }else{
                    temp = temp + Character.toString((char) c);
                }
            }

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trad_list;
    }
}
