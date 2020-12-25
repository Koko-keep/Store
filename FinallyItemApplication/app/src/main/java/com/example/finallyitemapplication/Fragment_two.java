package com.example.finallyitemapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_two extends Fragment {
    ListView listView;
    List<Page> list = new ArrayList<>();
    private Order order = MainActivity.order;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        listView = view.findViewById(R.id.Lv);
        addStore(R.drawable.head,"食百味\n20-12-19 12:21","订单已完成,请评价");
        addStore(R.drawable.head,"炸鸡饭\n20-12-05 11:54","订单已完成,请评价");
        addStore(R.drawable.head,"DD冒菜\n20-11-27 18:18","订单已完成,请评价");
        if (order != null){
            addStore(order.getImg(),order.getStore()+"\n"+order.getTime(),"订单正在配送中");
        }
        ArrayAdapter<Page> arrayAdapter = new PageAdapter(getActivity(),R.layout.page,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"订单已完成,请前往评论,谢谢",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
    public void addStore(int num,String name,String message){
        Page page = new Page(num,name,message);
        list.add(page);
    }
}