package com.example.hemantbansal.spref;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hemant Bansal on 10/6/2016.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<ListObject> list;

    public ListAdapter(ArrayList<ListObject> list) {
        this.list = list;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row_layout,parent,false);

        TextView title = (TextView) view.findViewById(R.id.rowTitle);
        TextView mess = (TextView) view.findViewById(R.id.rowMessage);
        Button button = (Button) view.findViewById(R.id.rowButton);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );

        title.setText(list.get(position).getTitle());
        mess.setText(list.get(position).getMessage());

        return view;


    }

    @Override
    public int getCount() {
        return list.size();
    }
}
