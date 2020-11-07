package com.example.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BroadCastActivity extends AppCompatActivity {
    Button button;
    MyBroadCast myBroadCast;
    IntentFilter intentFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        /*button=findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("MyBroadCast");
                intent.putExtra("send","点亮灯光");
                sendBroadcast(intent);
                myBroadCast = new MyBroadCast();
                intentFilter = new IntentFilter();
                intentFilter.addAction("MyBroadCast");
                registerReceiver(myBroadCast,intentFilter);
            }
        });*/
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        myBroadCast = new MyBroadCast();
        registerReceiver(myBroadCast,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadCast);
    }

    class MyBroadCast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Toast.makeText(BroadCastActivity.this,"网络错误",Toast.LENGTH_LONG).show();
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if(activeNetworkInfo != null && activeNetworkInfo.isAvailable())
                Toast.makeText(context,"网络已开启",Toast.LENGTH_LONG).show();
            else Toast.makeText(context,"网络已关闭",Toast.LENGTH_LONG).show();
        }
    }
}