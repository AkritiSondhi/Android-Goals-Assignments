package com.example.akriti.keyguarddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Akriti on 6/1/2018.
 */

public class Utility {

    // success and failure callbacks to manage the flow of application when locked screen is to be shown.
    public static volatile Handler.Callback screenLockSuccess;
    public static volatile Handler.Callback screenLockFailure;

    public static void showLockedScreen(Activity activity, Handler.Callback success,
                                         Handler.Callback failure) {
        screenLockSuccess = success;
        screenLockFailure = failure;

        Intent intent = new Intent(activity, LockScreenActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    public static void displayToast(Activity activity, String message) {
        Toast toast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
