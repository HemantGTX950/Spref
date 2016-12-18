package com.example.hemantbansal.spref;

import android.content.ContentValues;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import Database.DbHelper;

/**
 * Created by Hemant Bansal on 11/24/2016.
 */

public class DatabaserecyclerViewAdapter extends RecyclerView.Adapter<DatabaserecyclerViewAdapter.DatabaserecyclerViewHolder> {
    private Context context;
    private ArrayList<DbHelper.User> arrayList;

    public DatabaserecyclerViewAdapter(ArrayList<DbHelper.User> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public DatabaserecyclerViewAdapter.DatabaserecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new DatabaserecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.database_custum_row,parent,false));
    }

    @Override
    public void onBindViewHolder(DatabaserecyclerViewAdapter.DatabaserecyclerViewHolder holder, int position) {
        /*int n=arrayList.get(position).indexOf("\n");
        holder.name.setText((arrayList.get(position).substring(0,n)));
        holder.number.setText((arrayList.get(position).substring(n+1)));*/
        holder.name.setText(arrayList.get(position).getName().toString());
        holder.number.setText(arrayList.get(position).getPhone().toString());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    protected class  DatabaserecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView number;
        public DatabaserecyclerViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.database_custum_row_name_);
            number=(TextView)itemView.findViewById(R.id.database_custum_row_number_);

        }

    }
}
