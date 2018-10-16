package com.example.akriti.appwidgetdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChampInfoActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champ_info);

        Intent intent = getIntent();
        String selectedChamp = intent.getStringExtra(Constants.SELECTED_CHAMP);

        setUpView(selectedChamp);
    }

    private void setUpView(String selectedChamp) {
        TextView title = findViewById(R.id.title);
        TextView subTitle = findViewById(R.id.subTitle);

        switch (selectedChamp) {
            case Constants.AKALI: {
                title.setText(Constants.AKALI);
                subTitle.setText(Constants.AKALI_SUBTITLE);
                break;
            }

            case Constants.CAITLYN: {
                title.setText(Constants.CAITLYN);
                subTitle.setText(Constants.CAITLYN_SUBTITLE);
                break;
            }

            case Constants.DRAVEN: {
                title.setText(Constants.DRAVEN);
                subTitle.setText(Constants.DRAVEN_SUBTITLE);
                break;
            }

            case Constants.GNAR: {
                title.setText(Constants.GNAR);
                subTitle.setText(Constants.GNAR_SUBTITLE);
                break;
            }

            case Constants.GRAVES: {
                title.setText(Constants.GRAVES);
                subTitle.setText(Constants.GRAVES_SUBTITLE);
                break;
            }

            case Constants.IRELIA: {
                title.setText(Constants.IRELIA);
                subTitle.setText(Constants.IRELIA_SUBTITLE);
                break;
            }

            case Constants.KAYN: {
                title.setText(Constants.KAYN);
                subTitle.setText(Constants.KAYN_SUBTITLE);
                break;
            }

            case Constants.LUCIAN: {
                title.setText(Constants.LUCIAN);
                subTitle.setText(Constants.LUCIAN_SUBTITLE);
                break;
            }

            case Constants.ORIANNA: {
                title.setText(Constants.ORIANNA);
                subTitle.setText(Constants.ORIANNA_SUBTITLE);
                break;
            }

            case Constants.ZOE: {
                title.setText(Constants.ZOE);
                subTitle.setText(Constants.ZOE_SUBTITLE);
                break;
            }

            default: {
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAndRemoveTask();
        this.finishAffinity();
    }
}