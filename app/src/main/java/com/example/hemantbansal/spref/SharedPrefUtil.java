package com.example.hemantbansal.spref;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

/**
 * Created by Hemant Bansal on 10/4/2016.
 */

public class SharedPrefUtil implements ConstantUtil {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public SharedPrefUtil(Context context) {
        sharedPreferences=context.getSharedPreferences(SHAREDPREFFILE,Context.MODE_PRIVATE);
         editor=sharedPreferences.edit();
    }
    public void savedata(String username,String pwd){
        editor.putString(ID,username);
        editor.putString(PW_,pwd);
        editor.apply();

    }
    public Person display(){
        String name=sharedPreferences.getString("username",null);
        String pw=sharedPreferences.getString("password",null);
        return new Person(name,pw);
    }
    public void delete(){
        editor.clear().apply();
    }



}

