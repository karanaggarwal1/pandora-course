package com.example.karan.permissions2;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Karan on 15-01-2017.
 */

public class PermManager {
    private static OnPermissionResultListener Soprl;

    static void askForPermission(Activity activity, String[] permission, OnPermissionResultListener oprl) {
        Soprl = oprl;
        ActivityCompat.requestPermissions(activity, permission, 111);
    }

    static void onPermResult(int requestCode, String[] perms, int[] resCodes) {
        if (requestCode == 111) {
            for (int i = 0; i < perms.length; i++) {
                if (resCodes[i] == PackageManager.PERMISSION_GRANTED) {
                    Soprl.onGranted(perms[i]);
                } else {
                    Soprl.onDenied(perms[i]);
                }
            }
        }

    }

    interface OnPermissionResultListener {
        void onGranted(String PermName);

        void onDenied(String PermName);
    }
}
