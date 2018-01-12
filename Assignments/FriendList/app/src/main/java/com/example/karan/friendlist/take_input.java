package com.example.karan.friendlist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;

public class take_input extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_IMAGE_REQUEST = 1;
    public Intent i = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_input);
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_age = (EditText) findViewById(R.id.et_age);
        EditText et_college = (EditText) findViewById(R.id.et_college);
        int age = Integer.parseInt(et_age.getText()+"");
        String name = et_name.getText() + "";
        String college = et_college.getText() + "";
        i.putExtra("name", name);
        i.putExtra("age", age);
        i.putExtra("college", college);
        setResult(RESULT_OK,i);
        ImageButton btn_image_add = (ImageButton) findViewById(R.id.btn_add_image);
        btn_image_add.setOnClickListener(this);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ImageView imageView = (ImageView) findViewById(R.id.btn_add_image);
                imageView.setImageBitmap(bitmap);
                i.putExtra("uri", uri);
            } catch (IOException e) {

            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        setResult(RESULT_OK, i);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }
}

