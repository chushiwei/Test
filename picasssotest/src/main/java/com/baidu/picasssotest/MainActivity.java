package com.baidu.picasssotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> list;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        list = new ArrayList<>();
        list.add("http://i.imgur.com/DvpvklR1.png");
        list.add("http://i.imgur.com/DvpvklR.png");
        list.add("http://i.imgur.com/DvpvklR2.png");
        list.add("http://i.imgur.com/DvpvklR.png");
        list.add("http://i.imgur.com/DvpvklR3.png");
        list.add("http://i.imgur.com/DvpvklR.png");
        list.add("http://i.imgur.com/DvpvklR.png");
        list.add("http://i.imgur.com/DvpvklR.png");
        myAdapter = new MyAdapter(list, this);

        listView.setAdapter(myAdapter);
    }
}
