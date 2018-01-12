package com.example.karan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,second_activity.class);
//                String name=textView.getText().toString();
//                i.putExtra("name",name);
                startActivityForResult(i,234);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==234){
            if(resultCode==RESULT_OK){
                textView.setText(data.getStringExtra("result"));
            }
        }
    }
    //explicit and implicit intents
    //explicitly mentioning an intent like specifying the name of the component to be accessed
    //implicit intent-specifying the task and the OS handles as to how to go about doing it
    //broadcasts like charging is detected can also be handled by intents
    //writing just this, would refer to the nearest new class, and in this case it would refer to the OnClickListener class
    //because the activity class extends a context, it is possible to pass an activity as a context
}
