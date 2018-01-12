package com.example.karan.studentlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students = new ArrayList<>();
    ListView lvStudent;
    Adapter slAdapter = new Adapter(students, this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, add_post.class), 234);
            }
        });

        lvStudent=(ListView)findViewById(R.id.lvStudent);
        lvStudent.setAdapter(slAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 234) {
            if (resultCode == RESULT_OK) {
                Student tobeAdded = new Student(data.getStringExtra("name"), data.getStringExtra("course"), data.getIntExtra("age", 0));
                students.add(tobeAdded);
                slAdapter.notifyDataSetChanged();
            }
        }
    }
}
