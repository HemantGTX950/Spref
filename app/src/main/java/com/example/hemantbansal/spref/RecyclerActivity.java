package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView,recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);



        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(RecyclerActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ListObject obj1 = new ListObject("Canvas Painting","Rs. 1000",R.drawable.prd);
        ListObject obj2 = new ListObject("Headphones","Rs. 3000",R.drawable.headphones);
        ListObject obj3 = new ListObject("Plane Toy","Rs. 50",R.drawable.plane);
        ListObject obj4 = new ListObject("Game DVD Rayman","Rs. 500",R.drawable.rayman);
        //ListObject obj5 = new ListObject("this is title5","this is message5",R.drawable.prd);
        //ListObject obj6 = new ListObject("this is title6","this is message6",R.drawable.prd);

        ArrayList<ListObject> listObjects = new ArrayList<>();
        listObjects.add(obj1);
        listObjects.add(obj2);
        listObjects.add(obj3);
        listObjects.add(obj4);

       recyclerView.setAdapter(new RecyclerViewAdapter(listObjects,RecyclerActivity.this));
        recyclerView1=(RecyclerView)findViewById(R.id.recyclerview1);

        LinearLayoutManager layoutManager1=new LinearLayoutManager(RecyclerActivity.this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(layoutManager1);


        ListObject obj5 = new ListObject("Canvas asdsaPainting","Rs. 1000",R.drawable.prd);
        ListObject obj6 = new ListObject("Headphonesxzcx","Rs. 3000",R.drawable.headphones);
        ListObject obj7 = new ListObject("Plane Toyhjkhj","Rs. 50",R.drawable.plane);
        ListObject obj8 = new ListObject("Game DVD Raymanyuy","Rs. 500",R.drawable.rayman);

        ArrayList<ListObject> listObjects1 = new ArrayList<>();
        listObjects1.add(obj5);
        listObjects1.add(obj6);
        listObjects1.add(obj7);

        recyclerView1.setAdapter(new RecyclerViewAdapter(listObjects1,RecyclerActivity.this));





    }
}
