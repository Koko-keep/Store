package com.example.finallyitemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText et_username = null;
    private EditText et_pwd = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);
    }
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.login_bt:
                String username = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();
                if ("".equals(username) || "".equals(pwd))
                    Toast.makeText(LoginActivity.this,"请输入完整信息",Toast.LENGTH_LONG).show();
                List<User> users = LitePal.where("username like ? and pwd like ?", username,pwd).limit(1).find(User.class);
                if (users.size() == 1){
                    Bundle bundle=new Bundle();
                    bundle.putString("username","用户账号:"+username);
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtras(bundle);
                    et_username.setText("");
                    et_pwd.setText("");
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.register_bt:
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}