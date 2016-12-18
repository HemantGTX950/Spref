package com.example.hemantbansal.spref;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Hemant Bansal on 10/12/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<ListObject> listObjects;
    public RecyclerViewAdapter(ArrayList<ListObject> listObject,Context context) {
        this.listObjects=listObject;
        this.context=context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return listObjects.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {

        holder.title.setText(listObjects.get(position).getTitle());
        holder.msg.setText(listObjects.get(position).getMessage());
        holder.imageView.setImageResource(listObjects.get(position).getImageId());
        holder.btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Added",Toast.LENGTH_SHORT).show();
                    }
                }
        );


    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_layout,parent,false));
    }

    protected class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView msg;
        Button btn;
        ImageView imageView;


        public RecyclerViewHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.rowTitle);
            msg=(TextView)itemView.findViewById(R.id.rowMessage);
            btn=(Button)itemView.findViewById(R.id.rowButton);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }

    }
}
