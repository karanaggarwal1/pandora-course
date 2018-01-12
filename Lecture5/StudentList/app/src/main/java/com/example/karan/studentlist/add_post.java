package com.example.karan.studentlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_post extends AppCompatActivity {
    Button btnOK;
    EditText etName,etCourse,etAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        btnOK=(Button)findViewById(R.id.btnOK);
        etAge=(EditText)findViewById(R.id.etAge);
        etName=(EditText)findViewById(R.id.etName);
        etCourse=(EditText)findViewById(R.id.etCourse);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=etName.getText().toString();
                String temp=etAge.getText().toString();
                int age=Integer.valueOf(temp);
                String course=etCourse.getText().toString();
                Intent i=new Intent();
                i.putExtra("name",name);
                i.putExtra("course",course);
                i.putExtra("age",age);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
