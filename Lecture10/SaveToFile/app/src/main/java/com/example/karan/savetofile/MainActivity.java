package com.example.karan.savetofile;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "PERMS";
    private static final int PERM_REQ_CODE = 0;
    EditText editText;
    Button btnSave;
    //normal and dangerous permissions

    /**
     * Dangerous permissions are categorised on the basis of acces of privacy i.e. private data e.g. reading phone data, only body sensors, external storage read, write etc
     * permissions are  disabled at the group level i.e reading and writing of contacts can't be in separate levels.
     * however we need to ask all permissions within a group separately.
     * dialog box however comes in a single box.
     * dialog box that asks for reading and writing contacts is completely identical.
     * cases:given permission, asking permission, given but disabled later permission.
     * checkSelfPermission() was introduced in API 23
     * this will not work in lower versions, otherwise it can be used directly in an activity
     * hence we use ContextCompat,android support library
     * but if we put the permission checking code in onCreate we don't need to override onRequestPermissionResult() if there is the permission it would run otherwise it would show a toast.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int perm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (perm == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, PERM_REQ_CODE);
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Give the bloody permission", Toast.LENGTH_SHORT).show();
        }
        editText = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToFile("MYFILE", editText.getText().toString());
            }
        });
    }

    /**
     * since ContextCompat.checkSelfPermission() is a static function we need to pass the context in which we are using it
     * It return an integer
     * use directly request permissions if you are extending AppCompatActivity
     * now when the dialog box has been displayed, the result will be processed in onRequestPermissionResult() function and those various permissions can be managed single handedly by this function
     * through the request code that is
     * a toast is also asynchronous
     */
    private void writeToFile(String filename, String data) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, "You don't have permission to write.", Toast.LENGTH_LONG).show();
            return;
        }
        ;
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
            Log.e(TAG, "writeToFile: " + e);
        }
    }
    //size of permissions[] and grantResults[] is same

    /**
     * ask for all permission required for a particular activity
     * we could store the data in global variables, but that can lead to synchronization problems
     * also calling it would insert a new dialog box again
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == PERM_REQ_CODE) {
//            for (int i = 0; i < permissions.length; i++) {
//                if (permissions[i].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    grantResults[i] == PackageManager.PERMISSION_GRANTED ? writeToFile() : Toast.makeText(this, "File could not be saved because permission was not granted", Toast.LENGTH_LONG).show();
//                }
//            }
//        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
