package com.example.finallyitemapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_one extends Fragment {
    ListView listView;
    List<Page> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        listView = view.findViewById(R.id.Lv);
        addStore(R.drawable.head,"食百味\n销量21613","起送价￥0   配送￥2起");
        addStore(R.drawable.head,"茶芙\n销量1694","起送价￥8   配送￥1起");
        addStore(R.drawable.head,"DD冒菜\n销量1694","起送价￥8   配送￥2起");
        addStore(R.drawable.head,"火锅\n销量1694","起送价￥50   配送￥10起");
        addStore(R.drawable.head,"鸡\n销量1694","起送价￥10   配送￥1起");
        ArrayAdapter<Page> arrayAdapter = new PageAdapter(getActivity(),R.layout.page,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position = i + 1;
                if (position == 1){
                    Bundle bundle = new Bundle();
                    bundle.putString("store","食百味");
                    Intent intent = new Intent(getActivity(),InsideActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(),DrinkActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
    public void addStore(int num,String name,String message){
        Page page = new Page(num,name,message);
        list.add(page);
    }
}