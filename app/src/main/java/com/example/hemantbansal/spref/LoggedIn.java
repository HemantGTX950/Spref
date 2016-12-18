package com.example.hemantbansal.spref;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedIn extends AppCompatActivity {
Person p;
    SharedPrefUtil sharedPrefUtil;
    TextView username;
    TextView password;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        username=(TextView)findViewById(R.id.Lusername);
        password=(TextView)findViewById(R.id.Lpassword);
        logout=(Button)findViewById(R.id.LogOut);
        sharedPrefUtil=new SharedPrefUtil(this);
        p=sharedPrefUtil.display();
        username.setText(p.getUsername());
        password.setText(p.getPassword());

        logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedPrefUtil.delete();
                        UtilMethods.toastS(LoggedIn.this,"Logging out");
                        Intent i=new Intent(LoggedIn.this,MainActivity.class);
                        startActivity(i);

                    }
                }


        );

    }
}
