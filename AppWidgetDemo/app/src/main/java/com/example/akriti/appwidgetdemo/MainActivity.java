package com.example.akriti.appwidgetdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getExtras() != null) {
            String selectedOption = getIntent().getExtras().getString(WidgetProvider.EXTRA_STRING);

            if (getIntent() != null && getIntent().getExtras() != null
                    && getIntent().getExtras().getString(WidgetProvider.EXTRA_STRING) != null) {
                Toast.makeText(this, "Opened " + selectedOption,
                        Toast.LENGTH_LONG).show();

                if (selectedOption != null) {
                    Intent intent = new Intent(MainActivity.this, ChampInfoActivity.class);
                    intent.putExtra(Constants.SELECTED_CHAMP, selectedOption);
                    startActivity(intent);
                }
            }
        }
    }
}