package com.example.a1014_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button buttonjia;
    Button buttonjian;
    Button buttoncheng;
    Button buttonchu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);
        buttonjia = findViewById(R.id.btjia);
        buttonjian = findViewById(R.id.btjian);
        buttoncheng = findViewById(R.id.btcheng);
        buttonchu = findViewById(R.id.btchu);
        buttonjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double m = 0;
                double height1=Double.parseDouble(editText1.getText().toString());
                double height2=Double.parseDouble(editText2.getText().toString());
                m = height1 + height2;
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("num",m);
                startActivity(intent);
            }
        });
    }
}