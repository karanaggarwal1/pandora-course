package com.example.karan.sharedprefs;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";
    EditText etToSave;
    Button btnSave;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etToSave = (EditText) findViewById(R.id.etToText);
        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", MODE_PRIVATE);
        // if the name doesn't exist it creates an empty file.
        String savedText = sharedPreferences.getString("text", "");
        textView = (TextView) findViewById(R.id.textView);
        etToSave.setText(savedText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToFile("MYFILE", etToSave.getText().toString());
                textView.setText(readFromFile("MYFILE"));
            }
        });
        Log.d(TAG, "data: " + Environment.getDataDirectory().getAbsolutePath());
        Log.d(TAG, "root: " + Environment.getRootDirectory().getAbsolutePath());
        Log.d(TAG, "dl cache: " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d(TAG, "ext storage: " + Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "ext storage music: " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        Log.d(TAG, "filesDir: " + getFilesDir());
        Log.d(TAG, "cacheDir: " + getCacheDir());
        Log.d(TAG, "externalCache: " + getExternalCacheDir());
        Log.d(TAG, "externalFiles Music: " + getExternalFilesDir(Environment.DIRECTORY_MUSIC));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] extDirs = getExternalFilesDirs(null);
            for (File f : extDirs) {
                Log.d(TAG, "extDirs: " + f.getAbsolutePath());
            }
        }

    }
    //shared preferences can store data in internal,external storage as well as in databases
    //direct calling of getFilesDir() will work ionly in MainActivity class because context=ApplicationContext

    /**
     * Shared Preferences help to store primitive data types
     * But if file size is very big, it won't be very useful
     * sometimes the OS itself closes the app in order to free some RAM and hence it does not call on Destroy() so we use onStop() to store data of editText;
     * Shared Preference object is like a file;
     * the app can make multiple preference file
     * name is defined by the user
     * mode defines with what preference the data can be read
     * i.e. whether it is readable by other apps or not
     * like settings which should be visible to some users
     * it is a read only mode object
     * sPref.edit() makes a SharedPreference.editor() class's object
     * either one line statement or make object and call putDATAtype function
     * editor object just makes the transaction ready
     * use apply() or commit()
     * commit() happens in sync
     * commit() returns boolean-true if written successfully and false if otherwise
     * apply() writes not in sync
     * if a lot of data is to be written, then commit() will take a lot of time
     * and if data writing is crucial, then apply() an't make sure if data has been saved or not.
     * to save time, studio makes the statement yellow to warn the user that some time will be taken if commit() is called
     * apply() doesn't return anything
     * stop->start, the app's UI remains intact
     * so we should write data retrieval code in onCreate() however if we write it in onStart(), there will be unnecessary reading of the files of SharedPreferences
     * the app being removed from recent's is being destroyed by the system only, so the system calls onDestroy() too.
     * if the data is saved for other apps to see, it is recommended that use a file instead of SharedPref.
     * getSharedPreferences() creates the file even if it doesn't exist
     * MODE_MULTI_PROCESS, removes any confusion for other apps running in background
     * sPref.edit().putString().putSting() is possible because of fluent api that is each function returns this(object of the same class)
     * in code, external storage is nothing but the internal storage or in built storage
     * SYSTEM PARTITIONS:-
     * /boot partition-linux kernel files are present here-20MB order
     * /system-OS and pre-defined apps are stored here along with information that app is installed or uninstalled they are present here-1.5GB-2GB order, OS size 700-800MB, extra space for OS updates
     * /data-apps that have been installed by us and the data that the apps store-both the pre installed and user installed
     * /data/data-app data is stored
     * /data/apps-apps apk is stored
     * /data/media-emulation is storage/emulated/0
     * /cache if the data is downloaded, it needs to be temporarily stored, it can be cleared temporarily, it is just there to access it in a faster manner-order 700-800MB
     * /storage/emulated/0- the internal storage shown when a phone is connected is stored here in this directory
     * /the app can download data anywhere, but it stores in the above directory, because if it stores it in data/data the package will have a private access modifier and hence it can be modified only by the same app and not by others
     * /the internal storage is the total of all these storages in various directories
     * to write in internal storage, we need permission which has to be defined in the android Manifest
     * /storage/emulated/0-internal sd card
     * /storage/vol-label(the vol-label is by default XXXX-XXXX(VendorId-ProductId notation) where X=any alpha numeric character, name is given if user has provided while formatting,external micro-SD card or OTG storage
     * Android makes an android directory within internal storage
     * within it is also a data folder
     * it contains the folders which will be modified when the app is modified
     * the photos, music are not deleted when an app is uninstalled
     * storing in data/data/package name does not require any extra permission
     * but storage/emulated requires permission
     * a stream is required when the medium through which data is being sent can not accommodate whole of it, the concept of a stream is required
     * speeds can't be controlled artificially
     * to transfer data from a stream, we need a bucket and the buffer acts as the bucket
     * stream- at a time the amount of data is not the size of the buffer, it may be greater than the size of the buffer
     * buffer size can be static, dynamic
     * the scanner object is also a stream.
     * the contents of a stream are on a ram
     * streams are of two types, input and output
     * stream size>=buffer size
     * it is possible that source or stream may not be on the RAM
     * source or sync- size can be finite or infinite or unknown
     * file data read-output stream
     * file data write-output stream
     * the order preference is given to the program, input stream etc is defined wrt it.
     */
    @Override
    protected void onStop() {
        String textToSave = etToSave.getText().toString();
        SharedPreferences sPref = getSharedPreferences("MYPREF", MODE_PRIVATE);
        sPref.edit().putString("text", textToSave).apply();

        super.onStop();
    }

    //return type should be boolean
    //indicating if file writing process was successful or not
    //true means append mode is on
    void writeToFile(String fileName, String data) {
        File filesDir = getFilesDir();
        FileOutputStream fOutStream;
        File fileToWrite = new File(filesDir, fileName);
        try {
            fOutStream = new FileOutputStream(fileToWrite,true);
            fOutStream.write(data.getBytes());
            fOutStream.write('\n');
            fOutStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFromFile(String fileName) {
        File filesDir = getFilesDir();
        File file = new File(filesDir, fileName);
        FileInputStream fInStr;
        try {
            fInStr = new FileInputStream(file);
            InputStreamReader iStrRd = new InputStreamReader(fInStr);
            BufferedReader bufferedReader = new BufferedReader(iStrRd);
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
