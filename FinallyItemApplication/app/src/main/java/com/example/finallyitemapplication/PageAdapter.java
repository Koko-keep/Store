package com.example.finallyitemapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PageAdapter extends ArrayAdapter<Page> {
    int ResourceId;
    public PageAdapter(@NonNull Context context, int resource, @NonNull List<Page> objects) {
        super(context, resource, objects);
        ResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Page page = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ResourceId,parent,false);
        ImageView imageView = view.findViewById(R.id.iv);
        TextView textView = view.findViewById(R.id.tv1);
        TextView textView1 = view.findViewById(R.id.tv2);
        imageView.setImageResource(page.getImg());
        textView.setText(page.getName());
        textView1.setText(page.getMessage());
        return view;
    }
}
