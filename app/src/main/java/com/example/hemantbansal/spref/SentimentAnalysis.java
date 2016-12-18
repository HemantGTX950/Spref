package com.example.hemantbansal.spref;

import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SentimentAnalysis extends AppCompatActivity  {
    Button check;
    EditText input;
    TextView outtype, outperc,proxitext;

    int f=0;




    final String url1 = "https://api.havenondemand.com/1/api/sync/analyzesentiment/v2?text=";
    final String url2 = "&language=eng&apikey=c48eeb88-ba03-421a-b0b6-faf03c9f4443";


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //*************************


        setContentView(R.layout.activity_sentiment_analysis);
        check = (Button) findViewById(R.id.senti_btn1);
        input = (EditText) findViewById(R.id.senti_text_inp);
        outperc = (TextView) findViewById(R.id.senti_out_percent);
        outtype = (TextView) findViewById(R.id.senti_out_type);
        check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String txt = input.getText().toString();
                        String s1 = url1 + txt + url2;

                        s1 = s1.replaceAll(" ", "%20");
                        if (UtilMethods.isNetConnected(SentimentAnalysis.this)) {
                            makingcall(s1);
                        } else {
                            final AlertDialog alertDialog = new AlertDialog.Builder(SentimentAnalysis.this)
                                    .setTitle("Network Error!")
                                    .setMessage("Check the internet Connection & try again")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            //  dialog.cancel();
                                        }
                                    })
                                    .create();
                            alertDialog.show();
                        }
                    }
                }
        );


    }


    public void makingcall(final String text) {
        Request request = new Request.Builder()
                .get()
                .url((text))
                .build();


        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(
                new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        Log.d("Failed:", "onFailure");

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String res = response.body().string();
                        try {
                            JSONObject full = new JSONObject(res);
                            JSONArray jsonArray = full.getJSONArray("sentiment_analysis");
                            full = jsonArray.getJSONObject(0);
                            full = full.getJSONObject("aggregate");
                            final String senti = full.getString("sentiment");
                            final String scr = full.getString("score");

                            if (!senti.equals("neutral")) {

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Double k = Double.parseDouble(scr.substring(0, 5));
                                        k = k * 100;
                                        String l = k.toString().substring(0, 4);
                                        outtype.setText("Sentence is: " + senti);
                                        outperc.setText("with score of: " + l);
                                    }
                                });
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        outtype.setText("It is a Neutral Sentence");
                                    }
                                });

                            }
                            //Log.d("result1:",s);

                        } catch (JSONException e) {
                            Log.d("Json Expection:-", "failed");
                        }
                        Log.d("url:", text);
                        Log.d("result:", res);

                    }
                }
        );
    }



}
