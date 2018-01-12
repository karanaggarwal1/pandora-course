package com.example.karan.browserdialer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnBrowse, btnDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnDial = (Button) findViewById(R.id.btnDial);
        View.OnClickListener buttonClicked = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                switch (view.getId()) {
                    case R.id.btnBrowse:

                        String tobecomp = ((EditText) findViewById(R.id.editText)).getText().toString();
                        if (tobecomp.length() >= 7) {
                            String temp = tobecomp.substring(0, 7);
                            if (!temp.equals("http://")) {
                                String x = "http://";
                                x.concat(tobecomp);
                                tobecomp = x;
                            }
                            i = new Intent(Intent.ACTION_VIEW, Uri.parse(tobecomp));
                            i.putExtra("uri browse", tobecomp);
                            startActivity(i);
                            i = new Intent(MainActivity.this, second_activity.class);
                            startActivity(i);
                        }
                        break;
                    case R.id.btnDial:
                        String tobecomp2 = ((EditText) findViewById(R.id.editText)).getText().toString();
                        if (tobecomp2.length() >= 4) {
                            String temp2 = tobecomp2.substring(0, 4);
                            if (!temp2.equals("tel:")) {
                                String x = "tel:";
                                x.concat(tobecomp2);
                                tobecomp = x;
                            }
                            i = new Intent(Intent.ACTION_DIAL, Uri.parse(tobecomp2));
                            i.putExtra("uri dial", tobecomp2);
                            startActivity(i);
                            i = new Intent(MainActivity.this, second_activity.class);
                            startActivity(i);
                        }
                        break;
                }
                //data android:scheme is the protocol used to filter the intent according to use
                //for example:http://google.com/search/?q=hello here http is the scheme google.com is the domain name search is the path.
            }
        };
        btnBrowse.setOnClickListener(buttonClicked);
        btnDial.setOnClickListener(buttonClicked);
    }
}
