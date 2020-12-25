package com.example.finallyitemapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowActivity extends AppCompatActivity {
    private VideoView videoView;
    public static String format = null;
    public static int m = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        videoView = findViewById(R.id.vv);
        if (ContextCompat.checkSelfPermission(ShowActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(ShowActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else {
            initVideoPath();
        }
    }
    private void initVideoPath(){
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.movie);
        videoView.setVideoURI(uri);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    initVideoPath();
                }else {
                    Toast.makeText(ShowActivity.this,"拒绝访问权限无法使用",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_start:
                if(!videoView.isPlaying()){
                    videoView.start();
                }
                break;
            case R.id.bt_stop:
                if(videoView.isPlaying()){
                    videoView.pause();
                }
                break;
            case R.id.bt_restart:
                if(videoView.isPlaying()){
                    videoView.resume();
                }
                break;
            case R.id.bt_buy:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
                Date date = new Date();
                format = simpleDateFormat.format(date);
                Intent intent = new Intent(ShowActivity.this, MainActivity.class);
                startActivity(intent);
                System.out.println(format);
                m++;
                Toast.makeText(ShowActivity.this,"下单完成,请等待配送",Toast.LENGTH_LONG).show();
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null){
            videoView.suspend();
        }
    }
}