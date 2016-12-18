package com.example.hemantbansal.spref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.rjeschke.txtmark.Processor;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WikiExtract extends AppCompatActivity {
    Button search,showout;
    EditText searchinp;
    TextView srchput;
    public String s="Empty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_extract);
        search=(Button)findViewById(R.id.search_btn);
        searchinp=(EditText)findViewById(R.id.search_input);
        srchput=(TextView)findViewById(R.id.search_output);
        showout=(Button)findViewById(R.id.show_out);

        search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content=searchinp.getText().toString();
                        String ur="http://en.wikipedia.org/w/api.php?format=json&action=query&titles="+content+"&prop=revisions&rvprop=content";
                        makingcall(ur);

                        srchput.setText(s);
                    }
                }
        );

        showout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        srchput.setText(s);
                    }
                }
        );
    }

    public void makingcall(String ur){
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
                    // String s=(((j.getJSONObject("query")).getJSONObject("pages")).getJSONObject("21721040")).getString("extract").toString();
                    j=j.getJSONObject("query");
                    j=j.getJSONObject("pages");
                    j=j.getJSONObject(j.names().get(0).toString());
                    JSONArray ja=(j.getJSONArray("revisions"));
                    j=ja.getJSONObject(0);
                     s=j.getString("*");
                    Log.d("EXtract=",s);

                    //for ui items

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            srchput.setText(s) ;
                        }
                    });
                    sets(s);
                }
                catch (JSONException e){
                    Log.d("Error","Json error");
                    sets("Error");
                }
            }
        });
    }
    public void sets(String st){
        s=st;
        //srchput.setText(s);
    }
}
