package com.example.akriti.googleadsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardedVideoAdActivity extends AppCompatActivity {

    private RewardedVideoAd mRewardedVideoAd;
    private String TAG = RewardedVideoAdActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded_video_ad);

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewarded! currency: " + rewardItem.getType() + "  amount: " +
                        rewardItem.getAmount(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewarded! currency: " + rewardItem.getType() + "  amount: " +
                        rewardItem.getAmount());
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoAdLeftApplication",
                        Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoAdLeftApplication");
            }

            @Override
            public void onRewardedVideoAdClosed() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoAdClosed");
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int errorCode) {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoAdFailedToLoad");
            }

            @Override
            public void onRewardedVideoCompleted() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoCompleted");
            }

            @Override
            public void onRewardedVideoAdLoaded() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoAdLoaded");
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoAdOpened");
            }

            @Override
            public void onRewardedVideoStarted() {
                Toast.makeText(RewardedVideoAdActivity.this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onRewardedVideoStarted");
            }
        });

        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(getString(R.string.rewarded_video),
                new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        // Check the LogCat to get your test device ID
                        .addTestDevice("add_your_test_device_id_here_from_logs")
                        .build());

        // showing the ad to user
        showRewardedVideo();
    }

    private void showRewardedVideo() {
        // make sure the ad is loaded completely before showing it
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }
}
