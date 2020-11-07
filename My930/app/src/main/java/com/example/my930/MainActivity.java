package com.example.my930;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Computer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addComputer(R.drawable.computer_1,"荣耀猎人HONOR HUNTER V700 16.1英寸游戏笔记本电脑(i7-10750H 16G 512G RTX2060 144Hz 100%sRGB)幻夜黑","显卡型号:2060\n屏幕刷新率:144Hz\n核心:六核", "￥8499.00");
        addComputer(R.drawable.computer_4,"小米 Redmi G 轻薄本 16.1英寸(第十代英特尔酷睿i5-10200H 16G 512G PCIe GTX 1650 100%sRGB 暗影黑)笔记本电脑","处理器:Intel i5\n显卡型号:1650\n屏幕刷新率60Hz","￥4969.00");
        addComputer(R.drawable.computer_5,"戴尔DellG3游戏本\nGTX1650 | G模式一键散热 | 双通道","处理器:Intel i5\n屏幕刷新率:60Hz\n核心:四核","￥4799.00");
        addComputer(R.drawable.computer_3,"联想(Lenovo)拯救者Y7000P 15.6英寸游戏笔记本电脑(i7-10750H 16G 512G SSD GTX1650Ti 144Hz100%sRGB)","处理器:Intel i7\n显卡型号:150Ti\n屏幕刷新率:144Hz","￥7499.00");
        addComputer(R.drawable.computer_6,"小米 Redmi G 轻薄本 16.1英寸 高色域(第十代英特尔酷睿i5-10300H 16G 512G PCIe GTX 1650Ti 1444Hz 电竞屏 暗...","处理器:Intel i5\n显卡型号:1650Ti\n屏幕刷新率:144Hz","￥6299.00");
        addComputer(R.drawable.computer_7,"小米游戏本Remid G 16.1英寸4G独显轻薄红米笔记本电脑电竞吃鸡 办公 编程 设计 学生 高色域i5-10200H GTX1650...","处理器:Intel i7\n显卡型号:1650Ti\n屏幕刷新率:144Hz","$5199.00");
        addComputer(R.drawable.computer_2,"华硕(ASUS)飞行堡垒8 十代8核英特尔酷睿i7 15.6英寸游戏笔记本电脑(i7-10870H 16G 512G GTX1660...","屏幕刷新率:144Hz\n核心:八核","￥8099.00");
        listView = findViewById(R.id.Lv);
        ArrayAdapter<Computer> arrayAdapter = new AdapterComputer(MainActivity.this,R.layout.compter_city,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i + 1;
                Toast.makeText(MainActivity.this,"第"+position+"个商品暂无数据",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,detalied.class);
                startActivity(intent);
            }
        });
        TextView textView = findViewById(R.id.tv_0);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"此活动暂未开启",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void addComputer(int Imageid,String name,String Detalied,String Money){
        Computer computer = new Computer(Imageid,name,Detalied,Money);
        list.add(computer);
    }
}