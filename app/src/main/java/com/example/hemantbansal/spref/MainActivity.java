package com.example.hemantbansal.spref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernameinput;
    EditText passwordinput;
    TextView htext;
    Button save;
    Button display;
    SharedPrefUtil sharedPrefUtil;
    Person person;
    Person person1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            save=(Button)findViewById(R.id.saved);
        display=(Button)findViewById(R.id.button2);
        usernameinput=(EditText)findViewById(R.id.usernameinput);
        passwordinput=(EditText)findViewById(R.id.passwordinput);
        htext=(TextView) findViewById(R.id.textView4);
        sharedPrefUtil=new SharedPrefUtil(MainActivity.this);
        person1=sharedPrefUtil.display();

       if(!(person1.getPassword()==null&&person1.getUsername()==null)){
            Intent i=new Intent(MainActivity.this,LoggedIn.class);
            startActivity(i);
        }
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedPrefUtil.savedata(usernameinput.getText().toString(),passwordinput.getText().toString());
                       UtilMethods.toastS(MainActivity.this,"Saved");
                        Intent i=new Intent(MainActivity.this,LoggedIn.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        startActivity(i);

                    }
                }
        );

        display.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       person=sharedPrefUtil.display();
                        htext.setText(person.getUsername()+" "+person.getPassword());
                        UtilMethods.toastL(MainActivity.this,"Displayed");
                        //finish();

                    }
                }
        );
    }



}
