package com.example.my930;

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

public class AdapterComputer extends ArrayAdapter<Computer> {
    int resourceId;
    public AdapterComputer(@NonNull Context context, int resource, @NonNull List<Computer> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Computer computer = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView imageView = view.findViewById(R.id.iv);
        TextView textView = view.findViewById(R.id.tv);
        TextView textView1 = view.findViewById(R.id.tv_0);
        TextView textView2 = view.findViewById(R.id.tv_1);
        imageView.setImageResource(computer.getImageid());
        textView.setText(computer.getName());
        textView1.setText(computer.getDetalied());
        textView2.setText(computer.getMoney());
        return view;
    }
}
