package com.example.hemantbansal.spref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import Database.DbHelper;

public class DatabaseLandingActivity extends AppCompatActivity {
    Button lgbtn,saveBtn;
    EditText nameInput,numberInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_landing);
        final DbHelper dbHelper=new DbHelper(DatabaseLandingActivity.this);
        lgbtn=(Button)findViewById(R.id.log_database);
        nameInput=(EditText)findViewById(R.id.database_student_name_);
        numberInput=(EditText)findViewById(R.id.database_student_number_);
        saveBtn=(Button)findViewById(R.id.database_save_button_);
        lgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<DbHelper.User> arrayList=new ArrayList<DbHelper.User>();
                //getting list from database
                arrayList=dbHelper.retrieveListFromDb();

                int n=arrayList.size();
                for (int i=0;i<n;i++) {
                    Log.d("data:", arrayList.get(i).getName()+":"+arrayList.get(i).getPhone());

                }
                Intent i=new Intent(DatabaseLandingActivity.this,DatabaseListActivity.class);
                startActivity(i);

            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name,number;
                name=nameInput.getText().toString();
                number=numberInput.getText().toString();
                dbHelper.addEntryToDb(name,number);
            }
        });

    }
}
