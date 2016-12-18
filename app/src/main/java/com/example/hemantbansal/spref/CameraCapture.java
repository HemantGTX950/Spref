package com.example.hemantbansal.spref;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;

public class CameraCapture extends AppCompatActivity {
    private static final int TAKE_PICTURE=1;
    private Uri imageUri;
    Button imgButton;
    ImageView productImage;
    EditText usernameinput;
    EditText passwordinput;
    Button save;
    Button display;
    SharedPrefUtil sharedPrefUtil;
    Person person;
    Person person1;
    TextView htext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_capture);

        imgButton=(Button)findViewById(R.id.imageBtn);
        productImage=(ImageView)findViewById(R.id.prdImage);

        imgButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        android.content.Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,TAKE_PICTURE);
                    }
                }
        );
        save=(Button)findViewById(R.id.saved);
        display=(Button)findViewById(R.id.button2);
        usernameinput=(EditText)findViewById(R.id.usernameinput);
        passwordinput=(EditText)findViewById(R.id.passwordinput);
        htext=(TextView) findViewById(R.id.textView4);
        sharedPrefUtil=new SharedPrefUtil(CameraCapture.this);
        person1=sharedPrefUtil.display();

        if(!(person1.getPassword()==null&&person1.getUsername()==null)){
            Intent i=new Intent(CameraCapture.this,LoggedIn.class);
            startActivity(i);
        }
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedPrefUtil.savedata(usernameinput.getText().toString(),passwordinput.getText().toString());
                        UtilMethods.toastS(CameraCapture.this,"Saved");
                        Intent i=new Intent(CameraCapture.this,LoggedIn.class);
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
                        UtilMethods.toastL(CameraCapture.this,"Displayed");
                        //finish();

                    }
                }
        );



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //from camera

        switch (requestCode) {
            case TAKE_PICTURE:
                if (resultCode == Activity.RESULT_OK) {


                    Bitmap uri = (Bitmap) data.getExtras().get("data");

                    Log.d("Uri is",uri.toString());
                    productImage.setImageBitmap(uri);

                }
        }

    }

}
