package com.example.hemantbansal.spref;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dialogs extends AppCompatActivity {

    private Button openDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        openDialog = (Button) findViewById(R.id.OpenDialog);

        openDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog alertDialog = new AlertDialog.Builder(Dialogs.this)
                        .setTitle("This is title")
                        .setMessage("this is message for thr dishflkdshf")
                        .setPositiveButton("show Toast", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                UtilMethods.toastS(Dialogs.this,"Positive response");
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Dialogs.this.finish();
                            }
                        })
                        .create();

                alertDialog.show();

            }
        });


    }
}
