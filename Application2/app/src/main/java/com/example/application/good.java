package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class good extends AppCompatActivity {
    Button bt = null;
    TextView tv = null;
    ProgressBar pg = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);
        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv);
        pg= findViewById(R.id.pg);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownLoad().execute();
            }
        });
    }
    public class DownLoad extends AsyncTask<Void,Integer,Boolean>{
        @Override
        protected Boolean doInBackground(Void... voids) {
            int m = 0;
            while(m<=100){
                publishProgress(m);
                m+=5;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            tv.setText("下载完成");
            bt.setText("重新下载");
        }
        @Override
        protected void onPreExecute() {
            bt.setText("正在下载");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            tv.setText("当前进度"+values[0]+"%");
            pg.setProgress(values[0]);
        }
    }
}