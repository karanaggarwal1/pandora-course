package com.example.karan.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Karan on 15-01-2017.
 */
//if an object b calls the methods of
public class Permman {
    private static OnPermissionResultListener Soprl;

    static void askForPermission(Activity activity, String permission, OnPermissionResultListener oprl) {
        Soprl = oprl;
        ActivityCompat.requestPermissions(activity, new String[]{permission}, 111);
    }

    static void onPermResult(int requestCode, String[] perms, int[] resCodes) {
        if (requestCode == 111) {
            if (resCodes[0] == PackageManager.PERMISSION_GRANTED) {
                Soprl.onGranted();
            } else {
                Soprl.onDenied();
            }
        }

    }
    interface OnPermissionResultListener {
        void onGranted();

        void onDenied();
    }
}
