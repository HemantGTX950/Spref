package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONObject;

public class GsonFile extends AppCompatActivity {
Button showgson;
TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson_file);
        showgson=(Button)findViewById(R.id.showgson);
        show=(TextView)findViewById(R.id.gsontext);
        showgson.setOnClickListener(
                 new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Gson gson = new Gson();
                        Car audi = new Car("Audi","A4",1.8,false);
                        Car skoda = new Car("Skoda","Ocatavia",2.0,true);
                        Car[] cars={audi,skoda};
                        PersonDetails hb=new PersonDetails("Hemant","Bansal",991059682,19,cars);
                        show.setText(gson.toJson(hb));
                    }
                }
        );


    }
}
