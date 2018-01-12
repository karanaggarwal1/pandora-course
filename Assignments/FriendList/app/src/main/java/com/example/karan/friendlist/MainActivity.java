package com.example.karan.friendlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_title;
    ArrayList<Friend> friend_list=new ArrayList<>();
    Button btn_add_post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTv_title();
        Adapter adapter=new Adapter(friend_list,this);
        btn_add_post=(Button)findViewById(R.id.btn_add_post);
        btn_add_post.setOnClickListener(this);
    }
    public void setTv_title(){
        tv_title=(TextView)findViewById(R.id.tv_title);
        tv_title.setText("Friend List");
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_add_post){
            Intent i=new Intent(MainActivity.this,take_input.class);
            startActivityForResult(i,233);
            /*String name=i.getStringExtra("name");
            int age=i.getIntExtra("age",0);
            String college=i.getStringExtra("college");
            String temp=i.getStringExtra("image");
            Uri image=Uri.parse(temp);
            friend_list.add(new Friend(name,age,college,image));*/
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==234){
            if(resultCode==RESULT_OK){
                String name=data.getStringExtra("name");
                int age=data.getIntExtra("age",0);
                String college=data.getStringExtra("college");
                String temp=data.getStringExtra("image");
                Uri image=Uri.parse(temp);
                friend_list.add(new Friend(name,age,college,image));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
