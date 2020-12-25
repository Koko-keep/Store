package com.example.finallyitemapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageView bt1 = null;
    private ImageView bt2 = null;
    private ImageView bt3 = null;
    private String time = ShowActivity.format;
    private String store = InsideActivity.store;
    public static String username = "";
    public static Order order = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        if (ShowActivity.m == 1){
            Bundle bundle=this.getIntent().getExtras();
            username=bundle.getString("username");
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Fl,new Fragment_one());
        fragmentTransaction.commit();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Fl,new Fragment_one());
                fragmentTransaction.commit();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(time);
                if (time != null){
                    order = new Order();
                    order.setImg(R.drawable.head);
                    order.setStore(store);
                    order.setTime(time);
                }
                System.out.println(order);
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Fl,new Fragment_two());
                fragmentTransaction.commit();
                time = null;
                store = null;
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Fl,new Fragment_three());
                fragmentTransaction.commit();
            }
        });
    }
}