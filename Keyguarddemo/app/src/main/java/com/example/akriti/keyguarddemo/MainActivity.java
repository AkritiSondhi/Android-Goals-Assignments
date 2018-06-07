package com.example.akriti.keyguarddemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler.Callback success = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Utility.displayToast(MainActivity.this, "Authentication Successful.");
                        ((TextView)findViewById(R.id.textView)).setText("Authentication Successful.");
                    }
                });
                return false;
            }
        };

        Handler.Callback failure = new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Utility.displayToast(MainActivity.this, "Authentication Cancelled.");
                        ((TextView)findViewById(R.id.textView)).setText("Authentication Cancelled.");
                    }
                });
                return false;
            }
        };

        Utility.showLockedScreen(MainActivity.this, success, failure);
    }

}
