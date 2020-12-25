package com.example.notificationapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    static final int TAKE_PHOTO = 1;
    Button button = null;
    EditText editText = null;
    Button bt_ = null;
    ImageView iv = null;
    Uri image_Uri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.bt);
        editText = findViewById(R.id.et);
        bt_ = findViewById(R.id.bt_);
        iv = findViewById(R.id.iv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Empty.class);
                PendingIntent activity = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("有消息了")
                        .setContentText(editText.getText().toString())
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setAutoCancel(true)
                        .setContentIntent(activity)
                        .build();
                manager.notify(1,notification);
            }
        });

        bt_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(getExternalCacheDir(),"image.jpg");
                try {
                    if(file.exists()){
                        file.delete();
                    }
                    file.createNewFile();
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT >=24){
                    image_Uri = FileProvider.getUriForFile(MainActivity.this,"com.example.notificationapplication",file);
                }else {
                    image_Uri = Uri.fromFile(file);
                }
                Intent intent = new Intent("android.meta.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,image_Uri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(image_Uri));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }
}