package com.example.karan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second_activity extends AppCompatActivity {
    EditText etStr;
    Button btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Intent x=getIntent();
        String str=x.getStringExtra("name");
        etStr= (EditText) findViewById(R.id.etText);

        btnClose=(Button)findViewById(R.id.button2);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=etStr.getText().toString();
                Intent i=new Intent();
                i.putExtra("result",str);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
