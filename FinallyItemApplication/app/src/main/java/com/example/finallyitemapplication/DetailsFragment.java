package com.example.finallyitemapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends Fragment {
    private List<Page> list = new ArrayList<>();
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        listView = view.findViewById(R.id.lv_);
        addStore(R.drawable.head,"酸汤肥牛饭+米饭\n销量2924","￥12.94/份");
        addStore(R.drawable.head,"鸡米芽菜盖饭\n销量819","￥12.99/份");
        addStore(R.drawable.head,"鱼香茄子盖饭\n销量12591","￥12/份");
        ArrayAdapter<Page> arrayAdapter = new PageAdapter(getActivity(),R.layout.page,list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent intent = new Intent(getActivity(),ShowActivity.class);
                    startActivity(intent);
                }else
                Toast.makeText(getActivity(),"此菜品暂未开发",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
    public void addStore(int num,String name,String message){
        Page page = new Page(num,name,message);
        list.add(page);
    }
}