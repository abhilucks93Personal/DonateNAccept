package com.donatenaccept.dna.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.donatenaccept.dna.R;
import com.donatenaccept.dna.navigation.NavigationActivity;
import com.donatenaccept.dna.utils.Constants;
import com.donatenaccept.dna.utils.Utility;


/**
 * Created by abhi on 17/04/17.
 */

public class SplashActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.setStatusBarTranslucent(this, true);
        ImageView image = new ImageView(this);


        image.setImageDrawable(getResources().getDrawable(R.drawable.splash));
        setContentView(image);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent;
                    if (Utility.getPreferences(SplashActivity.this, Constants.keyLoginCheck, false))
                        intent = new Intent(SplashActivity.this, NavigationActivity.class);
                    else
                        intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        timerThread.start();

    }

}
