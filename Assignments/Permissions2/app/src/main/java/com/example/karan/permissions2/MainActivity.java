package com.example.karan.permissions2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button PermButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermButton = (Button) findViewById(R.id.PermButton);
        final String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.BATTERY_STATS, Manifest.permission.ACCESS_WIFI_STATE};
        PermButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermManager.askForPermission(MainActivity.this, permissions, new PermManager.OnPermissionResultListener() {
                    @Override
                    public void onGranted(String PermName) {
                        Toast.makeText(MainActivity.this, "Request for " + PermName + " GRANTED", Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onDenied(String PermName) {
                        Toast.makeText(MainActivity.this, "Request for " + PermName + " DENIED", Toast.LENGTH_SHORT);
                    }
                });
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermManager.onPermResult(requestCode,permissions,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
