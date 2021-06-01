package com.example.ip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MinAdapter extends ArrayAdapter<Mineral> {
    public MinAdapter(Context context, ArrayList<Mineral> arr) {
        super(context, R.layout.adapter_item,arr);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Mineral min = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }
        ((TextView) convertView.findViewById(R.id.name)).setText(min.name);
        ((ImageView) convertView.findViewById(R.id.image)).setImageResource(min.imageID);
        return convertView;
    }
}
