package com.example.hemantbansal.spref;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Hemant Bansal on 11/1/2016.
 */

public class MakeCall {

    public static void show(String url1,int n){



        if(n==0){
            RequestBody requestBody=new FormEncodingBuilder()
                    .add("Name","Hemant")
                    .build();
            Request request=new Request.Builder()
                    .post(requestBody)
                    .url(url1)
                    .build();
            make_req(request);
        }
        else if(n==1) {
            Request request= new Request.Builder()
                    .get()
                    .url(url1)
                    .build();
            make_req(request);

        }
    }
    public static void returnsummary(String url){
        Request request= new Request.Builder()
                .get()
                .url(url)
                .build();
        String sum="";
        make_req1(request);

    }
    public static void make_req1(Request request){
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                Log.d("Okkhttp Debug:",res);
                try{
                    JSONObject j=new JSONObject(res);

                }catch (JSONException e){

                }
            }
        });
    }



    public static void make_req(Request request){
        OkHttpClient okHttpClient=new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                Log.d("Okkhttp Debug:",res);
                // ret(res);
            }
        });
    }

    public static void ret(String res){
        try {
            JSONObject j=new JSONObject(res);
            JSONArray a=j.getJSONArray("contacts");
            JSONObject k=a.getJSONObject(0);
            String s=k.getString("name");
            String st=k.getString("email");
            Log.d("contacts->",s);
            Log.d("contacts->",st);
        }catch (JSONException e){

        }
    }



}
