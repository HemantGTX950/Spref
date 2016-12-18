package com.example.hemantbansal.spref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selector extends AppCompatActivity {
    Button opendialog,openlogin,openlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        opendialog=(Button)findViewById(R.id.OpenDialog);
        openlist=(Button)findViewById(R.id.openList);
        openlogin=(Button)findViewById(R.id.openLogin);
        opendialog.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Selector.this,Dialogs.class);
                        startActivity(i);
                    }
                }
        );
        openlist.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Selector.this,List.class);
                        startActivity(i);
                    }
                }
        );
        openlogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Selector.this,MainActivity.class);
                        startActivity(i);
                    }
                }
        );
        
    }
}
