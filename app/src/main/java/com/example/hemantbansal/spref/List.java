package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {


    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.mylistview);

        ListObject obj1 = new ListObject("this is title1","this is message1",R.drawable.prd);
        ListObject obj2 = new ListObject("this is title2","this is message2",R.drawable.prd);
        ListObject obj3 = new ListObject("this is title3","this is message3",R.drawable.prd);
        ListObject obj4 = new ListObject("this is title4","this is message4",R.drawable.prd);
        ListObject obj5 = new ListObject("this is title5","this is message5",R.drawable.prd);
        ListObject obj6 = new ListObject("this is title6","this is message6",R.drawable.prd);
        ArrayList<ListObject> listObjects = new ArrayList<>();
        listObjects.add(obj1);
        listObjects.add(obj2);
        listObjects.add(obj3);
        listObjects.add(obj4);
        listObjects.add(obj5);
        listObjects.add(obj6);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        ListAdapter adapter = new ListAdapter(listObjects);
        listView.setAdapter(adapter);
    }
}
