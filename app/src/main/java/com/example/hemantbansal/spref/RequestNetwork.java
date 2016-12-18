package com.example.hemantbansal.spref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okio.BufferedSink;

public class RequestNetwork extends AppCompatActivity {
Button jplace,ggl,hive,jcnt,wiki,wikisearch,hpe,senti;
    TextView showdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_network);
        jplace=(Button)findViewById(R.id.jplace_btn);
        senti=(Button)findViewById(R.id.senti_btn);
        hpe=(Button)findViewById(R.id.summary);
        ggl=(Button)findViewById(R.id.google_btn);
        hive=(Button)findViewById(R.id.hiv_btn);
        jcnt=(Button)findViewById(R.id.jcontest_btn);
        wiki=(Button)findViewById(R.id.wiki_btn);
        showdata=(TextView)findViewById(R.id.showdata);
        wikisearch=(Button)findViewById(R.id.wiki_search_btn);
        senti.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RequestNetwork.this,SentimentAnalysis.class));
                    }
                }
        );
        hpe.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RequestNetwork.this,WikiHpe.class));
                    }
                }
        );
        wikisearch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(RequestNetwork.this,WikiExtract.class);
                        startActivity(i);
                    }
                }
        );

        ggl.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MakeCall.show("http://www.google.com",0);
                    }
                }
        );
        hive.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ur="http://api.androidhive.info/contacts/";
                        MakeCall.show(ur,1);
                    }
                }
        );

        jcnt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ur="http://echo.jsontest.com/key/value/one/two";
                        MakeCall.show(ur,1);
                    }
                }
        );

        jplace.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ur="https://jsonplaceholder.typicode.com/posts";
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
                                //Log.d("Okkhttp Debug:",res);
                                // ret(res);
                                try {
                                    JSONArray jsonArray=new JSONArray(res);



                                    Log.d("JSONPlace Holder:", jsonArray.getJSONObject(0).toString());
                                }
                                catch (JSONException e){

                                }


                            }
                        });
                    }
                }
        );

//wiki extract
        wiki.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ur="https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=Stack%20Overflow";
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
                                   String s=(((j.getJSONObject("query")).getJSONObject("pages")).getJSONObject("21721040")).getString("extract").toString();



                                    Log.d("JSONPlace Holder:", res);
                                    Log.d("EXtract=",s);
                                }
                                catch (JSONException e){
                                    Log.d("Error","Json error");
                                }


                            }
                        });
                    }
                }
        );




    }





}
