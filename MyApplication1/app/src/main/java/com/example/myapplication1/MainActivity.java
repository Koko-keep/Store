package com.example.myapplication1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button bt1;
    private ProgressBar pb;
    private ListView Lv;
    private String[] data={"apple","banana","orange","pear","grape","cherry"};
    private List<Fruit> list = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        pb = findViewById(R.id.pb1);
//        Lv = findViewById(R.id.Lv);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//        MainActivity.this,android.R.layout.simple_list_item_1,data);
//        Lv.setAdapter(arrayAdapter);
        addFruit("苹果",R.drawable.apple_pic);
        addFruit("香蕉",R.drawable.banana_pic);
        addFruit("葡萄",R.drawable.cherry_pic);
        Lv = findViewById(R.id.Lv);
        ArrayAdapter<Fruit> Adapter = new FruirAdapter(MainActivity.this,R.layout.fruit,list);
        Lv.setAdapter(Adapter);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p;
                p = pb.getProgress();
                p = p + 10;
                pb.setProgress(p);
                //Toast.makeText(MainActivity.this,"你好",Toast.LENGTH_LONG).show();
                if(p==100)
                    pb.setProgress(0);

            }
        });
    }
    public void addFruit(String text,int image){
        Fruit fruit = new Fruit(text,image);
        list.add(fruit);
    }
}