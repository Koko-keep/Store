package com.example.finallyitemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DrinkActivity extends AppCompatActivity {
    private TextView bt_rm = null;
    private TextView bt_zk = null;
    private TextView bt_drink = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        bt_rm = findViewById(R.id.bt_remai);
        bt_zk = findViewById(R.id.bt_zhekou);
        bt_drink = findViewById(R.id.bt_drink);
        bt_rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrinkActivity.this,"此店暂无任何东西,请等待卖家上传",Toast.LENGTH_LONG).show();
            }
        });
        bt_zk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrinkActivity.this,"此店暂无任何东西,请等待卖家上传",Toast.LENGTH_LONG).show();
            }
        });
        bt_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DrinkActivity.this,"此店暂无任何东西,请等待卖家上传",Toast.LENGTH_LONG).show();
            }
        });
    }
}