package com.example.datasaveapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv = null;
    EditText et = null;
    Button bt_save = null;
    Button bt_reveal = null;
    Button bt_sqlite = null;
    Button bt_addData = null;
    Button bt_checkData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
        bt_save = findViewById(R.id.bt_save);
        bt_reveal = findViewById(R.id.bt_reveal);
        bt_sqlite = findViewById(R.id.bt_sqlite);
        bt_addData = findViewById(R.id.bt_addData);
        bt_checkData = findViewById(R.id.bt_checkData);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mydata",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String s = et.getText().toString();
                edit.putString("password",s);
                edit.apply();
            }
        });
        bt_reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("Mydata",MODE_PRIVATE);
                String string = sharedPreferences.getString("password",null);
                tv.setText(string);
            }
        });
        bt_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });
        /*bt_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("沉默的废物");
                book.setAuthor("王垚");
                book.setPrice(5.00);
                book.save();
            }
        });
        bt_checkData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> list = DataSupport.where("price < ?","6").find(Book.class);
                for (Book book : list){
                    Log.d("name",book.getName());
                    Log.d("author",book.getAuthor());
                    Log.d("price", book.getPrice()+"");
                }
            }
        });*/
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_addData:
                addBook("沉默的孩子","王晶",23.5);
                break;
            case R.id.bt_checkData:
                QueryData();
                break;
            case R.id.bt_deleteData:
                deleteData(3);
            default:break;
        }
    }
    public void addBook(String name,String author,Double price){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        book.save();
    }
    public void QueryData(){
        List<Book> list = DataSupport.where("price < ?","6").find(Book.class);
        for (Book book : list){
            Log.d("name",book.getName());
            Log.d("author",book.getAuthor());
            Log.d("price", book.getPrice()+"");
        }
    }
    public void deleteData(int id){
        DataSupport.delete(Book.class,id);
    }
    public void updateData(Book book){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name","沉默的Xgp");
        DataSupport.update(Book.class,contentValues,4);
    }
}