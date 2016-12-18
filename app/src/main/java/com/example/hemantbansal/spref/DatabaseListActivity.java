package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import Database.DbHelper;

public class DatabaseListActivity extends AppCompatActivity {
    DbHelper dbHelper;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);
        recyclerView=(RecyclerView)findViewById(R.id.database_recycler_view_);

        ArrayList<String> arrayList=new ArrayList<String>();
        dbHelper=new DbHelper(DatabaseListActivity.this);
        arrayList=dbHelper.retrieveInfoFromDb();
        LinearLayoutManager layoutManager=new LinearLayoutManager(DatabaseListActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DatabaserecyclerViewAdapter(arrayList,DatabaseListActivity.this));



    }
}
