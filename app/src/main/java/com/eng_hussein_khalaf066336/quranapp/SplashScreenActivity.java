package com.eng_hussein_khalaf066336.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageView_background,imageView_qurain,imageView_qurain2,imageView_noInternet;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView_background = findViewById(R.id.SplashScreen_imageView_background);
        imageView_qurain = findViewById(R.id.SplashScreen_imageView_qurain);
        imageView_qurain2 = findViewById(R.id.SplashScreen_imageView_qurain2);
        lottieAnimationView = findViewById(R.id.animationView);
        imageView_noInternet = findViewById(R.id.SplashScreen_imageView_noInternet);

        imageView_background.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        imageView_qurain.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        imageView_qurain2.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);

        if (isConnected(this)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 4500);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imageView_noInternet.setVisibility(View.VISIBLE);

                }
            }, 4300);

        }
    }

    private boolean isConnected(SplashScreenActivity SplashScreenActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) SplashScreenActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());
    }
}
