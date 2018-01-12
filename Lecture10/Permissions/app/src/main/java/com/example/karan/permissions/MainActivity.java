package com.example.karan.permissions;

import android.Manifest;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Permman.askForPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE, new Permman.OnPermissionResultListener() {
                    @Override
                    public void onGranted() {
                        writeToFile("MYFILE",editText.getText().toString());
                    }

                    @Override
                    public void onDenied() {
                        Toast.makeText(MainActivity.this,"No permission",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void writeToFile(String filename, String data){
        File fileToWrite = new File(
                Environment.getExternalStorageDirectory(),
                filename);
        try {
            FileOutputStream fOutStream = new FileOutputStream(
                    fileToWrite,
                    true);
            fOutStream.write(data.getBytes());//no need for buffer, because this data is already in the memory,the problem of buffering arises because we can't put all of the data together on the RAM.
            fOutStream.close();//to prevent memory leaks, to close the lock we put on this process to use this file
        } catch (IOException e) {
            Log.e("PERMS", "writeToFile: " + e);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Permman.onPermResult(requestCode,permissions,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
