package com.example.finallyitemapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InsideActivity extends AppCompatActivity {
    private TextView bt_rm = null;
    public static String store = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);
        bt_rm = findViewById(R.id.bt_remai);
        FragmentManager supportFragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.fl,new EmptyFragment());
        fragmentTransaction1.commit();
    }
    public void Onclick(View view){
        switch (view.getId()){
            case R.id.bt_remai:
                Bundle bundle=this.getIntent().getExtras();
                store=bundle.getString("store");
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fl,new DetailsFragment());
                fragmentTransaction.commit();
                break;
            case R.id.bt_zhekou:
                FragmentManager supportFragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = supportFragmentManager1.beginTransaction();
                fragmentTransaction1.replace(R.id.fl,new EmptyFragment());
                fragmentTransaction1.commit();
        }
    }
}