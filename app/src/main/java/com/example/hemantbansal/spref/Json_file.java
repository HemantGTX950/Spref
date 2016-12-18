package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json_file extends AppCompatActivity {
        Button showbutton;
    EditText nameinput;
    EditText classinput;
    Button enterbyarray;

    JSONArray arr = new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_file);
        showbutton=(Button)findViewById(R.id.show);
        enterbyarray=(Button)findViewById(R.id.byarray);
        nameinput=(EditText) findViewById(R.id.inputname);
        classinput=(EditText)findViewById(R.id.inputclass);

        final String json = "{'id':1,'value':[{'name':'rahul yadav','class':'CE'},{'name':'hemant','class':'IT'},{'name':'namit','class':'ECE'}]}";

        showbutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            JSONObject jsonobject=new JSONObject(json);
                            JSONArray jsonArray = jsonobject.getJSONArray("value");
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject j = jsonArray.getJSONObject(i);
                                Student st1 = new Student(j.getString("name"), j.getString("class"));
                                UtilMethods.toastS(Json_file.this, st1.getName() + "-" + st1.getClassname());
                            }
                        }catch (JSONException e){

                        }

                    }
                }
        );
        enterbyarray.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            for (int i = 0; i < 3; i++) {

                                JSONObject obj = new JSONObject();
                                obj.put("name", nameinput.getText().toString());
                                obj.put("class",classinput.getText().toString());
                                arr.put(i,obj);
                            }
                            for (int i=0;i<arr.length();i++){
                              //  UtilMethods.toastS(Json_file.this,arr.getString(i));
                                JSONObject j = arr.getJSONObject(i);
                                Student st1 = new Student(j.getString("name"), j.getString("class"));
                                UtilMethods.toastS(Json_file.this, st1.getName() + "-" + st1.getClassname());
                            }
                        }
                        catch (JSONException e){
                            UtilMethods.toastS(Json_file.this,"Exception");
                        }

                    }
                }
        );




    }
}
