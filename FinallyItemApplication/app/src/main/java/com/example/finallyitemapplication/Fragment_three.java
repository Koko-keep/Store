package com.example.finallyitemapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Fragment_three extends Fragment implements View.OnClickListener{
    private TextView tv_jf = null;
    private TextView tv_yhj = null;
    private TextView tv_sc = null;
    private TextView tv_all = null;
    private ImageView img_1 = null;
    private ImageView img_2 = null;
    private ImageView img_3 = null;
    private ImageView img_4 = null;
    private TextView tv2 = null;
    private TextView tv_local = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        tv_jf = view.findViewById(R.id.tv_jf);
        tv_jf.setOnClickListener(this);
        tv_yhj = view.findViewById(R.id.tv_yhj);
        tv_yhj.setOnClickListener(this);
        tv_sc = view.findViewById(R.id.tv_sc);
        tv_sc.setOnClickListener(this);
        tv_all = view.findViewById(R.id.tv_all);
        tv_all.setOnClickListener(this);
        img_1 = view.findViewById(R.id.img_1);
        img_1.setOnClickListener(this);
        img_2 = view.findViewById(R.id.img_2);
        img_2.setOnClickListener(this);
        img_3 = view.findViewById(R.id.img_3);
        img_3.setOnClickListener(this);
        img_4 = view.findViewById(R.id.img_4);
        img_4.setOnClickListener(this);
        tv2 = view.findViewById(R.id.tv2);
        tv2.setText(MainActivity.username);
        tv_local = view.findViewById(R.id.tv_local);
        tv_local.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_jf:
                Toast.makeText(getActivity(),"此功能暂未开发",Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_yhj:
                Toast.makeText(getActivity(),"此功能暂未开发",Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_sc:
                Toast.makeText(getActivity(),"此功能暂未开发",Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_all:
                FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.Fl,new Fragment_two());
                fragmentTransaction.commit();
                break;
            case R.id.img_1:
                Toast.makeText(getActivity(),"此功能正在整改",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_2:
                Toast.makeText(getActivity(),"此功能正在整改",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_3:
                Toast.makeText(getActivity(),"此功能正在整改",Toast.LENGTH_LONG).show();
                break;
            case R.id.img_4:
                Toast.makeText(getActivity(),"此功能正在整改",Toast.LENGTH_LONG).show();
                break;
            case R.id.tv_local:
                Intent intent = new Intent(getActivity(),MainActivity1.class);
                startActivity(intent);
                tv_local.setText(MainActivity1.local);
        }
    }
}