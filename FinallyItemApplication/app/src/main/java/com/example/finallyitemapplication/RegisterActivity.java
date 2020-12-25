package com.example.finallyitemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_username = null;
    private EditText et_pwd = null;
    private Button toLogin = null;
    private Button register = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
        toLogin = findViewById(R.id.login_bt);
        register = findViewById(R.id.register_bt);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();
                List<User> users = LitePal.where("username = ?", username).find(User.class);
                if ("".equals(username) || "".equals(pwd)){
                    Toast.makeText(RegisterActivity.this,"请输入完整信息",Toast.LENGTH_LONG).show();
                }else if (users.size() != 0){
                    Toast.makeText(RegisterActivity.this,"此账号已被注册",Toast.LENGTH_LONG).show();
                }else {
                    User user = new User();
                    user.setUsername(username);
                    user.setPwd(pwd);
                    user.save();
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}