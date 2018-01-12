package com.example.karan.locationservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public static final String TAG = "LOCATION";
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d(TAG, "onLocationChanged: " + location.getLatitude());
                Log.d(TAG, "onLocationChanged: " + location.getLongitude());
                Log.d(TAG, "onLocationChanged: " + location.getAltitude());
                Log.d(TAG, "onLocationChanged: " + location.getBearing());
                Log.d(TAG, "onLocationChanged: " + location.getSpeed());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                //mode wifi 3g enabled disabled
                //location disabled
                Log.d(TAG, "onProviderEnabled: " + provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d(TAG, "onProviderDisabled: ");
            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                    }, 121);
        } else {
            locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    1000,
                    10,
                    locationListener
            );
        }


    }

    /**
     * Location is partly in android and partly supported by location
     * PASSIVE_PROVIDER finds out in what city you are by IP manager,existing data
     * ACTIVE_PROVIDER-where you are using current data
     * long minTime-after how much time we want to register changes
     * it will get updates even if distance has changed in between them
     * float minDistance-it will get updates even if time is less than what specified
     * google registers heavily used mobile hotspots
     * why do we need location?
     * precise or not precise location required
     * how frequently do we want the changes in the location
     * distance and time can be used as sampling period
     * GPS
     * GLONASS
     * BHUVAN
     * our phone can't send satellite signals
     * it can only receive signals
     * there are various signals through which wave is formed by performing phase addition
     * we can only determine location only by using the type of signal
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 121) {
            Toast.makeText(this, "BLA", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
