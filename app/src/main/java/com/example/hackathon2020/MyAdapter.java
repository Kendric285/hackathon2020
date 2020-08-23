package com.example.hackathon2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<itemItem> {

    public MyAdapter(Context context, ArrayList list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_list_item, parent, false);
        itemItem currentCategoryItem = getItem(position);
       /* ImageView categoryItemImageView = convertView.findViewById(R.id.list_item_photo);
        TextView categoryItemTextView = convertView.findViewById(R.id.list_item_name);
        categoryItemImageView.setImageResource(currentCategoryItem.getPhoto());
        categoryItemTextView.setText(currentCategoryItem.getName());*/

        return convertView;
    }
}