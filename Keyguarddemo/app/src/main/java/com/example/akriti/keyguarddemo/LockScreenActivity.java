package com.example.akriti.keyguarddemo;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

public class LockScreenActivity extends Activity {

    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        KeyguardManager keyguardManager = (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE);
        Intent intent = keyguardManager.createConfirmDeviceCredentialIntent("User Authentication Required",
                "Please use your device password to continue.");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE) {
            new HandleOnActivityResultAsyncTask().execute(resultCode);
            finish();
        }
    }

    private class HandleOnActivityResultAsyncTask extends AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer... param) {

            Integer resultCode = param[0];

            // user authentication was successful.
            if (resultCode == Activity.RESULT_OK) {
                if (Utility.screenLockSuccess != null) {
                    Utility.screenLockSuccess.handleMessage(null);
                }
            }
            // user cancelled the screen unlock prompt.
            else {
                if (Utility.screenLockFailure != null) {
                    Utility.screenLockFailure.handleMessage(null);
                }
            }

            return null;
        }
    }
}