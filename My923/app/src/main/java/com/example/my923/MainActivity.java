package com.example.my923;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView Lv;
    private static List<Fruit> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFruit("苹果",R.drawable.apple_pic);
        addFruit("香蕉",R.drawable.banana_pic);
        addFruit("樱桃",R.drawable.cherry_pic);
        addFruit("芒果",R.drawable.mango_pic);
        addFruit("葡萄",R.drawable.grape_pic);
        Lv = findViewById(R.id.Lv);
        ArrayAdapter<Fruit> arrayAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit,list);
        Lv.setAdapter(arrayAdapter);
    }
    public static void addFruit(String name,int image){
        Fruit fruit = new Fruit(name,image);
        list.add(fruit);
    }
}