package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WikiHpe extends AppCompatActivity {
    String result;
    String s;
    TextView out;
    EditText inp;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_hpe);
        search=(Button)findViewById(R.id.search_btn);
        out=(TextView)findViewById(R.id.out_text);
        inp=(EditText)findViewById(R.id.input_field);

        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ky=inp.getText().toString();
                        if(ky.length()>0){
                            result="https://api.havenondemand.com/1/api/sync/querytextindex/v1?ignore_operators=false&promotion=false&summary=concept&summary_length=1000&total_results=false&apikey=439a27da-a17c-410c-9201-b8e12f6ddade&text=";
                            result=result+ky;
                            makingcall(result);
                        }
                    }
                }
        );

    }
    public void makingcall(String ur){
        /*Log.d("Url=",ur);*/
        Request request= new Request.Builder()
                .get()
                .url(ur)
                .build();
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                try {
                    JSONObject j=new JSONObject(res);
                    JSONArray ja=j.getJSONArray("documents");
                    JSONObject rest=ja.getJSONObject(0);
                    final String rs=rest.getString("summary");
                    runOnUiThread(
                            new Runnable() {
                                @Override
                                public void run() {
                                    out.setText(rs);
                                }
                            }
                    );
                }
                catch (JSONException e){
                    Log.d("Error","Json error");
                }
            }
        });
    }
}
//https://api.havenondemand.com/1/api/sync/querytextindex/v1?ignore_operators=false&promotion=false&summary=concept&summary_length=1000&total_results=false&apikey=439a27da-a17c-410c-9201-b8e12f6ddade&text=